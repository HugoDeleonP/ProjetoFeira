package com.appfrutaria.JDBC;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        try(Connection conn = Conexao.getConnection();) {
            if(conn != null){
                System.out.println("Conexão realizada com sucesso!");
            }
        } catch (Exception e){
            System.out.println("Conexão não correspondida.");
            e.printStackTrace();
        }
    }

}
