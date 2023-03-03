package com.ruhelp.ruhelp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class AvailableBlockController {
    SceneUtils sceneUtils = new SceneUtils();

    @FXML
    private void buy(MouseEvent event) {
        try {
            Object node = event.getSource();
            String id = ((BorderPane) node).getId();
            //System.out.println("\n\nCODIGO: "+id);
            
            BuyFormsController bfc = new BuyFormsController();
            bfc.setCodigo(Integer.parseInt(id));
            sceneUtils.SetScene(event, "buy.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
