package com.example.proyectofinal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ClasificacionController {
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

    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Creo el observablelist
        equipos = FXCollections.observableArrayList();

        // Asigno las columnas con los atributos del modelo
        this.colPuntos.setCellValueFactory(new PropertyValueFactory("puntuacion"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colVictorias.setCellValueFactory(new PropertyValueFactory("victorias"));
        this.colDerrotas.setCellValueFactory(new PropertyValueFactory("derrotas"));
        this.colEmpates.setCellValueFactory(new PropertyValueFactory("empates"));
        this.colGolesmarcados.setCellValueFactory(new PropertyValueFactory("goles_marcados"));
        this.colGolesEncajados.setCellValueFactory(new PropertyValueFactory("goles_encajados"));
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto?serverTimezone=UTC", "root" , "Cs03102003");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from equipos");
            while (rs.next()) {
                String id = rs.getString("id");
                String ciudad = rs.getString("ciudad");
                String nombre = rs.getString("nombre");
                int victorias = rs.getInt("victorias");
                int derrotas = rs.getInt("derrotas");
                int empates = rs.getInt("empates");
                int goles_marcados = rs.getInt("goles_marcados");
                int goles_encajados = rs.getInt("goles_encajados");
                int puntos = rs.getInt("puntos");
                this.equipos.add(new Equipo(nombre, ciudad, victorias, derrotas, empates, goles_marcados, goles_encajados, puntos));
                this.clasificacion.setItems(this.equipos);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
