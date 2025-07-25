package com.appfrutaria.service;
import com.appfrutaria.model.Fruta;
import com.appfrutaria.view.Atendente;
import com.appfrutaria.Main;

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
				aplicarIndex(escolha, atendente);

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

		boolean presencaElemento = false;
		switch (escolha){
			case 1 -> {
				if(produtos.isEmpty()) {
					atendente.ausenciaProduto();
					Main.main(new String[]{});
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
						presencaElemento = true;
					}
				}

				if(presencaElemento == false){
					atendente.ausenciaFruta();
					return;
				}
			}

			case 3 ->{
				for (int index = 0; index < produtos.size(); index++){
					if(produtos.get(index) instanceof Verdura verdura){
						atendente.showIndex(index);
						System.out.println(verdura);
						presencaElemento = true;
					}
				}

				if (presencaElemento == false){
					atendente.ausenciaVerdura();
					return;
				}
			}

			default -> {
				atendente.numeroInvalido();
			}
		}
	}

	public void aplicarIndex(int escolha, Atendente atendente){
		int index = atendente.writeIndex();

		if(index < produtos.size() && index > -1){
			removerProduto(escolha, index, atendente);
		}
		else{
			atendente.indexInvalido();
		}
	}

	public void removerProduto(int escolha, int index, Atendente atendente) {

		boolean presencaElemento = false;

		switch (escolha){
			case 1 ->{
					produtos.remove(index);
			}

			case 2 ->{
				for(index = 0; index < produtos.size(); index++){
					if(produtos.get(index) instanceof Fruta fruta){
						produtos.remove(index);
						presencaElemento = true;
					}

				}

			}

			case 3->{

				for(index = 0; index < produtos.size(); index++){
					if(produtos.get(index) instanceof Verdura verdura){
						produtos.remove(index);
						presencaElemento = true;
					}

				}

			}

			default -> {
				atendente.numeroInvalido();
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
				atendente.numeroInvalido();
				return null;
			}
		}
	}


}
