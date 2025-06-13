package com.appfrutaria;

import java.util.Scanner;

import com.appfrutaria.view.Atendente;
import com.appfrutaria.model.Fruta;
import com.appfrutaria.service.Estoque;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int opcaoMenuUser;
		
		Atendente atendente = new Atendente();
		Estoque estoque = new Estoque();
		Fruta fruta = new Fruta();
				
		do {
			opcaoMenuUser = atendente.menuPrincipal();
			estoque.gerenciarEstoque(atendente, estoque, opcaoMenuUser);

		} while (opcaoMenuUser != 4);
		
		
		
		
	}

}
