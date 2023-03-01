package com.ruhelp.ruhelp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private void home(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("home.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void historic(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("historic.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void configurations(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("configuration.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void sair(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void emprestar(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("buy.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void pedir(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("provide.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    //FALTA ADICIONAR INTERAÇÕES COM O BANCO DE DADOS, SÓ TA FAZENDO A TROCA DE TELA
    private void disponibilizar(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("home.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    //FALTA ADICIONAR INTERAÇÕES COM O BANCO DE DADOS, SÓ TA FAZENDO A TROCA DE TELA
    private void enviar(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("home.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    //FALTA ADICIONAR INTERAÇÕES COM O BANCO DE DADOS, SÓ TA FAZENDO A TROCA DE TELA
    private void cadastrar(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    //FALTA ADICIONAR INTERAÇÕES COM O BANCO DE DADOS, SÓ TA FAZENDO A TROCA DE TELA
    private void alteracao(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("home.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}