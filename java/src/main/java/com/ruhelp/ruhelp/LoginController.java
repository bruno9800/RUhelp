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
import java.io.IOException;
import java.sql.*;

import com.ruhelp.ruhelp.core.session.Session;

public class LoginController {
    SceneUtils sceneUtils = new SceneUtils();

    @FXML
    private TextField cpfLogin;

    @FXML
    private PasswordField senhaLogin;

    @FXML
    private Label test;

    @FXML
    private void loginButton(MouseEvent event) throws SQLException, IOException {
        Session sessao = Session.getInstance();
       sessao.isValidateLogin(cpfLogin.getText(), senhaLogin.getText());
        if(sessao.isStatus()){
            test.setText("Entrou");
            sceneUtils.SetScene(event, "home.fxml");
        }else{
            test.setText("Usuário ou senha inválidos");
        }
        
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
