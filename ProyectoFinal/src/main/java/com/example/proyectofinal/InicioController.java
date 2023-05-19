package com.example.proyectofinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

    }

    @FXML
    void irFavoritos(ActionEvent event) {

    }

    @FXML
    void irNoticia(ActionEvent event) {
        String url = "https://www.nike.com/es/";

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

    }

}
