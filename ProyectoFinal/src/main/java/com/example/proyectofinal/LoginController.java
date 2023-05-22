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
import java.sql.*;
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

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto?serverTimezone=UTC", "root" , "Cs03102003");
    Statement st = con.createStatement();

    public LoginController() throws SQLException {
    }

    public void initialize() {

    }
    @FXML
    void Logear(ActionEvent event) throws SQLException {
        String usuario = txtUser.getText();
        String password = txtPassword.getText();
        ResultSet rs = st.executeQuery("Select * from usuarios");
        while(rs.next()){
            String nombre = rs.getString("nombre");
            String constraseña = rs.getString("contrasena");
            String tipo = rs.getString("tipo");
            if (usuario.equals(nombre) && password.equals(constraseña)){

                    if(tipo.equals("admin")){

                    }else{
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
                    }
                }
            }
        }




    @FXML
    void crearUser(ActionEvent event) throws SQLException {
        boolean crear = true;
        String usuario = txtUser.getText();
        String password = txtPassword.getText();
        String tipo = "usuario";
        ResultSet rs = st.executeQuery("Select * from usuarios");
        while(rs.next()){
            String nombre = rs.getString("nombre");
            String constraseña = rs.getString("contrasena");
            if (usuario.equals(nombre) && password.equals(constraseña)){
                    crear = false;
            }
        }
        if (crear){
            int x = st.executeUpdate("Insert into equipos (id,nombre,ciudad) values ('"+usuario+"', '"+password+"', '"+tipo+"')");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Usuario Existente");
            alert.setContentText("Debes de crear un usuario que no exista");
            alert.showAndWait();
        }
        }
    }

