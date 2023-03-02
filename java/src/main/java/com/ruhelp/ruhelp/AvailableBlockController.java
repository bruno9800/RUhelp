package com.ruhelp.ruhelp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class AvailableBlockController {
    SceneUtils sceneUtils = new SceneUtils();

    @FXML
    private void buy(MouseEvent event) {
        try {
            sceneUtils.SetScene(event, "buy.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
