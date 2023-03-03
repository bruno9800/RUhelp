package com.ruhelp.ruhelp;

import java.io.IOException;

import javafx.event.Event;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class RequestBlockController {
    @FXML
    private void accept(MouseEvent event) throws IOException {
        BorderPane bp = getBP(event);
        String id = bp.getId();

        //  CÓDIGO PARA EXCLUIR DO BANCO DE DADOS
        System.out.println("Aceito!!" + id);

        VBox vbox = (VBox) bp.getParent();
        vbox.getChildren().remove(bp);
    }

    @FXML
    private void ignore(MouseEvent event) throws IOException {
        BorderPane bp = getBP(event);
        String id = bp.getId();

        //  CÓDIGO PARA EXCLUIR DO BANCO DE DADOS
        System.out.println("Ignorado!!" + id);

        VBox vbox = (VBox) bp.getParent();
        vbox.getChildren().remove(bp);
    }

    private BorderPane getBP(Event event){
        Button accept_btn = (Button) event.getSource();
        Parent request_block = accept_btn.getParent().getParent();

        return (BorderPane) request_block;
    }
}
