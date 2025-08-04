package com.appfrutaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.appfrutaria.view.Atendente;
import com.appfrutaria.model.Fruta;
import com.appfrutaria.service.Estoque;
import com.appfrutaria.model.Produto;
import com.appfrutaria.model.Verdura;

public class Main {

	public static void main(String[] args) throws InputMismatchException {
		Scanner input = new Scanner(System.in);

		int opcaoMenuUser;

		Atendente atendente = new Atendente();
		Estoque estoque = new Estoque();
		do {
			
			opcaoMenuUser = atendente.menuPrincipal();
			estoque.gerenciarEstoque(atendente, opcaoMenuUser);

		} while (opcaoMenuUser != 4);

	}
}
