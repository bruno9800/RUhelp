package com.ruhelp.ruhelp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class HomeController {
    SceneUtils sceneUtils = new SceneUtils();

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
