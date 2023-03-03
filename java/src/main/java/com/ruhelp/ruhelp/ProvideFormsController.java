package com.ruhelp.ruhelp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.ruhelp.ruhelp.core.session.Session;
import com.ruhelp.ruhelp.core.users.DisponibilizarCartao;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ProvideFormsController {
    SceneUtils sceneUtils = new SceneUtils();

    @FXML private Label nameProvide;
    @FXML private Label categoryProvide;
    @FXML private ChoiceBox diaSemanaProvide;
    @FXML private ChoiceBox horarioProvide;
    @FXML private Label erroProvide;

    Session s = Session.getInstance();

    @FXML private void initialize() {
        var dias = FXCollections.observableArrayList("Segunda", "Terça", "Quarta", "Quinta", "Sexta");
        nameProvide.setText(s.getUser().getNome());
        diaSemanaProvide.setItems(dias);
        
        var horarios = FXCollections.observableArrayList("Almoço", "Janta");
        categoryProvide.setText(s.getUser().getCategoria());
        horarioProvide.setItems(horarios);
    }

    @FXML
    private void disponibilizar(MouseEvent event) throws SQLException {
        try {
        
            DisponibilizarCartao cartao = new DisponibilizarCartao(s.getUser().getCpf(), horarioProvide.getValue().toString(), diaSemanaProvide.getValue().toString());

            sceneUtils.SetScene(event, "home.fxml");
        } catch (IOException e) {
            erroProvide.setText("Erro ao disponibilizar cartão");
        }
    }
}
