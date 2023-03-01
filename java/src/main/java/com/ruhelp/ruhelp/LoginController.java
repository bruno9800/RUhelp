package com.ruhelp.ruhelp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.Console;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ruhelp.ruhelp.Conexao;

public class LoginController {
    @FXML
    private TextField cpfLogin;

    @FXML
    private PasswordField senhaLogin;

    @FXML
    private Label test;

    @FXML
    protected void loginButton() throws SQLException {
       Conexao c = new Conexao("localhost","5432", "postgres", "postgres", "test123");
       c.conect();

       ResultSet result = c.query("Select pk_cpf,nome from usuario where pk_cpf = "+"'"+cpfLogin.getText()+"' and senha = "+"'"+senhaLogin.getText()+"'");
       
        if(result.next()){
        test.setText("Entrou");
       }
       else
        test.setText("Usuario ou senha errada");
       
    }

    @FXML
    private void cadastrarlogin(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("signin.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
