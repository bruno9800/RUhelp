package com.ruhelp.ruhelp;

import java.io.IOException;
import java.sql.SQLException;

import com.ruhelp.ruhelp.core.FazerCadastro;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SigninController {
    SceneUtils sceneUtils = new SceneUtils();

    @FXML private TextField nomeCad;
    @FXML private TextField cpfCad;
    @FXML private TextField matriculaCad;
    @FXML private PasswordField senhaCad;
    @FXML private TextField categoriaCad;

    @FXML private Label error;


    @FXML
    private void cadastrar(MouseEvent event) throws SQLException {
        try {
            FazerCadastro cadastro = new FazerCadastro();
            if(cadastro.cadastro(cpfCad.getText(), matriculaCad.getText(), nomeCad.getText(), categoriaCad.getText(),senhaCad.getText())){
                sceneUtils.SetScene(event, "login.fxml");
            }
            else{
                error.setText("Erro ao cadastrar usuário");
            }
        } catch (IOException e) {
            error.setText("Erro ao cadastrar usuário");
        }
    }

    @FXML
    private void voltar(MouseEvent event) {
        try {
            sceneUtils.SetScene(event, "login.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
