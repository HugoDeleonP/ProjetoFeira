package com.appfrutaria.model;

public class Fruta extends Produto{

	private double peso;

	public Fruta() {

		super();
		this.peso = 0;
	}

	public Fruta(String nome, double preco, int quantidade, double peso) {

		super(nome, preco, quantidade);
		this.peso = peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPeso() {
		return peso;
	}

	@Override
	public String toString(){
		return "Nome: " + nome + "\nPreço: " + preco + "\nQuantidade: " + quantidade + "\nPeso: " + peso;
	}
}
