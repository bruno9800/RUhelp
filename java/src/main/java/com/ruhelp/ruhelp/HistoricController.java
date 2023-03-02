package com.ruhelp.ruhelp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class HistoricController {

    @FXML private VBox list;

    @FXML private void teste(){
        for (int i = 0; i < 2; i++) {
            try {
                FXMLLoader box = new FXMLLoader(getClass().getResource("historic_box.fxml"));
                BorderPane boxpane = box.load();

                Node name = boxpane.lookup("#name");
                ((Label) name).setText("asd");

                Node card = boxpane.lookup("#cardtype");
                ((Label) card).setText("P1");

                Node date = boxpane.lookup("#date");
                ((Label) date).setText("%02d/%02d/%02d".formatted(i, i*2, i*3));
    
                list.getChildren().add(boxpane);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}