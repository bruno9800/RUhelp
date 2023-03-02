package com.ruhelp.ruhelp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class ProvideFormsController {
    SceneUtils sceneUtils = new SceneUtils();

    @FXML
    //FALTA ADICIONAR INTERAÇÕES COM O BANCO DE DADOS, SÓ TA FAZENDO A TROCA DE TELA
    private void disponibilizar(MouseEvent event) {
        try {
            sceneUtils.SetScene(event, "home.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
