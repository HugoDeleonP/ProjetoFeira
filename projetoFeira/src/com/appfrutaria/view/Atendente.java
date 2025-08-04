package com.appfrutaria.view;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.appfrutaria.model.Fruta;
import com.appfrutaria.service.Estoque;

public class Atendente {

	Scanner input;

	public Atendente() {
		input = new Scanner(System.in);
	}

	public int tipoProduto(){
		
		int opcaoTipo = 0;
		
			do {
				
				try {
				System.out.println("=-----------| MENU |------------=");
				System.out.println("|  1 - Fruta                    |");
				System.out.println("|  2 - Verdura                  |");
				System.out.println("=-------------------------------=");
				System.out.print("\nDigite o tipo: >");
	
				opcaoTipo = input.nextInt();
				input.nextLine();
				
				}
				catch (InputMismatchException e) {
					erroTipoDado();
					input.nextLine();
				}
				
			} while(opcaoTipo != 1 && opcaoTipo != 2);

		return opcaoTipo;
	}

	public int menuPrincipal() throws InputMismatchException {
		int opcaoMenu = -1;
		
		do {
			try {
				
				System.out.println("=-----------| MENU |------------=");
				System.out.println("|  1 - Cadastrar produto        |");
				System.out.println("|  2 - Listar produto           |");
				System.out.println("|  3 - Remover produto          |");
				System.out.println("|  4 - Sair                     |");
				System.out.println("=-------------------------------=");
				System.out.print("\nDigite a opção que deseja: >");

				opcaoMenu = input.nextInt();
				input.nextLine();

			}
			catch(InputMismatchException e) {
				erroTipoDado();
				input.nextLine();
			}

		} while(opcaoMenu < 1 && opcaoMenu > 4 );

		return opcaoMenu;
		
	}

	public int menuLista(String tipoOperacao){
		
		int opcao = 0;
		
		do {
			try {
				System.out.println("=---------| " + tipoOperacao +" |----------=");
				System.out.println("|  1 - Todos                    |");
				System.out.println("|  2 - Frutas                   |");
				System.out.println("|  3 - Verduras                 |");
				System.out.println("=-------------------------------=");
				System.out.print("\nDigite o filtro de pesquisa: >");

				opcao = input.nextInt();
				input.nextLine();
			}
			catch(InputMismatchException e) {
				erroTipoDado();
				input.nextLine();
			}
		} while(opcao < 1 && opcao > 3);
		
		return opcao;
	}

	public void showIndex(int index){
		System.out.println("=-----------| "+ index + " |-----------=");
	}

	public String writeNome() {
		System.out.println("Digite o nome do produto: ");

		return input.nextLine();
	}

	public double writePreco() {
		
		boolean entradaValida = false;
		
		double preco = 0;
		
		do {
			try {
				System.out.println("Digite o preço do produto: ");
				preco = input.nextDouble();
				input.nextLine();
				
				entradaValida = true;
			}
			catch(InputMismatchException e){
				erroTipoDado();
				input.nextLine();
			}

		} while(entradaValida == false);
				

		return preco;
	}

	public int writeQuantidade() {
		boolean entradaValida = false;
		
		int quantidade = 0;
		
		do {
			
			try {
				System.out.println("Digite a quantidade de produto: ");
				quantidade = input.nextInt();
				input.nextLine();
				
				entradaValida = true;

			} catch(InputMismatchException e) {
				erroTipoDado();
				input.nextLine();
			}
			
		} while(entradaValida == false);
		
				
		return quantidade;
	}

	public double writePeso(){
		boolean entradaValida = false;
		
		double peso = 0;
		
		do {
			
			try {
				System.out.println("Digite o peso da fruta: ");
				peso = input.nextDouble();
				input.nextLine();
				
				entradaValida = true;
			}
			catch(InputMismatchException e) {
				erroTipoDado();
				input.nextLine();
			}
			
		} while(entradaValida == false);
		

		
		
		return peso;
	}

	public String writeTipo(){
		System.out.println("Digite o tipo de verdura: ");
		return input.nextLine();
	}

	public int writeIndex() {
		boolean entradaValida = false;
		
		int index = -1;
		
		do {
			
			try {
				System.out.println("Digite o indice do produto que gostaria de tirar: ");
				index = input.nextInt();
				
				entradaValida = true;
			}
			catch(InputMismatchException e) {
				erroTipoDado();
				input.nextLine();
			}

		} while(entradaValida == false);		
		
		return index;
	}

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}

	public void erroTipoDado(){
		System.err.println("Digite com o tipo de dado correto.");
	}

	public void numeroInvalido() {
		System.err.println("Número inválido.");
		System.err.println("Digite outro que esteja de acordo com a legenda");
	}

	public void indexInvalido() {
		System.err.println("Índice inválido");
		System.err.println("Digite outro que tenha algum conteúdo.");
	}

	public void ausenciaProduto(){
		System.err.println("Não há produto registrado");
	}

	public void ausenciaFruta(){
		System.err.println("Não há fruta registrada");
	}

	public void ausenciaVerdura(){
		System.err.println("Não há verdura registrada");
	}
}
