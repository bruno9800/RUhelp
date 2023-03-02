package com.ruhelp.ruhelp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HomeController {
    SceneUtils sceneUtils = new SceneUtils();

    @FXML VBox available_container;
    @FXML VBox request_container;

    @FXML
    public void initialize() throws IOException {
        populateAvailable();
        populateRequest();
    }

    private void populateAvailable() throws IOException {
        for(int i=0 ; i<6 ; ++i){
            FXMLLoader box = new FXMLLoader(getClass().getResource("available_block.fxml"));
            BorderPane boxpane = box.load();

            Node img = boxpane.lookup("#img");
            //((ImageView) img).setText("asd");

            Node name = boxpane.lookup("#name");
            ((Label) name).setText("Name %d".formatted(i));

            Node card = boxpane.lookup("#cardtype");
            ((Label) card).setText("P1");
            
            available_container.getChildren().add(boxpane);
        }
    }

    private void populateRequest() throws IOException {
        for(int i=0 ; i<6 ; ++i){
            FXMLLoader box = new FXMLLoader(getClass().getResource("request_block.fxml"));
            BorderPane boxpane = box.load();

            Node img = boxpane.lookup("#img");
            //Image image = new Image("url_of_file");
            //((ImageView) img).setImage(image);

            Node name = boxpane.lookup("#name");
            ((Label) name).setText("Name %d".formatted(i));
            
            request_container.getChildren().add(boxpane);
        }
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
