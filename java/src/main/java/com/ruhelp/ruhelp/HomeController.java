package com.ruhelp.ruhelp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.ruhelp.ruhelp.core.emprestar.Emprestar;
import com.ruhelp.ruhelp.core.emprestar.EmprestarDao;
import com.ruhelp.ruhelp.core.session.Session;
import com.ruhelp.ruhelp.core.users.ListarDisponiveis;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HomeController {
    SceneUtils sceneUtils = new SceneUtils();

    @FXML VBox available_container;
    @FXML VBox request_container;
    @FXML private Label username;
    // metodo que retorna String a partir de um Cpf
    @FXML
    public void initialize() throws IOException, SQLException {
        Session sessao = Session.getInstance();
        
        username.setText("Olá, "+ sessao.getUser().getNome());

        populateAvailable();
        populateRequest();
    }

    private void populateAvailable() throws IOException, SQLException {
        //Session s = Session.getInstance();
        //ResultSet rs = ListarDisponiveis.list(s.getUser().getCpf());
        EmprestarDao emprestaDao = EmprestarDao.getInstance();
        //emprestaDao.AtualizarInstance();
        for( Emprestar e : emprestaDao.getDisponiveis()){
            // Emprestar e = new Emprestar(Integer.parseInt(rs.getString("pk_codDisp")) , rs.getString("nome"), rs.getString("categoria"), rs.getString("diaSemana"), rs.getString("horario"));
            FXMLLoader box = new FXMLLoader(getClass().getResource("available_block.fxml"));
            BorderPane boxpane = box.load();
            
            Node img = boxpane.lookup("#img");
            //((ImageView) img).setText("asd");

            Node name = boxpane.lookup("#name");
            ((Label) name).setText(e.getName());

            Node card = boxpane.lookup("#cardtype");
            ((Label) card).setText(e.getcategoria());

            boxpane.setId(Integer.toString(e.getCodigo()));
            
            available_container.getChildren().add(boxpane);
            
        }
    }

    private void populateRequest() throws IOException, SQLException {
        Connection c = Conexao.getConexao();
        Session s = Session.getInstance();
        String query = "select * from solicitar where pkfk_cpf2 = ?";
        PreparedStatement stmt = c.prepareStatement(query);
        stmt.setLong(1, s.getUser().getCpf());
        ResultSet rs = stmt.executeQuery();
        query = "select nome from usuario where pk_cpf = ?";
        stmt = c.prepareStatement(query);
        if(rs.next()) {
            stmt.setLong(1, Long.parseLong(rs.getString("pkfk_cpf")));
            ResultSet rs2 = stmt.executeQuery();
            while(rs2.next()){
                FXMLLoader box = new FXMLLoader(getClass().getResource("request_block.fxml"));
                BorderPane boxpane = box.load();

                Node img = boxpane.lookup("#img");
                //Image image = new Image("url_of_file");
                //((ImageView) img).setImage(image);

                Node name = boxpane.lookup("#name");
                ((Label) name).setText(rs2.getString("nome"));

                request_container.getChildren().add(boxpane);
            }
        }

    }
    

    @FXML
    private void emprestar(MouseEvent event) {
        try {
            sceneUtils.SetScene(event, "provide.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    }
