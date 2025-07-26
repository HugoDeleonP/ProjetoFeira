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
		System.out.println("|  1 - Fruta                    |");
		System.out.println("|  2 - Verdura                  |");
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

	public int menuLista(String tipoOperacao){
		System.out.println("=---------| " + tipoOperacao +" |----------=");
		System.out.println("|  1 - Todos                    |");
		System.out.println("|  2 - Frutas                   |");
		System.out.println("|  3 - Verduras                 |");
		System.out.println("=-------------------------------=");
		System.out.print("\nDigite o filtro de pesquisa: >");

		int opcao = input.nextInt();
		input.nextLine();

		return opcao;
	}

	public void showIndex(int index){
		System.out.println("=-----------| "+ index + " |-----------=");
	}

	public void showID(){
		System.out.println("ID: ");
	}

	public void showNome(){
		System.out.println("Nome: ");
	}

	public void showPreco(){
		System.out.println("Preço: ");
	}

	public void showQuantidade(){
		System.out.println("Quantidade: ");
	}

	public void showPeso(){
		System.out.println("Peso: ");
	}

	public void showTipo(){
		System.out.println("Tipo: ");
	}

	public String writeNome() {
		System.out.println("Digite o nome do produto: ");

		return input.nextLine();
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

	public String writeTipo(){
		System.out.println("Digite o tipo de verdura: ");
		return input.nextLine();
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

	public void ausenciaProduto(){
		System.out.println("Não há produto registrado");
	}

	public void ausenciaFruta(){
		System.out.println("Não há fruta registrada");
	}

	public void ausenciaVerdura(){
		System.out.println("Não há verdura registrada");
	}
}
