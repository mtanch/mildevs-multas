package br.com.mildevs.multa.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.mildevs.multa.dao.CondutorDao;
import br.com.mildevs.multa.dao.MultaDao;
import br.com.mildevs.multa.dao.VeiculoDao;

public class MenuRemocao {
	public static int menuRemocao(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------------------ ESCOLHA UMA OPÇÃO: -------------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|--------- [1] REMOVER CONDUTOR --------------------------|");
		System.out.println("|--------- [2] REMOVER VEÍCULO ---------------------------|");
		System.out.println("|--------- [3] REMOVER MULTA -----------------------------|");
		System.out.println("|--------- [4] VOLTAR AO MENU ----------------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		try {
			int escolha = entrada.nextInt();
			return escolha;
		} catch(InputMismatchException e) {
			return 5;	//	Retorna ao Menu Inicial
		}
	}
	
	public static void removeCondutor(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------------------- REMOVER CONDUTOR --------------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|--------------- INFORME O NÚMERO DA CNH: ----------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		try {
			long nroCnh = entrada.nextLong();
			CondutorDao condutorDao = new CondutorDao();
			condutorDao.removeCondutor(nroCnh);
		} catch (InputMismatchException e) {
			entrada.nextLine();
			MenuInicial.mensagemDadoInformadoInvalido();
		}
	}
	
	public static void removeVeiculo(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|-------------------- REMOVER VEÍCULO --------------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|-------------- INFORME A PLACA DO VEÍCULO: --------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		try {
			entrada.nextLine();
			String placa = entrada.nextLine();
			VeiculoDao veiculoDao = new VeiculoDao();
			veiculoDao.removeVeiculo(placa);
		} catch (InputMismatchException e) {
			MenuInicial.mensagemDadoInformadoInvalido();
		}
	}
	
	public static void removeMulta(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|--------------------- REMOVER MULTA ---------------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|-------------- INFORME O CÓDIGO DA MULTA: ---------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		try {
			entrada.nextLine();	//	Buffering
			String codigoMulta = entrada.nextLine();
			MultaDao multaDao = new MultaDao();
			multaDao.removeMulta(codigoMulta);
		} catch (InputMismatchException e) {
			MenuInicial.mensagemDadoInformadoInvalido();
		}
	}
	
}
