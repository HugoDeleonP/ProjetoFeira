package com.appfrutaria.JDBC.DAO;

import com.appfrutaria.JDBC.Conexao;
import com.appfrutaria.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {

    public void listar(){
        try{
            Connection conn = Conexao.getConnection();

            String sql = "select produto.nome, produto.preco, produto.quantidade,\n" +
                    "\tCASE WHEN produto.tipo = 'fruta' THEN fruta.peso\n" +
                    "    ELSE NULL\n" +
                    "    END AS peso,\n" +
                    "    CASE WHEN produto.tipo = 'verdura' THEN verdura.tipo\n" +
                    "    ELSE NULL\n" +
                    "    END as tipo\n" +
                    "    FROM produto\n" +
                    "    LEFT JOIN fruta on produto.id = fruta.id_produto\n" +
                    "    LEFT JOIN verdura on produto.id = verdura.id_produto;";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if( rs.next()){
                System.out.println("consulta realizada com sucesso");
            }
            else {
                System.out.println("erro");
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

}
