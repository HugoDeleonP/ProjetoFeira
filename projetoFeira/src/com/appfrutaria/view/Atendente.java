package com.appfrutaria.view;

import java.util.List;
import java.util.Scanner;

import com.appfrutaria.model.Fruta;
import com.appfrutaria.service.Estoque;

public class Atendente {

	Scanner input;

	public Atendente() {
		input = new Scanner(System.in);
	}

	public int tipoProduto(){
		System.out.println("=-----------| MENU |------------=");
		System.out.println("|  1 - Produto                  |");
		System.out.println("|  2 - Fruta                    |");
		System.out.println("|  3 - Verdura                  |");
		System.out.println("=-------------------------------=");
		System.out.print("\nDigite o tipo: >");

		int opcaoTipo = input.nextInt();
		input.nextLine();

		return opcaoTipo;
	}

	public int menuPrincipal() {
		int opcaoMenu;


		System.out.println("=-----------| MENU |------------=");
		System.out.println("|  1 - Cadastrar produto	    |");
		System.out.println("|  2 - Listar produto		    |");
		System.out.println("|  3 - Remover produto		    |");
		System.out.println("|  4 - Sair			            |");
		System.out.println("=-------------------------------=");
		System.out.print("\nDigite a opção que deseja: >");

		opcaoMenu = input.nextInt();
		input.nextLine();


		return opcaoMenu;
	}



	public String writeNome() {
		System.out.println("Digite o nome do produto: ");
		String nome = input.nextLine();

		return nome;
	}

	public double writePreco() {
		System.out.println("Digite o preço do produto: ");
		double preco = input.nextDouble();
		input.nextLine();

		return preco;
	}

	public int writeQuantidade() {
		int quantidade = 0;
		System.out.println("Digite a quantidade de produto: ");
		quantidade = input.nextInt();
		input.nextLine();

		return quantidade;
	}

	public double writePeso(){
		System.out.println("Digite o peso da fruta: ");
		double peso = input.nextDouble();
		input.nextLine();

		return peso;
	}

	public int writeIndex() {
		System.out.println("Digite o indice do produto que gostaria de tirar: ");
		int index = input.nextInt();
		return index;
	}



	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}

	public void erroTipoDado(){
		System.out.println("Digite com o tipo de dado correto.");
	}

	public void numeroInvalido() {
		System.out.println("Número inválido.");
		System.out.println("Digite outro que esteja de acordo com a legenda");
	}

	public void indexInvalido() {
		System.out.println("Índice inválido");
		System.out.println("Digite outro que tenha algum conteúdo.");
	}
}
