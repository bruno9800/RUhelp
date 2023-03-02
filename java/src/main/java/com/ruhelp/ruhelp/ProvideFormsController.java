package com.ruhelp.ruhelp;

import java.io.IOException;

import com.ruhelp.ruhelp.core.session.Session;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ProvideFormsController {
    SceneUtils sceneUtils = new SceneUtils();

    @FXML private Label nameProvide;
    @FXML private Label categoryProvide;

    Session s = Session.getInstance();

    @FXML private void initialize() {

        nameProvide.setText(s.getUser().getNome());
        categoryProvide.setText(s.getUser().getCategoria());
    }

    @FXML
    private void disponibilizar(MouseEvent event) {
        try {
            sceneUtils.SetScene(event, "home.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
