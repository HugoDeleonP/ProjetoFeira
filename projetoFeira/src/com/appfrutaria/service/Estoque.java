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
		frutas = new ArrayList();
		verduras = new ArrayList();
		produtos = new ArrayList();
	}

	public List<Fruta> getFrutas(){
		return frutas;
	}

	public void setFrutas(List<Fruta> frutas) {
		this.frutas = frutas;
	}

	public Fruta formerFruta(Atendente atendente) {
		String nome = atendente.writeNome();
		double preco = atendente.writePreco();
		int quantidade = atendente.writeQuantidade();
		double peso = atendente.writePeso();

		Fruta fruta = new Fruta(nome, preco, quantidade, peso);

		return fruta;
	}

	public List<Verdura> getVerduras(){
		return verduras;
	}

	public void setVerduras(List<Verdura> verduras){
		this.verduras = verduras;
	}

	public List<Produto> getProdutos(){
		return produtos;
	}

	public void setProdutos(List<Produto> produtos){
		this.produtos = produtos;
	}
	//Fruta
	public void listarFruta(Atendente atendente, List<Fruta> frutas) {

		if(frutas.isEmpty()) {
			System.out.println("Não há produto registrado");
		}

		for(int index = 0; index < frutas.size(); index++) {
			Fruta fruta = frutas.get(index);
			System.out.println(fruta.toString());
		}
	}

	public void removerFruta(int index, Atendente atendente) {

		try {
			frutas.remove(index);
		}
		catch(Exception e){
			atendente.indexInvalido();
		}

	}

	public boolean verificarTipo(){
		boolean tipoProduto;
		boolean tipoFruta;
		boolean tipoVerdura;


		return false;
	}

	public void gerenciarEstoque(Atendente atendente, Estoque estoque, int opcaoMenuUser) {
		int index = 0;
		switch(opcaoMenuUser) {
			case 1 -> {
				int tipoProduto = atendente.tipoProduto();
				Fruta fruta = estoque.formerFruta(atendente);
				frutas.add(fruta);
			}

			case 2 -> {
				estoque.listarFruta(atendente, frutas);
			}

			case 3 -> {
				index = atendente.writeIndex();
				estoque.removerFruta(index, atendente);
			}
			case 4 -> {
				return;
			}

			default ->{
				atendente.numeroInvalido();
			}


		}
	}


}
