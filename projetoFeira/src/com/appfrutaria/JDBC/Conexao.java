package com.appfrutaria.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost/feira_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static Connection connection() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");

            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }

        catch(ClassNotFoundException e){
            throw new SQLException(e.getException());
        }
    }
}
