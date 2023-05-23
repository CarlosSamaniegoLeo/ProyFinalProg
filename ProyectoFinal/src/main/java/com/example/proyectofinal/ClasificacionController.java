package com.example.proyectofinal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ClasificacionController {

    @FXML
    private Button btnVolver;
    @FXML
    private TableView<Equipo> clasificacion;
    @FXML
    private TableColumn colDerrotas;

    @FXML
    private TableColumn colEmpates;

    @FXML
    private TableColumn colGolesEncajados;

    @FXML
    private TableColumn colGolesmarcados;

    @FXML
    private TableColumn colNombre;

    @FXML
    private TableColumn colPuntos;

    @FXML
    private TableColumn colVictorias;

    private ObservableList<Equipo> equipos;

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto?serverTimezone=UTC", "root" , "Cs03102003");
    Statement st = con.createStatement();

    public ClasificacionController() throws SQLException {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        equipos = FXCollections.observableArrayList();

        this.colPuntos.setCellValueFactory(new PropertyValueFactory("puntuacion"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colVictorias.setCellValueFactory(new PropertyValueFactory("victorias"));
        this.colDerrotas.setCellValueFactory(new PropertyValueFactory("derrotas"));
        this.colEmpates.setCellValueFactory(new PropertyValueFactory("empates"));
        this.colGolesmarcados.setCellValueFactory(new PropertyValueFactory("goles_marcados"));
        this.colGolesEncajados.setCellValueFactory(new PropertyValueFactory("goles_encajados"));
        try {
            ResultSet rs = st.executeQuery("Select * from equipos");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int victorias = rs.getInt("victorias");
                int derrotas = rs.getInt("derrotas");
                int empates = rs.getInt("empates");
                int goles_marcados = rs.getInt("goles_marcados");
                int goles_encajados = rs.getInt("goles_encajados");
                int puntos = rs.getInt("puntos");
                this.equipos.add(new Equipo(nombre, victorias, derrotas, empates, goles_marcados, goles_encajados, puntos));
                this.clasificacion.setItems(this.equipos);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void volverInicio(javafx.event.ActionEvent actionEvent) {
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
            Stage currentStage = (Stage) btnVolver.getScene().getWindow();
            currentStage.close();
        } catch (IOException var7) {
            throw new RuntimeException(var7);
        }
    }
}
