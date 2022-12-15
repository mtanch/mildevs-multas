package br.com.mildevs.multa.main;

import java.util.Scanner;

import br.com.mildevs.multa.menu.MenuCadastro;
import br.com.mildevs.multa.menu.MenuConsulta;
import br.com.mildevs.multa.menu.MenuEdicao;
import br.com.mildevs.multa.menu.MenuInicial;
import br.com.mildevs.multa.menu.MenuRemocao;

public class Main {

																/*TODO Valeu por todos os ensinamentos professor!
																 * Meu código pode ter muita coisa pra melhorar,
																 * mas se eu cheguei a fazer o que fiz aqui 
																 * foi por sua causa 
																 * e de todos os outros que vieram antes.
																 * Então fica aqui meu [Muito Obrigado].
																 * 
																 * by Matheus Anchieta :D*/
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		while (true) {
			//	Menu Incial
			switch (MenuInicial.menu()) {	//	InputMismatchException tratada;
			case 1:
				//	Menu Cadastro
				switch (MenuCadastro.menuCadastro(entrada)) {	//	Exception tratada;
				case 1:
					MenuCadastro.cadastraCondutor(entrada);	//	Exceptions tratadas;
					break;
				case 2:
					MenuCadastro.cadastraVeiculo(entrada);	//	Exception tratada;
					break;
				case 3:
					MenuCadastro.cadastraMulta(entrada);	//	Exception tratada;
					break;
				case 4:
					//Retorna ao menu inicial;
					break;
				case 5:
//					[case 5] é o retorno para a captura das exceptions
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
				switch (MenuRemocao.menuRemocao(entrada)) {	//	Exception tratada;
				case 1:
					MenuRemocao.removeCondutor(entrada);	//	Exception tratada;
					break;
				case 2:
					MenuRemocao.removeVeiculo(entrada);	//	Não tem exception;
					break;
				case 3:
					MenuRemocao.removeMulta(entrada);	//	Não tem exception
					break;
				case 4:
					//Retorna ao menu inicial;
					break;
				case 5:
//					[case 5] é o retorno para a captura da exception no [MenuRemocao.menuRemocao]
					MenuInicial.mensagemOpcaoInvalida();
					entrada.nextLine();	//	Buffering
					break;
				default:
					MenuInicial.mensagemOpcaoInvalida();
					break;
				}
				break;
				
			case 3:
				//	Menu Consulta
				switch (MenuConsulta.menuConsulta(entrada)) {	//	Exception tratada;
				case 1:
					//Consultar Condutor
					
					switch (MenuConsulta.submenuConsultaCondutor(entrada)) {	//	Exception tratada;
					case 1:
						MenuConsulta.consultaCondutorPorCnh(entrada);	//	Exception tratada;
						break;
					case 2:
						MenuConsulta.listarTodosOsCondutores();	//	Não tem exception
						break;
					case 3:
//						[case 3] é o retorno para a captura da exception no [MenuConsulta.submenuConsultaCondutor]
						MenuInicial.mensagemOpcaoInvalida();
						entrada.nextLine();	//	Buffering
						break;
					default:
						MenuInicial.mensagemOpcaoInvalida();
						break;
					}
					break;
					
				case 2:
					//Consultar Veiculo
					
					switch (MenuConsulta.submenuConsultaVeiculo(entrada)) {	//	Exception tratada;
					case 1:
						MenuConsulta.consultaVeiculoPorPlaca(entrada);	//	Exception tratada;
						break;
					case 2:
						MenuConsulta.listarTodosOsVeiculos();	//	Não tem exception
						break;
					case 3: 
//						[case 3] é o retorno para a captura da exception no [MenuConsulta.submenuConsultaVeiculo]
						MenuInicial.mensagemOpcaoInvalida();
						entrada.nextLine();
						break;
					default:
						MenuInicial.mensagemOpcaoInvalida();
						break;
					}
					break;
					
				case 3:
					//Consultar Multa
					
					switch (MenuConsulta.submenuConsultaMulta(entrada)) {	//	Exception tratada;
					case 1:
						MenuConsulta.consultaMultaPorCodigo(entrada);	//	Não tem exception
						break;
					case 2:
						MenuConsulta.consultaMultaPorPlaca(entrada);	//	Não tem exception
						break;
					case 3:
						MenuConsulta.listarTodasAsMultas();	//	Não tem exception
						break;
					case 4:
//						[case 4] é o retorno para a captura da exception no [MenuConsulta.submenuConsultaMulta]
						MenuInicial.mensagemOpcaoInvalida();
						entrada.nextLine();
						break;
					default:
						MenuInicial.mensagemOpcaoInvalida();
						break;
					}
					break;
					
				case 4:
					//Retorna ao menu inicial;
					break;
				case 5:
//					[case 5] é o retorno para a captura da exception no [MenuConsulta.menuConsulta]
					MenuInicial.mensagemOpcaoInvalida();
					entrada.nextLine();	//	Buffering
					break;
				default:
					MenuInicial.mensagemOpcaoInvalida();
					break;
				}
				break;
				
			case 4:
				//Menu.menuEdicao();
				
				switch (MenuEdicao.menuEdicao(entrada)) {
				case 1:
					//	Editar dados do Condutor
					switch (MenuEdicao.submenuEditarCondutor(entrada)) {
					case 1:
						MenuEdicao.editaCnh(entrada);
						break;
					case 2:
						MenuEdicao.editaDataEmissaoCnh(entrada);
						break;
					case 3:
						MenuEdicao.editaOrgaoEmissor(entrada);
						break;
					case 4:
						//	Retorna ao menu inicial;
						break;
					case 5:
//						[case 5] é o retorno para a captura da exception no [MenuEdicao.submenuEditarCondutor]
						MenuInicial.mensagemOpcaoInvalida();
						entrada.nextLine();
						break;
					default:
						MenuInicial.mensagemOpcaoInvalida();
						break;
					}
					break;
					
				case 2:
					//	Editar dados de Veículos
					switch (MenuEdicao.submenuEditarVeiculo(entrada)) {
					case 1:
						MenuEdicao.editaPlaca(entrada);
						break;
					case 2:
						MenuEdicao.editaAnoVeiculo(entrada);
						break;
					case 3:
						MenuEdicao.editaModelo(entrada);
						break;
					case 4:
						MenuEdicao.editaMarca(entrada);
						break;
					case 5:
//						[case 5] é o retorno para a captura da exception no [MenuEdicao.submenuEditarVeiculo]
						MenuInicial.mensagemOpcaoInvalida();
						entrada.nextLine();
						//	Retorna ao menu inicial;
						break;

					default:
						MenuInicial.mensagemOpcaoInvalida();
						break;
					}
					break;
					
				case 3:
					//	Editar dados de Multas
					switch (MenuEdicao.submenuEditarMulta(entrada)) {
					case 1:
						MenuEdicao.editaCodigoMulta(entrada);
						break;
					case 2:
						MenuEdicao.editaValorMulta(entrada);
						break;
					case 3:
						MenuEdicao.editaPontuacaoMulta(entrada);
						break;
					case 4:
//						[case 4] é o retorno para a captura da exception no [MenuEdicao.submenuEditarMulta]
						MenuInicial.mensagemOpcaoInvalida();
						entrada.nextLine();
						break;
					default:
						MenuInicial.mensagemOpcaoInvalida();
						break;
					}
					break;
					
				case 4:
					//	Retorna ao menu inicial;
					break;
				case 5:
//					[case 5] é o retorno para a captura da exception no [MenuConsulta.submenuConsultaMulta]
					MenuInicial.mensagemOpcaoInvalida();
					entrada.nextLine();
					break;
				default:
					MenuInicial.mensagemOpcaoInvalida();
					break;
				}
				break;
				
			case 5:
				MenuInicial.finalizaPrograma();
			case 6:
//				[case 6] é o Retorno para a captura das exceptions
				MenuInicial.mensagemOpcaoInvalida();
				break;
			default:
				MenuInicial.mensagemOpcaoInvalida();
				break;
			}
		}
	}
}
