package br.com.mildevs.multa.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuInicial {
	
	public static int menu() {
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------------------------- MENU --------------------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|------------------ ESCOLHA UMA OPÇÃO: -------------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|--------- [1] CADASTRAR ---------------------------------|");
		System.out.println("|--------- [2] REMOVER -----------------------------------|");
		System.out.println("|--------- [3] CONSULTAR ---------------------------------|");
		System.out.println("|--------- [4] EDITAR DADOS ------------------------------|");
		System.out.println("|--------- [5] FINALIZAR PROGRAMA ------------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		
		try {
			int escolha = entrada.nextInt();
			return escolha;
		} catch(InputMismatchException e) {
			return 6;	//	Retorna ao Menu Inicial
		}
	}

	public static void finalizaPrograma() {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------------------ PROGRAMA FINALIZADO ------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.exit(0);
	}
	
	public static void mensagemOpcaoInvalida() {
		System.err.println("+---------------------------------------------------------+");
		System.err.println("|--------------- ESCOLHA UMA OPÇÃO VÁLIDA! ---------------|");
		System.err.println("+---------------------------------------------------------+");
	}
	
	public static void mensagemDadoInformadoInvalido() {
		System.err.println("+---------------------------------------------------------+");
		System.err.println("|------------- INFORME APENAS DADOS VÁLIDOS! -------------|");
		System.err.println("+---------------------------------------------------------+");
	}
	
	public static void mensagemDadoInformadoDuplicado() {
		System.err.println("+---------------------------------------------------------+");
		System.err.println("|---- OS DADOS INFORMADOS JÁ EXITEM NO BANCO DE DADOS ----|");
		System.err.println("+---------------------------------------------------------+");
	}
	
	
	
}
