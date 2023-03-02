package com.ruhelp.ruhelp;

import java.io.IOException;
import java.sql.SQLException;

import com.ruhelp.ruhelp.core.session.Session;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class HomeController {
    SceneUtils sceneUtils = new SceneUtils();

    @FXML private Label username;
    // metodo que retorna String a partir de um Cpf
    @FXML
    private void initialize() throws SQLException {
        Session sessao = Session.getInstance();
        
        username.setText("Olá, "+ sessao.getUser().getNome());
    }

    @FXML
    private void emprestar(MouseEvent event) {
        try {
            sceneUtils.SetScene(event, "buy.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void pedir(MouseEvent event) {
        try {
            sceneUtils.SetScene(event, "provide.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
