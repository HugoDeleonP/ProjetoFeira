package com.appfrutaria.JDBC.DAO;

import com.appfrutaria.JDBC.Conexao;
import com.appfrutaria.view.Atendente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerduraDAO {
    public void inserir(ProdutoDAO produtoDAO, Atendente atendente){

        int idProduto = produtoDAO.inserir(atendente);

        try{
            Connection conn = Conexao.getConnection();

            String tipo = atendente.writeTipo();
            String sql = "INSERT INTO verdura (id_produto, tipo) VALUES (?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idProduto);
            stmt.setString(2, tipo);

            stmt.executeQuery();
            atendente.operacaoRealizada();

            stmt.close();
            conn.close();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void listar(Atendente atendente){
        try{
            Connection conn = Conexao.getConnection();

            String sql = "SELECT * FROM verdura";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                atendente.showID();
                System.out.println(rs.getInt("id_produto"));

                atendente.showPeso();
                System.out.println(rs.getString("tipo"));
            }
            else {
                System.out.println("Erro");
            }

            stmt.close();
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void remover(Atendente atendente){
        try{
            Connection conn = Conexao.getConnection();

            String sql = "DELETE FROM verdura WHERE id_produto = ?";

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
