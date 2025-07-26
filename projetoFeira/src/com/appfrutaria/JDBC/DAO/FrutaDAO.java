package com.appfrutaria.JDBC.DAO;

import com.appfrutaria.JDBC.Conexao;
import com.appfrutaria.model.Produto;
import com.appfrutaria.view.Atendente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FrutaDAO {

    public void inserir(ProdutoDAO produtoDAO, Atendente atendente){

        int idProduto = produtoDAO.inserir(atendente);

        try{
            Connection conn = Conexao.getConnection();

            double peso = atendente.writePeso();
            String sql = "INSERT INTO fruta (id_produto, peso) VALUES (?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idProduto);
            stmt.setDouble(2, peso);

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

            String sql = "SELECT * FROM fruta";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                atendente.showID();
                System.out.println(rs.getInt("id_produto"));

                atendente.showPeso();
                System.out.println(rs.getDouble("peso"));
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

            String sql = "DELETE FROM fruta WHERE id_produto = ?";

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
