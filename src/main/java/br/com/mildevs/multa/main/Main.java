package br.com.mildevs.multa.main;

import java.util.Scanner;

import br.com.mildevs.multa.menu.MenuCadastro;
import br.com.mildevs.multa.menu.MenuConsulta;
import br.com.mildevs.multa.menu.MenuInicial;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		
		while (true) {
			//	Menu Incial
			switch (MenuInicial.menu()) {	//	InputMismatchException tratada;
			case 1:
				//	Menu Cadastro
				switch (MenuCadastro.menuCadastro(entrada)) {	//	InputMismatchException tratada;
				case 1:
					MenuCadastro.insereCondutor(entrada);	//	Exceptions tratadas;
					break;
				case 2:
					MenuCadastro.insereVeiculo(entrada);
					break;
				case 3:
					MenuCadastro.insereMulta(entrada);
					break;
				case 4:
					//Retorna ao menu inicial;
					break;
				case 5:
					//	case 5 é o Retorno da exception
					MenuInicial.mensagemOpcaoInvalida();
					entrada.nextLine();	//	Buffering
					break;
				default:
					MenuInicial.mensagemOpcaoInvalida();
					break;
				}
				
				break;
			case 2:
				//	Menu Remoção
	//			Menu.menuRemocao();
				break;
			case 3:
				//	Menu Consulta
				switch (MenuConsulta.menuConsulta(entrada)) {	
				case 1:
					//Consultar Condutor
					
					switch (MenuConsulta.submenuConsultaCondutor(entrada)) {
					case 1:
						MenuConsulta.consultaCondutorPorCnh(entrada);
						break;
					case 2:
						MenuConsulta.listarTodosOsCondutores();
						break;
					default:
						MenuInicial.mensagemOpcaoInvalida();
						break;
					}
					
					break;
				case 2:
					//Consultar Veiculo
					
					switch (MenuConsulta.submenuConsultaVeiculo(entrada)) {
					case 1:
						MenuConsulta.consultaVeiculoPorPlaca(entrada);
						break;
					case 2:
						MenuConsulta.listarTodosOsVeiculos();
						break;

					default:
						MenuInicial.mensagemOpcaoInvalida();
						break;
					}
					break;
				case 3:
					//Consultar Multa
					break;
				case 4:
					//Retorna ao menu inicial;
					break;
				case 5:
//					case 5 é o Retorno da exception
					MenuInicial.mensagemOpcaoInvalida();
					entrada.nextLine();	//	Buffering
					break;
				default:
					break;
				}
				break;
			case 4:
	//			Menu.menuEdicao();
				break;
			case 5:
				MenuInicial.finalizaPrograma();
			case 6:
				//	[CASE 6] É O RETORNO DA TRATATIVA DE EXCEPTION PARA O [MENU INICIAL]
				MenuInicial.mensagemOpcaoInvalida();
				break;
			default:
				MenuInicial.mensagemOpcaoInvalida();
				break;
			}
		}
	}
}
