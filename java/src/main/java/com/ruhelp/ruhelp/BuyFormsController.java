package com.ruhelp.ruhelp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ruhelp.ruhelp.core.emprestar.Emprestar;
import com.ruhelp.ruhelp.core.emprestar.EmprestarDao;
import com.ruhelp.ruhelp.core.session.Session;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class BuyFormsController {
    SceneUtils sceneUtils = new SceneUtils();
    private static int codigo;
    private static Long cpf2;

   /* EmprestarDao emprestaDao = EmprestarDao.getInstance();
    Emprestar e = emprestaDao.findByCodigo(codigo);*/

    public static void setCpf2(Long cpf2) {
        BuyFormsController.cpf2 = cpf2;
    }

    @FXML private Label nomeBuy;
    @FXML private Label categoriaBuy;
    @FXML private Label valorBuy;
    @FXML private Label diaSemanaBuy;
    @FXML private Label horarioBuy;
    
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    @FXML
    public void initialize() throws SQLException {
        Connection c = Conexao.getConexao();
        // busca um emprestimo através de um codigoDisp
        String query = "select * from emprestar where pk_codDisp = ?";
        //String query = "select usuario.nome, usuario.categoria, emprestar.pk_codDisp, emprestar.horario, emprestar.diaSemana from usuario, emprestar where usuario.pk_cpf = emprestar.pkfk_cpf and emprestar.pk_codDisp = ?";
        PreparedStatement stmt = c.prepareStatement(query);
        stmt.setInt(1, codigo);
        ResultSet rs = stmt.executeQuery();
        // a partir do cpf encontrar usuario ( nome, cpf, categoria
        query = "select pk_cpf,nome,categoria from usuario where pk_cpf = ?";
        stmt = c.prepareStatement(query);
        if(rs.next())
        stmt.setLong(1, Long.parseLong(rs.getString("pkfk_cpf")));
        ResultSet rs2 = stmt.executeQuery();

        // rs2 = ( nome, cpf, categoria);
        if(rs2.next()){

            /*Emprestar e = new Emprestar(Integer.parseInt(rs.getString("pk_codDisp")),rs.getString("nome") , rs.getString("categoria"), rs.getString("diaSemana"),rs.getString("horario"));*/

        
            nomeBuy.setText(rs2.getString("nome").trim());
            categoriaBuy.setText(rs2.getString("categoria").trim());
            diaSemanaBuy.setText(rs.getString("diaSemana").trim());
            horarioBuy.setText(rs.getString("horario").trim());
            if(rs2.getString("categoria").trim().equals("P1")){
                valorBuy.setText("R$7.50");
            }else{
                valorBuy.setText("R$12.00");
            }
            this.setCpf2(Long.parseLong(rs2.getString("pk_cpf")));
        }   
    }

    @FXML
    public void enviar(MouseEvent event) throws SQLException {
        try {
            Session s = Session.getInstance();
            Connection c = Conexao.getConexao();
            String query = "insert into solicitar (pkfk_cpf,pkfk_cpf2,pkfk_codDisp) values (?,?,?)";
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setLong(1, s.getUser().getCpf());
            stmt.setLong(2, this.cpf2);
            stmt.setInt(3, codigo);
            stmt.executeUpdate();
            sceneUtils.SetScene(event, "home.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// CONSUNTANDO EMPRESTIMO, CONSULTANDO USUARIO E ENVIANDO UMA SOLICITAÇÃO;
