package com.ruhelp.ruhelp;

import java.io.IOException;
import java.sql.SQLException;

import com.ruhelp.ruhelp.core.FazerCadastro;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SigninController {
    SceneUtils sceneUtils = new SceneUtils();

    @FXML private TextField nomeCad;
    @FXML private TextField cpfCad;
    @FXML private TextField matriculaCad;
    @FXML private PasswordField senhaCad;
    @FXML private TextField categoriaCad;

    @FXML private Label error;

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
}
