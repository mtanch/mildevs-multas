package br.com.mildevs.multa.menu;

import java.util.Scanner;

public class MenuConsulta {
	public static int menuConsulta(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------------------ ESCOLHA UMA OPÇÃO: -------------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|--------- [1] CONSULTAR CONDUTOR ------------------------|");
		System.out.println("|--------- [2] CONSULTAR VEÍCULO -------------------------|");
		System.out.println("|--------- [3] CONSULTAR MULTA ---------------------------|");
		System.out.println("|--------- [4] VOLTAR AO MENU ----------------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		int escolha = entrada.nextInt();
		
		return escolha;
	}
	
	public static int submenuConsultaCondutor(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------------------ ESCOLHA UMA OPÇÃO: -------------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|--------- [1] CONSULTAR POR NÚMERO DE CNH ---------------|");
		System.out.println("|--------- [2] CONSULTAR TODOS OS CONSUTORES -------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		int escolha = entrada.nextInt();
		
		return escolha;
	}
	
	public static void consultaCondutorPorCnh(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|---------------- INFORME O NÚMERO DA CNH ----------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		long nroCnh = entrada.nextLong();
		
		//INACABADO
	}
	
}
