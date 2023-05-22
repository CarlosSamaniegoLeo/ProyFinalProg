package com.example.proyectofinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginController {

    @FXML
    private Button btnCrearUsuario;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUser;

    // Crear un HashMap y agregar algunos datos
    Map<String, String> mapa= new HashMap<>();

    @FXML
    void Logear(ActionEvent event) {

        String usuario = txtUser.getText();
        String password = txtPassword.getText();

        if (mapa.containsKey(usuario) && mapa.get(usuario).equals(password)) {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Inicio.fxml"));

            try {
                Parent root = (Parent) fxmlLoader.load();
                InicioController controlador = (InicioController) fxmlLoader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Opciones");
                stage.setScene(scene);
                stage.show();

                // Cerrar la ventana actual
                Stage currentStage = (Stage) btnLogin.getScene().getWindow();
                currentStage.close();
            } catch (IOException var7) {
                throw new RuntimeException(var7);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Datos de usuario incorrectos");
            alert.showAndWait();
        }
    }

    @FXML
    void crearUser(ActionEvent event) {
        String usuario = txtUser.getText();

        if (!mapa.containsKey(usuario)) {
            // Agregar usuario al HashMap
            mapa.put(usuario, txtPassword.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Usuario creado");
            alert.setContentText("Se ha creado el usuario: " + usuario);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Usuario existente");
            alert.setContentText("El usuario: " + usuario + " ya existe");
            alert.showAndWait();
        }
    }

}
