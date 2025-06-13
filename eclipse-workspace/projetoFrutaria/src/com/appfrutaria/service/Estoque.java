package com.appfrutaria.service;
import com.appfrutaria.model.Fruta;
import com.appfrutaria.view.Atendente;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
	
	List<Fruta> frutas = new ArrayList<>();
	
	public Estoque() {
		frutas = new ArrayList();
	}
	
	public List<Fruta> getFrutas(){
		return frutas;
	}
	
	public void setFrutas(List<Fruta> frutas) {
		this.frutas = frutas;
	}
	
	public Fruta formerFruta(Atendente atendente) {
		String nome = atendente.writeNome();
		double preco = atendente.writePreco(atendente);
		int quantidade = atendente.writeQuantidade(atendente);
		
		Fruta fruta = new Fruta(nome, preco, quantidade);
		
		return fruta;
	}
	
	public void listarFruta(Atendente atendente, List<Fruta> frutas) {
		
		if(frutas.isEmpty()) {
			System.out.println("Não há produto registrado");
		}
		
		for(int index = 0; index < frutas.size(); index++) {
			Fruta fruta = frutas.get(index);
			atendente.printFruta(index, fruta);
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
	
	public void gerenciarEstoque(Atendente atendente, Estoque estoque, int opcaoMenuUser) {
		int index = 0;
		switch(opcaoMenuUser) {
		case 1 -> {
			Fruta fruta = estoque.formerFruta(atendente);
			frutas.add(fruta);
		}
			
		case 2 -> {
			estoque.listarFruta(atendente, frutas);
		}
			
		case 3 -> {
			index = atendente.writeIndex(atendente);
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
