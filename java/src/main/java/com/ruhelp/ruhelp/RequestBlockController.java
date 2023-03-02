package com.ruhelp.ruhelp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class RequestBlockController {
    @FXML
    private void accept(MouseEvent event) throws IOException {
        System.out.println("Aceito!!");
    }

    @FXML
    private void ignore(MouseEvent event) throws IOException {
        System.out.println("Ignorado!!");
    }
}
