package com.appfrutaria.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://centerbeam.proxy.rlwy.net:22338";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "frbJkDCwMYEehufrSYXKfFVnJLgKfxGG";

    public static Connection getConnection() throws SQLException{
        try {

            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }

        catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }

    }
}
