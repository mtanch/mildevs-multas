package br.com.mildevs.multa.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.mildevs.multa.dao.CondutorDao;
import br.com.mildevs.multa.dao.VeiculoDao;

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
		try {
			int escolha = entrada.nextInt();
			return escolha;
		} catch(InputMismatchException e) {
			return 5;	//	Retorna ao Menu Inicial
		}
	}
	
	public static int submenuConsultaCondutor(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------------------ ESCOLHA UMA OPÇÃO: -------------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|--------- [1] CONSULTAR POR NÚMERO DE CNH ---------------|");
		System.out.println("|--------- [2] LISTAR TODOS OS CONDUTORES ----------------|");
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
		
		CondutorDao condutorDao = new CondutorDao();
		condutorDao.consultarCondutor(nroCnh);
	}
	
	public static void listarTodosOsCondutores() {
		CondutorDao condutorDao = new CondutorDao();
		System.out.println(condutorDao.listarTodosOsCondutores());
	}
	
	public static int submenuConsultaVeiculo(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------------------ ESCOLHA UMA OPÇÃO: -------------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|--------- [1] CONSULTAR POR PLACA -----------------------|");
		System.out.println("|--------- [2] LISTAR TODOS OS VEÍCULOS ------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		int escolha = entrada.nextInt();
		
		return escolha;
	}
	
	public static void consultaVeiculoPorPlaca(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|---------------- INFORME O NÚMERO DA CNH ----------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		String placa = entrada.nextLine();
		
		VeiculoDao veiculoDao = new VeiculoDao();
		System.out.println(veiculoDao.retornaVeiculo(placa));
	}
	
	public static void listarTodosOsVeiculos() {
		VeiculoDao veiculoDao = new VeiculoDao();
		System.out.println(veiculoDao.listarTodosOsVeiculos());
	}
	
}
