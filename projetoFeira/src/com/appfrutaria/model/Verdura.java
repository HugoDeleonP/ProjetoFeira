package com.appfrutaria.model;

public class Verdura extends Produto {

    private String tipo;

    public Verdura() {
        super();
        this.tipo = null;
    }

    public Verdura(String nome, double preco, int quantidade, String tipo) {
        super(nome, preco, quantidade);
        this.tipo = tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }
}
