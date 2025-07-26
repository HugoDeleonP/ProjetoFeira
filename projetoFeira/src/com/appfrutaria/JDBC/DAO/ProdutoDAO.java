package com.appfrutaria.JDBC.DAO;

import com.appfrutaria.JDBC.Conexao;
import com.appfrutaria.model.*;
import com.appfrutaria.view.Atendente;

import java.sql.*;

public class ProdutoDAO {

    public int inserir(Atendente atendente, String tipo){
        int idGerado = -1;
        try {
            Connection conn = Conexao.getConnection();

            String nome = atendente.writeNome();
            double preco = atendente.writePreco();
            int quantidade =atendente.writeQuantidade();

            String sql = "INSERT INTO produto (nome, preco, quantidade, tipo) VALUES (?, ?, ? , ?)";

            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            stmt.setInt(3, quantidade);
            stmt.setString(4, tipo);

            stmt.executeUpdate();
            idGerado = primaryKey(stmt);
            atendente.operacaoRealizada();

            stmt.close();
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return idGerado;
    }

    private int primaryKey(PreparedStatement stmt) throws SQLException {
        ResultSet rs = stmt.getGeneratedKeys();
        int idGerado = -1;

        if(rs.next()){
            idGerado = rs.getInt(1);
        }

        return idGerado;
    }

    public void listar(Atendente atendente){
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
                atendente.showNome();
                System.out.println(rs.getString("nome"));

                atendente.showPreco();
                System.out.println(rs.getDouble("preco"));

                atendente.showQuantidade();
                System.out.println(rs.getInt("quantidade"));

                atendente.showPeso();
                System.out.println(rs.getDouble("peso"));

                atendente.showTipo();
                System.out.println(rs.getString("tipo"));
            }
            else {
                System.out.println("erro");
            }
            stmt.close();
            conn.close();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(Atendente atendente){
        try {
            Connection conn = Conexao.getConnection();

            String sql = "DELETE FROM produto WHERE id = ?";

            int id = atendente.writeID();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

            atendente.operacaoRealizada();
            stmt.close();
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
