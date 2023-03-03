package com.ruhelp.ruhelp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ruhelp.ruhelp.core.session.Session;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class HistoricController {

    @FXML private VBox list;

    @FXML private void initialize() throws SQLException, IOException{

        Session s = Session.getInstance();
        Connection c = Conexao.getConexao();
        
        String query = "Select fk_cpf2,dataEmprestimo from emprestar where pkfk_cpf = ? and fk_cpf2 is not null";
        PreparedStatement stmt = c.prepareStatement(query);
        stmt.setLong(1, s.getUser().getCpf());
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            query = "Select nome,categoria from usuario where pk_cpf = ?";
            stmt = c.prepareStatement(query);
            stmt.setLong(1, Long.parseLong(rs.getString("fk_cpf2")));
            ResultSet rs2 = stmt.executeQuery();
            if(rs2.next()){
                FXMLLoader box = new FXMLLoader(getClass().getResource("historic_box.fxml"));
                BorderPane boxpane = box.load();

                Node name = boxpane.lookup("#name");
                ((Label) name).setText(rs2.getString("nome").trim());

                Node card = boxpane.lookup("#cardtype");
                ((Label) card).setText(rs2.getString("categoria").trim());

                Node date = boxpane.lookup("#date");
                ((Label) date).setText(rs.getString("dataEmprestimo"));
    
                list.getChildren().add(boxpane);
            }
        }
    }
}