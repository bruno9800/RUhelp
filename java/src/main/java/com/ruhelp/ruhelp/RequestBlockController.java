package com.ruhelp.ruhelp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ruhelp.ruhelp.core.session.Session;

import javafx.event.Event;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class RequestBlockController {
    @FXML
    private void accept(MouseEvent event) throws IOException, SQLException {
        BorderPane bp = getBP(event);
        String id = bp.getId();

        //  CÓDIGO PARA EXCLUIR DO BANCO DE DADOS
        Session session = Session.getInstance();


        Connection con = Conexao.getConexao();
        String query="Select * from solicitar where pkfk_codDisp = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, Integer.parseInt(id));
        ResultSet rs = stmt.executeQuery();

        query = "UPDATE emprestar SET fk_cpf2 = ?, dataEmprestimo = ? WHERE pk_codDisp = ?";        
        stmt = con.prepareStatement(query);
        if(rs.next()){
        stmt.setLong(1, Long.parseLong(rs.getString("pkfk_cpf")));
        // data atual
        long millis=System.currentTimeMillis();  
        Date date = new Date(millis);
        stmt.setDate(2, date);
        stmt.setInt(3, Integer.parseInt(id));
        stmt.executeUpdate();

        query = "Delete from solicitar where pkfk_cpf = ? and pkfk_cpf2 = ? and pkfk_codDisp = ?";
        stmt = con.prepareStatement(query);
        stmt.setLong(1, Long.parseLong(rs.getString("pkfk_cpf")));
        stmt.setLong(2,session.getUser().getCpf());
        stmt.setInt(3, Integer.parseInt(id));
        stmt.executeUpdate();
        
        
        System.out.println("Aceito!!" + id);

        VBox vbox = (VBox) bp.getParent();
        vbox.getChildren().remove(bp);
        }
    }

    
    @FXML
    private void ignore(MouseEvent event) throws IOException, SQLException {
        BorderPane bp = getBP(event);
        String id = bp.getId();

        Session session = Session.getInstance();


        Connection con = Conexao.getConexao();
        String query="Select * from solicitar where pkfk_codDisp = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, Integer.parseInt(id));
        ResultSet rs = stmt.executeQuery();



        if(rs.next()){
            query = "Delete from solicitar where pkfk_cpf = ? and pkfk_cpf2 = ? and pkfk_codDisp = ?";
            stmt = con.prepareStatement(query);
            stmt.setLong(1, Long.parseLong(rs.getString("pkfk_cpf")));
            stmt.setLong(2,session.getUser().getCpf());
            stmt.setInt(3, Integer.parseInt(id));
            stmt.executeUpdate();
            
            
            System.out.println("Ignorado!!" + id);

            VBox vbox = (VBox) bp.getParent();
            vbox.getChildren().remove(bp);
        }

    }
    private BorderPane getBP(Event event){
        Button accept_btn = (Button) event.getSource();
        Parent request_block = accept_btn.getParent().getParent();

        return (BorderPane) request_block;
    }
}
