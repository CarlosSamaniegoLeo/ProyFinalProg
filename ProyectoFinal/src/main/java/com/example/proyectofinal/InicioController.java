package com.example.proyectofinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class InicioController {

    @FXML
    private Button btnBusqueda;

    @FXML
    private Button btnFavoritos;

    @FXML
    private Button btnNoticia;

    @FXML
    private Button btnnoticia2;

    @FXML
    private TextField txtBusqueda;

    @FXML
    private Button txtCalendario;

    @FXML
    private Button txtClasificacion;

    @FXML
    void Buscar(ActionEvent event) {

    }

    @FXML
    void irCalendario(ActionEvent event) {

    }

    @FXML
    void irClasificacion(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Clasificacion.fxml"));
        try {
            Parent root = (Parent) fxmlLoader.load();
            ClasificacionController controlador = fxmlLoader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Clasificacion");
            stage.setScene(scene);
            stage.show();

            // Cerrar la ventana actual
            Stage currentStage = (Stage) txtClasificacion.getScene().getWindow();
            currentStage.close();
        } catch (IOException var7) {
            throw new RuntimeException(var7);
        }
    }

    @FXML
    void irFavoritos(ActionEvent event) {

    }

    @FXML
    void irNoticia(ActionEvent event) {
        String url = "https://www.marca.com/futbol/getafe/2023/05/17/6464ad06ca47410b478b45f0.html";

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void irnoticia2(ActionEvent event) {
        String url = "https://www.marca.com/futbol/caso-negreira.html";

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

}
