package br.com.mildevs.multa.menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.mildevs.multa.dao.CondutorDao;
import br.com.mildevs.multa.dao.MultaDao;
import br.com.mildevs.multa.dao.VeiculoDao;

public class MenuEdicao {
//	long nroCnh, LocalDate dataEmissao, String orgaoEmissor
	public static int menuEdicao(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------------------ ESCOLHA UMA OPÇÃO: -------------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|--------- [1] EDITAR CONDUTOR ---------------------------|");
		System.out.println("|--------- [2] EDITAR VEÍCULO ----------------------------|");
		System.out.println("|--------- [3] EDITAR MULTA ------------------------------|");
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
	
	public static int submenuEditarCondutor(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|----------- INFORME QUAL DADO DESEJA EDITAR: ------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|----------- [1] NÚMERO DA CNH ---------------------------|");
		System.out.println("|----------- [2] DATA DE EMISSÃO -------------------------|");
		System.out.println("|----------- [3] ORGÃO EMISSOR ---------------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		try {
			int escolha = entrada.nextInt();
			return escolha;
		} catch(InputMismatchException e) {
			return 5;	//	Retorna ao Menu Inicial
		}
	}
	
	public static void editaCnh(Scanner entrada) {
		
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------ INFORME O NÚMERO ATUAL DA CNH DO CONDUTOR: -------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		try {
			long nroCnh = entrada.nextLong();
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|------------- INFORME O NOVO NÚMERO DA CNH: -------------|");
			System.out.println("+---------------------------------------------------------+");
			System.out.print  ("	=> ");
			long novaCnh = entrada.nextLong();
			CondutorDao condutorDao = new CondutorDao();
			condutorDao.editaCnh(nroCnh, novaCnh);
		} catch (InputMismatchException e) {
			entrada.nextLine();
			MenuInicial.mensagemDadoInformadoInvalido();
		}
	}
	
	public static void editaDataEmissaoCnh(Scanner entrada) {
		
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|--------- INFORME O NÚMERO DA CNH DO CONDUTOR: ----------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		
		try {
			long nroCnh = entrada.nextLong();
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|------------ INFORME A NOVA DATA DE EMISSÃO: ------------|");
			System.out.println("+---------------------------------------------------------+");
			System.out.print  ("	=> ");
			entrada.nextLine();
			String data = entrada.nextLine();
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate novaData = LocalDate.parse(data, format);
			
			CondutorDao condutorDao = new CondutorDao();
			condutorDao.editaDataEmissaoCnh(nroCnh, novaData);
		} catch (InputMismatchException e) {
			MenuInicial.mensagemDadoInformadoInvalido();
		}
	}
	
	public static void editaOrgaoEmissor(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|--------- INFORME O NÚMERO DA CNH DO CONDUTOR: ----------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		
		try {
			long nroCnh = entrada.nextLong();
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|------------- INFORME O NOVO NÚMERO DA CNH: -------------|");
			System.out.println("+---------------------------------------------------------+");
			System.out.print  ("	=> ");
			entrada.nextLine();
			String novoOrgaoEmissor = entrada.nextLine();
			CondutorDao condutorDao = new CondutorDao();
			condutorDao.editaOrgaoEmissor(nroCnh, novoOrgaoEmissor);
		} catch (InputMismatchException e) {
			MenuInicial.mensagemDadoInformadoInvalido();
		}
	}
	
	public static int submenuEditarVeiculo(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|----------- INFORME QUAL DADO DESEJA EDITAR: ------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|----------- [1] PLACA -----------------------------------|");
		System.out.println("|----------- [2] ANO -------------------------------------|");
		System.out.println("|----------- [3] MODELO ----------------------------------|");
		System.out.println("|----------- [4] MARCA -----------------------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		try {
			int escolha = entrada.nextInt();
			return escolha;
		} catch(InputMismatchException e) {
			return 5;	//	Retorna ao Menu Inicial
		}
	}
	
	public static void editaPlaca(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|----------- INFORME A PLACA ATUAL DO VEÍCULO: -----------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		
		try {
			entrada.nextLine();
			String placa = entrada.nextLine();
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|------------ INFORME O NOVO NÚMERO DA PLACA: ------------|");
			System.out.println("+---------------------------------------------------------+");
			System.out.print  ("	=> ");
			String novaPlaca = entrada.nextLine();
			VeiculoDao veiculoDao = new VeiculoDao();
			veiculoDao.editaPlaca(placa, novaPlaca);
		} catch (InputMismatchException e) {
			MenuInicial.mensagemDadoInformadoInvalido();
		}
	}
	
	public static void editaAnoVeiculo(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|-------------- INFORME A PLACA DO VEÍCULO: --------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		
		try {
			entrada.nextLine();
			String placa = entrada.nextLine();
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|------------ INFORME O NOVO ANO DO VEÍCULO: -------------|");
			System.out.println("+---------------------------------------------------------+");
			System.out.print  ("	=> ");
			int novoAno = entrada.nextInt();
			VeiculoDao veiculoDao = new VeiculoDao();
			veiculoDao.editaAnoVeiculo(placa, novoAno);
		} catch (InputMismatchException e) {
			MenuInicial.mensagemDadoInformadoInvalido();
		}
	}
	
	public static void editaModelo(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|-------------- INFORME A PLACA DO VEÍCULO: --------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		
		try {
			entrada.nextLine();
			String placa = entrada.nextLine();
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|----------- INFORME O NOVO MODELO DO VEÍCULO: -----------|");
			System.out.println("+---------------------------------------------------------+");
			System.out.print  ("	=> ");
			String novoModelo = entrada.nextLine();
			VeiculoDao veiculoDao = new VeiculoDao();
			veiculoDao.editaModelo(placa, novoModelo);
		} catch (InputMismatchException e) {
			MenuInicial.mensagemDadoInformadoInvalido();
		}
	}
	
	public static void editaMarca(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|-------------- INFORME A PLACA DO VEÍCULO: --------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		
		try {
			entrada.nextLine();
			String placa = entrada.nextLine();
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|----------- INFORME A NOVA MARCA DO VEÍCULO: ------------|");
			System.out.println("+---------------------------------------------------------+");
			System.out.print  ("	=> ");
			String novaMarca = entrada.nextLine();
			VeiculoDao veiculoDao = new VeiculoDao();
			veiculoDao.editaModelo(placa, novaMarca);
		} catch (InputMismatchException e) {
			MenuInicial.mensagemDadoInformadoInvalido();
		}
	}
//	String codigoMulta, float valor, int pontuacao
	public static int submenuEditarMulta(Scanner entrada) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|----------- INFORME QUAL DADO DESEJA EDITAR: ------------|");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|----------- [1] CÓDIGO ----------------------------------|");
		System.out.println("|----------- [2] VALOR -----------------------------------|");
		System.out.println("|----------- [3] PONTUACAO -------------------------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		try {
			int escolha = entrada.nextInt();
			return escolha;
		} catch(InputMismatchException e) {
			return 4;	//	Retorna ao Menu Inicial
		}
	}
	
	public static void editaCodigoMulta(Scanner entrada) {
		
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|-------------- INFORME O CÓDIGO DA MULTA: ---------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		
		try {
			entrada.nextLine();
			String codigoMulta = entrada.nextLine();
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|------------ INFORME O NOVO CÓDIGO DA MULTA: ------------|");
			System.out.println("+---------------------------------------------------------+");
			System.out.print  ("	=> ");
			String novoCodigoMulta = entrada.nextLine();
			MultaDao multaDao = new MultaDao();
			multaDao.editaCodigoMulta(codigoMulta, novoCodigoMulta);
		} catch (InputMismatchException e) {
			MenuInicial.mensagemDadoInformadoInvalido();
		}
	}
	
	public static void editaValorMulta(Scanner entrada) {
		
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|-------------- INFORME O CÓDIGO DA MULTA: ---------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		
		try {
			entrada.nextLine();
			String codigoMulta = entrada.nextLine();
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|------------ INFORME O NOVO VALOR DA MULTA: -------------|");
			System.out.println("+---------------------------------------------------------+");
			System.out.print  ("	=> ");
			float novoValor = entrada.nextFloat();
			
			MultaDao multaDao = new MultaDao();
			multaDao.editaValorMulta(codigoMulta, novoValor);
		} catch (InputMismatchException e) {
			entrada.nextLine();
			MenuInicial.mensagemDadoInformadoInvalido();
		}
	}
	
	public static void editaPontuacaoMulta(Scanner entrada) {
		
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|-------------- INFORME O CÓDIGO DA MULTA: ---------------|");
		System.out.println("+---------------------------------------------------------+");
		System.out.print  ("	=> ");
		
		try {
			entrada.nextLine();
			String codigoMulta = entrada.nextLine();
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|---------- INFORME A NOVA PONTUACAO DA MULTA: -----------|");
			System.out.println("+---------------------------------------------------------+");
			System.out.print  ("	=> ");
			int novaPontuacao = entrada.nextInt();
			
			MultaDao multaDao = new MultaDao();
			multaDao.editaPontuacaoMulta(codigoMulta, novaPontuacao);
			
		} catch (InputMismatchException e) {
			entrada.nextLine();
			MenuInicial.mensagemDadoInformadoInvalido();
		}
	}
}
