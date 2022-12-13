package br.com.mildevs.multa.menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.mildevs.multa.dao.CondutorDao;
import br.com.mildevs.multa.dao.MultaDao;
import br.com.mildevs.multa.dao.VeiculoDao;
import br.com.mildevs.multa.entity.Condutor;
import br.com.mildevs.multa.entity.Multa;
import br.com.mildevs.multa.entity.Veiculo;

public class MenuCadastro {

	public static int menuCadastro(Scanner entrada) {
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|------------------ ESCOLHA UMA OPÇÃO: -------------------|");
			System.out.println("|---------------------------------------------------------|");
			System.out.println("|--------- [1] CADASTRAR CONDUTOR ------------------------|");
			System.out.println("|--------- [2] CADASTRAR VEÍCULO -------------------------|");
			System.out.println("|--------- [3] CADASTRAR MULTA ---------------------------|");
			System.out.println("|--------- [4] VOLTAR AO MENU ----------------------------|");
			System.out.println("+---------------------------------------------------------+");
			System.out.print  ("	=> ");
			int escolha = entrada.nextInt();
			
			return escolha;
	}
//	long nroCnh, LocalDate dataEmissao, String orgaoEmissor, int pontuacaoCnh
	public static void insereCondutor(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------------------ CADASTRAR CONDUTOR: ------------------|");
		System.out.println("+---------------------------------------------------------+\n");
		
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|-------------- INFORME OS SEGUINTES DADOS: --------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|--------------------- NÚMERO DA CNH ---------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		long nroCnh = entrada.nextLong();
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|-------------------- DATA DE EMISSÃO --------------------|");
		System.out.println("|---------------------+-------------+---------------------|");
		System.out.println("|---------------------| Dia/Mês/Ano |---------------------|");
		System.out.println("+---------------------+-------------+---------------------+");
		System.out.print  ("	=> ");
		entrada.nextLine();
		String stringData = entrada.nextLine();
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|--------------------- ORGÃO EMISSOR ---------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		String orgaoEmissor = entrada.nextLine();
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|--------------------- PONTUAÇÃO CNH ---------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		int pontuacaoCnh = entrada.nextInt();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(stringData, format);
		
//		System.out.println("+---------------------------------------------------------+");
//		System.out.println("|------------------- INSERIDO CONDUTOR -------------------|");
//		System.out.println("+---------------------------------------------------------+");
		
		Condutor condutor = new Condutor(nroCnh, data, orgaoEmissor, pontuacaoCnh);							//	TESTAR
		CondutorDao condutorDao = new CondutorDao();														//	TESTAR
		condutorDao.insereCondutor(condutor);																//	TESTAR
		
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------ DESEJA CADASTRAR UM VEÍCULO PARA O CONDUTOR? -----|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|------- [1] SIM -----------------------------------------|");
		System.out.println("|------- [2] NÃO -----------------------------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		
		int escolha = entrada.nextInt();
		
		switch (escolha) {
		
		case 1:
//			System.out.println("+---------------------------------------------------------+");
//			System.out.println("|-------------------- INSERE VEÍCULO ---------------------|");
//			System.out.println("+---------------------------------------------------------+");
			insereVeiculo(entrada);
			
			do {
				
				System.out.println("+---------------------------------------------------------+");
				System.out.println("|----------- DESEJA CADASTRAR MAIS UM VEÍCULO? -----------|");
				System.out.println("|---------------------------------------------------------|");
				System.out.println("|------- [1] SIM -----------------------------------------|");
				System.out.println("|------- [2] NÃO -----------------------------------------|");
				System.out.println("+---------------------------------------------------------+");
				System.out.print  ("	=> ");
				escolha = entrada.nextInt();
			
				switch (escolha) {
				case 1:
//					System.out.println("+---------------------------------------------------------+");
//					System.out.println("|-------------------- INSERE VEÍCULO ---------------------|");
//					System.out.println("+---------------------------------------------------------+");
					insereVeiculo(entrada);
					break;
				default:
					break;
				}
			} while (escolha == 1);
			
			break;
		default:
			break;
		}
	}
	
//	String placa, int ano, String marca, String modelo, Condutor condutor
	public static void insereVeiculo(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|----------------- CADASTRO DE VEÍCULOS: -----------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|-------------- INFORME OS SEGUINTES DADOS: --------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|-------------------- NÚMERO DA PLACA --------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		entrada.nextLine();
		String placa = entrada.nextLine();
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|-------------------- ANO DO VEÍCULO ---------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		int ano = entrada.nextInt();
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------------------------- MARCA -------------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		entrada.nextLine();
		String marca = entrada.nextLine();
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------------------------- MODELO ------------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		String modelo = entrada.nextLine();
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|-------------------- CNH DO CONDUTOR --------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		long cnh = entrada.nextLong();
		
		CondutorDao condutorDao = new CondutorDao();															//TESTAR
		Condutor condutor = condutorDao.retornaCondutor(cnh);													//TESTAR
		
		Veiculo veiculo = new Veiculo(placa, ano, marca, modelo, condutor);										//TESTAR
		
		VeiculoDao veiculoDao = new VeiculoDao();																//TESTAR
		veiculoDao.insereVeiculo(veiculo);																		//TESTAR
	}
//	String codigoMulta, float valor, int pontuacao, Veiculo veiculo
	public static void insereMulta(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------------------ CADASTRO DE MULTAS: ------------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|-------------- INFORME OS SEGUINTES DADOS: --------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|-------------------- CÓDIGO DA MULTA --------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		entrada.nextLine();
		String codigoMulta = entrada.nextLine();
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|-------------------- VALOR DA MULTA ---------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		float valor = entrada.nextFloat();
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------------------------- MARCA -------------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		int pontuacao = entrada.nextInt();
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|-------------------- PLACA DO VEÍCULO -------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		entrada.nextLine();
		String placa = entrada.nextLine();
		
		VeiculoDao veiculoDao = new VeiculoDao();
		Veiculo veiculo = veiculoDao.retornaVeiculo(placa);
		
		Multa multa = new Multa(codigoMulta, valor, pontuacao, veiculo);
		
		MultaDao multaDao = new MultaDao();
		multaDao.insereMulta(multa);
	}
	
}
