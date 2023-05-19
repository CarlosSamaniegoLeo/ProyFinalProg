module com.example.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens com.example.proyectofinal to javafx.fxml;
    exports com.example.proyectofinal;
}