package com.ruhelp.ruhelp;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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

    

    @FXML private Label error;

    @FXML private RadioButton p1cad;
    @FXML private RadioButton p2cad;


    @FXML
    private void initialize() {
        ToggleGroup group = new ToggleGroup();
        p1cad.setToggleGroup(group);
        p2cad.setToggleGroup(group);
    }

    @FXML
    private void cadastrar(MouseEvent event) throws SQLException {
        try {
            FazerCadastro cadastro = new FazerCadastro();
            String categoriaCad;

            if(p1cad.isSelected()){ 
                categoriaCad = p1cad.getText();
            } else{
                categoriaCad = p2cad.getText();
            }
            
            if(cadastro.cadastro(cpfCad.getText(), matriculaCad.getText(), nomeCad.getText(), categoriaCad,senhaCad.getText())){
                sceneUtils.SetScene(event, "login.fxml");
            }
            else{
                error.setText("Erro ao cadastrar usuário");
            }
        } catch (Exception e) {
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
