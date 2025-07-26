package com.appfrutaria.service;
import com.appfrutaria.model.Fruta;
import com.appfrutaria.view.Atendente;
import com.appfrutaria.JDBC.DAO.*;
import com.appfrutaria.Main;

import java.util.ArrayList;
import java.util.List;
import com.appfrutaria.model.Verdura;
import com.appfrutaria.model.Produto;

public class Estoque {

	private ProdutoDAO produtoData;
	private FrutaDAO frutaData;
	private VerduraDAO verduraData;

	public Estoque() {
		produtoData = new ProdutoDAO();
		frutaData = new FrutaDAO();
		verduraData = new VerduraDAO();
	}

	public Produto formerProduto(Atendente atendente){
		String nome = atendente.writeNome();
		double preco = atendente.writePreco();
		int quantidade = atendente.writeQuantidade();

        return new Produto(nome, preco, quantidade);
	}

	public Fruta formerFruta(Atendente atendente) {
		String nome = atendente.writeNome();
		double preco = atendente.writePreco();
		int quantidade = atendente.writeQuantidade();
		double peso = atendente.writePeso();

		return new Fruta(nome, preco, quantidade, peso);
	}

	public Verdura formerVerdura(Atendente atendente){
		String nome = atendente.writeNome();
		double preco = atendente.writePreco();
		int quantidade = atendente.writeQuantidade();
		String tipo = atendente.writeTipo();

		return new Verdura(nome, preco, quantidade, tipo);
	}


	public void gerenciarEstoque(Atendente atendente, int opcaoMenuUser) {
		int index = 0;

		switch(opcaoMenuUser) {
			case 1 -> {
				int opcaoTipo = atendente.tipoProduto();
				gerenciarTipo(opcaoTipo, atendente);
			}

			case 2 -> {
				produtoData.listar(atendente);
			}

			case 3 -> {
				produtoData.deletar(atendente);
			}
			case 4 -> {
				return;
			}

			default ->{
				atendente.numeroInvalido();
			}


		}
	}

	public void gerenciarTipo(int opcaoTipo, Atendente atendente){
		switch(opcaoTipo){
			case 1 ->{
				frutaData.inserir(produtoData, atendente);
			}

			case 2 -> {
				verduraData.inserir(produtoData, atendente);
			}

			default ->{
				atendente.numeroInvalido();
				gerenciarTipo(opcaoTipo, atendente);
			}
		}
	}


}
