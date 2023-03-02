package com.ruhelp.ruhelp;

import java.io.IOException;

import javafx.event.Event;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

public class SceneUtils {
    public void SetScene(Event event, String scene) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(scene));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene new_scene = new Scene(root);
        stage.setScene(new_scene);
        stage.show();
    }

    public void BackToLogin(String scene) {
        Parent root = FXMLLoader.load(getClass().getResource(scene));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene new_scene = new Scene(root);
        stage.setScene(new_scene);
        stage.show();
    }
}
