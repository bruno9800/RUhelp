package com.ruhelp.ruhelp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class MenuController {
    SceneUtils sceneUtils = new SceneUtils();

    @FXML
    private void home(MouseEvent event) {
        try {
            sceneUtils.SetScene(event, "home.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void historic(MouseEvent event) {
        try {
            sceneUtils.SetScene(event, "historic.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void configurations(MouseEvent event) {
        try {
            sceneUtils.SetScene(event, "configuration.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}