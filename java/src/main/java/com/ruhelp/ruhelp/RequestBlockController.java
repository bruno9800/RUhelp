package com.ruhelp.ruhelp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class RequestBlockController {
    @FXML
    private void accept(MouseEvent event) throws IOException {
        Button accept_btn = (Button) event.getSource();
        Parent request_block = accept_btn.getParent().getParent();

        BorderPane bp = (BorderPane) request_block;
        System.out.println(bp);

        String id = bp.getId();

        System.out.println("Aceito!!" + id);

        VBox vbox = (VBox) bp.getParent();
        vbox.getChildren().remove(bp);
    }

    @FXML
    private void ignore(MouseEvent event) throws IOException {
        System.out.println("Ignorado!!");
    }
}
