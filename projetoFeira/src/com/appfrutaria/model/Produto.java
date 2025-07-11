package com.appfrutaria.model;

public class Produto {

    protected String nome;
    protected double preco;
    protected int quantidade;

    public Produto() {
        this.nome = null;
        this.preco = 0;
        this.quantidade = 0;
    }

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override

    public String toString(){
        return "Nome: " + nome + "\nPreço: " + preco + "\nQuantidade: " + quantidade;
    }
}
