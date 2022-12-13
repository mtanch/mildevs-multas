package br.com.mildevs.multa.main;

import java.util.Scanner;

import br.com.mildevs.multa.menu.MenuCadastro;
import br.com.mildevs.multa.menu.MenuConsulta;
import br.com.mildevs.multa.menu.MenuInicial;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		
		while (true) {
			
			switch (MenuInicial.menu()) {
			case 1:
				
				switch (MenuCadastro.menuCadastro(entrada)) {
				case 1:
					MenuCadastro.insereCondutor(entrada);
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
				default:
					MenuInicial.mensagemOpcaoInvalida();
					break;
				}
				
				break;
			case 2:
	//			Menu.menuRemocao();
				break;
			case 3:
				
				switch (MenuConsulta.menuConsulta(entrada)) {
				case 1:
					//Consultar Condutor
					
					switch (MenuConsulta.submenuConsultaCondutor(entrada)) {
					case 1:
						MenuConsulta.consultaCondutorPorCnh(entrada);
						break;
					case 2:
						
						break;
					default:
						MenuInicial.mensagemOpcaoInvalida();
						break;
					}
					
					break;
				case 2:
					//Consultar Veiculo
					break;
				case 3:
					//Consultar Multa
					break;
				case 4:
					//Retorna ao menu inicial;
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
			default:
				MenuInicial.mensagemOpcaoInvalida();
				break;
			}
		}
	}
}
