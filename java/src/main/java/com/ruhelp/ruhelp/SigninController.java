package com.ruhelp.ruhelp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SigninController {
    SceneUtils sceneUtils = new SceneUtils();

    @FXML
    private void cadastrar(MouseEvent event) {
        try {
            sceneUtils.SetScene(event, "login.fxml");
        } catch (IOException e) {
            e.printStackTrace();
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
