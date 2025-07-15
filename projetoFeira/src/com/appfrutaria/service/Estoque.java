package com.appfrutaria.service;
import com.appfrutaria.model.Fruta;
import com.appfrutaria.view.Atendente;

import java.util.ArrayList;
import java.util.List;
import com.appfrutaria.model.Verdura;
import com.appfrutaria.model.Produto;

public class Estoque {

	private List<Fruta> frutas = new ArrayList<>();
	private List<Verdura> verduras = new ArrayList<>();
	private List<Produto> produtos = new ArrayList<>();

	public Estoque() {
		frutas = new ArrayList<>();
		verduras = new ArrayList<>();
		produtos = new ArrayList<>();
	}

	public List<Verdura> getVerduras(){
		return verduras;
	}

	public void setVerduras(List<Verdura> verduras){
		this.verduras = verduras;
	}

	//Fruta

	public List<Fruta> getFrutas(){
		return frutas;
	}

	public void setFrutas(List<Fruta> frutas) {
		this.frutas = frutas;
	}

	public List<Produto> getProdutos(){
		return produtos;
	}

	public void setProdutos(List<Produto> produtos){
		this.produtos = produtos;
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
				Produto produto = gerenciarTipo(opcaoTipo, atendente);
				produtos.add(produto);
			}

			case 2 -> {
				int escolha = atendente.menuLista("Listagem");
				listarProduto(atendente, escolha);
			}

			case 3 -> {
				int escolha = atendente.menuLista("Remoção ");
				listarProduto(atendente, escolha);
				index = atendente.writeIndex();
				removerProduto(escolha, index, atendente);
			}
			case 4 -> {
				return;
			}

			default ->{
				atendente.numeroInvalido();
			}


		}
	}

	public void listarProduto(Atendente atendente,  int escolha){
		switch (escolha){
			case 1 -> {
				if(produtos.isEmpty()) {
					System.out.println("Não há produto registrado");
				}

				for(int index = 0; index < produtos.size(); index++) {
					Produto produto = produtos.get(index);
					atendente.showIndex(index);
					System.out.println(produto);
				}
			}

			case 2 ->{
				for(int index = 0; index <produtos.size(); index++){
					if(produtos.get(index) instanceof Fruta fruta){
						atendente.showIndex(index);
						System.out.println(fruta);
					}
				}
			}

			case 3 ->{
				for (int index = 0; index < produtos.size(); index++){
					if(produtos.get(index) instanceof Verdura verdura){
						atendente.showIndex(index);
						System.out.println(verdura);
					}
				}
			}
		}
	}


	public void removerProduto(int escolha, int index, Atendente atendente) {

		switch (escolha){
			case 1 ->{
				try {
					produtos.remove(index);
				}
				catch(Exception e){
					atendente.indexInvalido();
				}

			}

			case 2 ->{
				for(index = 0; index < produtos.size(); index++){
					if(produtos.get(index) instanceof Fruta fruta){
						produtos.remove(index);
					}

				}
			}

			case 3->{

				for(index = 0; index < produtos.size(); index++){
					if(produtos.get(index) instanceof Verdura verdura){
						produtos.remove(index);
					}
				}
			}
		}


	}

	public Produto gerenciarTipo(int opcaoTipo, Atendente atendente){
		switch(opcaoTipo){
			case 1 ->{
				Produto fruta = new Fruta();
				fruta = formerFruta(atendente);
				return fruta;
			}

			case 2 -> {
				Produto verdura = new Verdura();
				verdura = formerVerdura(atendente);

				return verdura;
			}

			default ->{
				return null;
			}
		}
	}


}
