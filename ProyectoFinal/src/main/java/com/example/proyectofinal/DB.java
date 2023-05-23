package com.example.proyectofinal;

import java.sql.*;

public class DB {

    // Conexión a la base de datos
    private static Connection conn = null;

    // Configuración de la conexión a la base de datos
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "proyecto";
    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "?serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Cs03102003";
    private static final String DB_MSQ_CONN_OK = "CONEXIÓN CORRECTA";
    private static final String DB_MSQ_CONN_NO = "ERROR EN LA CONEXIÓN";

    // Configuración de la tabla Futbol
    private static final String DB_EQUIPO = "equipos";
    private static final String DB_EQUIPO_SELECT = "SELECT * FROM " + DB_EQUIPO;
    private static final String DB_EQUIPO_ID = "id";
    private static final String DB_EQUIPO_NOM = "nombre";
    private static final String DB_EQUIPO_CIUDAD = "ciudad";
    private static final String DB_EQUIPO_PUNTUACION = "puntuacion";
    private static final String DB_EQUIPO_ESTADIO = "estadio";
    private static final String DB_EQUIPO_COLORCAMISETA = "color_camiseta";
    private static final String DB_EQUIPO_GOLESMARCADOS = "goles_marcados";
    private static final String DB_EQUIPO_GOLESENCAJADOS = "goles_encajados";


    //////////////////////////////////////////////////
    // MÉTODOS DE CONEXIÓN A LA BASE DE DATOS
    //////////////////////////////////////////////////
    ;

    /**
     * Intenta cargar el JDBC driver.
     * @return true si pudo cargar el driver, false en caso contrario
     */
    public static boolean loadDriver() {
        try {
            System.out.print("Cargando Driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("OK!");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Intenta conectar con la base de datos.
     *
     * @return true si pudo conectarse, false en caso contrario
     */
    public static boolean connect() {
        try {
            System.out.print("Conectando a la base de datos...");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("OK!");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Comprueba la conexión y muestra su estado por pantalla
     *
     * @return true si la conexión existe y es válida, false en caso contrario
     */
    public static boolean isConnected() {
        // Comprobamos estado de la conexión
        try {
            if (conn != null && conn.isValid(0)) {
                System.out.println(DB_MSQ_CONN_OK);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(DB_MSQ_CONN_NO);
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Cierra la conexión con la base de datos
     */
    public static void close() {

        try {
            System.out.print("Cerrando la conexión...");
            conn.close();
            System.out.println("OK!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //////////////////////////////////////////////////
    // MÉTODOS DE TABLA FUTBOL
    //////////////////////////////////////////////////
    ;

    // Devuelve
    // Los argumentos indican el tipo de ResultSet deseado
    /**
     * Obtiene toda la tabla equipos de la base de datos
     * @param resultSetType Tipo de ResultSet
     * @param resultSetConcurrency Concurrencia del ResultSet
     * @return ResultSet (del tipo indicado) con la tabla, null en caso de error
     */
    public static ResultSet getTablaEquipos(int resultSetType, int resultSetConcurrency) {
        try {
            Statement stmt = conn.createStatement(resultSetType, resultSetConcurrency);
            ResultSet rs = stmt.executeQuery(DB_EQUIPO_SELECT);
            //stmt.close();
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    /**
     * Obtiene toda la tabla equipos de la base de datos
     *
     * @return ResultSet (por defecto) con la tabla, null en caso de error
     */
    public static ResultSet getTablaEquipos() {
        return getTablaEquipos(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    }

    /**
     * Imprime por pantalla el contenido de la tabla clientes
     */
    public static void printTablaEquipos() {
        try {
            ResultSet rs = getTablaEquipos(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            while (rs.next()) {
                String id = rs.getString(DB_EQUIPO_ID);
                String n = rs.getString(DB_EQUIPO_NOM);
                String d = rs.getString(DB_EQUIPO_CIUDAD);
                System.out.println(id + "\t" + n + "\t" + d);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //////////////////////////////////////////////////
    // MÉTODOS DE UN SOLO EQUIPO
    //////////////////////////////////////////////////
    ;

    /**
     * Solicita a la BD el equipo con id indicado
     * @param id id del equipo
     * @return ResultSet con el resultado de la consulta, null en caso de error
     */
    public static ResultSet getEquipo(String id) {
        try {
            // Realizamos la consulta SQL
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = DB_EQUIPO_SELECT + " WHERE " + DB_EQUIPO_ID + "='" + id + "';";
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            //stmt.close();

            // Si no hay primer registro entonces no existe el cliente
            if (!rs.first()) {
                return null;
            }

            // Todo bien, devolvemos el cliente
            return rs;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Comprueba si en la BD existe el equipo con el nombre indicado
     *
     * @param nombre id del equipo
     * @return verdadero si existe, false en caso contrario
     */
    public static boolean existsEquipo(String nombre) {
        try {
            // Obtenemos el cliente
            ResultSet rs = getEquipo(nombre);

            // Si rs es null, se ha producido un error
            if (rs == null) {
                return false;
            }

            // Si no existe primer registro
            if (!rs.first()) {
                rs.close();
                return false;
            }

            // Todo bien, existe el cliente
            rs.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
