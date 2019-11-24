package com.revol.basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatos {
    private final String URL = "jdbc:mysql://localhost/"; // Ubicación de la BD.
    private final String BD = "jdbc_java"; // Nombre de la BD.
    private final String USER = "root";
    private final String PASSWORD = "";

    public Connection conexion = null;

    @SuppressWarnings("finally")
    public Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL + BD, USER, PASSWORD);
            if (conexion != null) {
                System.out.println("¡Conexión Exitosa!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return conexion;
        }
    }
}
