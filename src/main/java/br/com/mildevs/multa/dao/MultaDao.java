package br.com.mildevs.multa.dao;

import java.util.InputMismatchException;
import java.util.List;

import br.com.mildevs.multa.entity.Condutor;
import br.com.mildevs.multa.entity.Multa;
import br.com.mildevs.multa.entity.Veiculo;
import br.com.mildevs.multa.menu.MenuInicial;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.RollbackException;

public class MultaDao {
	
	private EntityManager manager;
	
	public MultaDao() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("public");
		this.manager = entityManagerFactory.createEntityManager();
	}
	
	public boolean cadastraMulta(Multa multa) {
		
		try {
			this.manager.getTransaction().begin();
			this.manager.persist(multa);
			this.manager.getTransaction().commit();
			
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|-------------------- [MULTA INSERIDA] -------------------|");
			System.out.println("+---------------------------------------------------------+");
			
			atualizaPontuacaoCarteira(multa, 1);
			
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|------------- [PONTUAÇÃO DA CNH ATUALIZADA.] ------------|");
			System.out.println("+---------------------------------------------------------+");
			
			return true;
		} catch (RollbackException e) {
			MenuInicial.mensagemDadoInformadoDuplicado();
		}
		return false;
	}
	
	public void atualizaPontuacaoCarteira(Multa multa, int escolha) {
		Veiculo veiculo = this.manager.find(Veiculo.class, multa.getVeiculo().getPlaca());
		Condutor condutor = this.manager.find(Condutor.class, veiculo.getCondutor().getNroCnh());
		
		int atualizaPontuacaoCnh = 0;
		
		try {
			
			if (escolha == 1) {
				atualizaPontuacaoCnh = condutor.getPontuacaoCnh() + multa.getPontuacao();
			} else if (escolha == 2) {
				atualizaPontuacaoCnh = condutor.getPontuacaoCnh() - multa.getPontuacao();
			}
			
			condutor.setPontuacaoCnh(atualizaPontuacaoCnh);
			
			this.manager.getTransaction().begin();
			this.manager.persist(condutor);
			this.manager.getTransaction().commit();
			
		} catch (InputMismatchException e) {
			MenuInicial.mensagemOpcaoInvalida();
		}
	}
	
	public boolean removeMulta(String codigoMulta) {
		Multa multa = this.manager.find(Multa.class, codigoMulta);
		
		if (multa != null) {
			this.manager.getTransaction().begin();
			this.manager.remove(multa);
			this.manager.getTransaction().commit();
			
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|-------------------- [MULTA REMOVIDA] -------------------|");
			System.out.println("+---------------------------------------------------------+");
			
			atualizaPontuacaoCarteira(multa, 2);
			
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|------------- [PONTUAÇÃO DA CNH ATUALIZADA.] ------------|");
			System.out.println("+---------------------------------------------------------+");
			
			return true;
		}
		
		System.err.println("+---------------------------------------------------------+");
		System.err.println("|----------------- [MULTA NÃO ENCONTRADA] ----------------|");
		System.err.println("+---------------------------------------------------------+");
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Multa> consultaMultaPorPlaca(String placa_fk) {
		Query query = this.manager.createQuery("SELECT m FROM Multa as m WHERE placa_fk = :placa_fk");
		query.setParameter("placa_fk", placa_fk);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> listarTodasAsMultas() {
		Query query = this.manager.createQuery("SELECT m FROM Multa as m");
		
		if (query != null) {
			return query.getResultList();
		} else if (query == null) {
			System.err.println("+---------------------------------------------------------+");
			System.err.println("|-------------------- [NÃO HÁ MULTAS] --------------------|");
			System.err.println("+---------------------------------------------------------+");
		}
		return null;
	}
	
	public Multa retornaMulta(String codigoMulta) {
		Multa multa = this.manager.find(Multa.class, codigoMulta);
		
		if (multa != null) {
			return multa;
		} else if (multa == null) {
			System.err.println("+---------------------------------------------------------+");
			System.err.println("|----------------- [MULTA NÃO ENCONTRADA] ----------------|");
			System.err.println("+---------------------------------------------------------+");
		}
		return null;
	}

	public void editaCodigoMulta(String codigoMulta, String novoCodigoMulta) {
		Multa multa = this.manager.find(Multa.class, codigoMulta);
		
		if (multa != null) {
			multa.setCodigoMulta(novoCodigoMulta);
			
			this.manager.getTransaction().begin();
			this.manager.persist(multa);
			this.manager.getTransaction().commit();
		} else if (multa == null) {
			System.err.println("+---------------------------------------------------------+");
			System.err.println("|----------------- [MULTA NÃO ENCONTRADA] ----------------|");
			System.err.println("+---------------------------------------------------------+");
		}
	}

	public void editaValorMulta(String codigoMulta, float novoValor) {
		Multa multa = this.manager.find(Multa.class, codigoMulta);
		
		if (multa != null) {
			boolean valorAtualIgualAoNovoValor = multa.getValor() == novoValor;
			
			if (!valorAtualIgualAoNovoValor) {
				multa.setValor(novoValor);
				
				this.manager.getTransaction().begin();
				this.manager.persist(multa);
				this.manager.getTransaction().commit();
				System.out.println("+---------------------------------------------------------+");
				System.out.println("|-------------- [VALOR DA MULTA ATUALIZADO!] -------------|");
				System.out.println("+---------------------------------------------------------+");
			} else {
				System.err.println("+---------------------------------------------------------+");
				System.err.println("|---------- [OS VALORES ATUAL E NOVO SÃO IGUAIS] ---------|");
				System.err.println("+---------------------------------------------------------+");
			}
		} else if (multa == null) {
			System.err.println("+---------------------------------------------------------+");
			System.err.println("|----------------- [MULTA NÃO ENCONTRADA] ----------------|");
			System.err.println("+---------------------------------------------------------+");
		}
	}
	
	public void editaPontuacaoMulta(String codigoMulta, int novaPontuacao) {
		
		Multa multa = this.manager.find(Multa.class, codigoMulta);
		
		if (multa != null) {
			Veiculo veiculo = this.manager.find(Veiculo.class, multa.getVeiculo().getPlaca());
			Condutor condutor = this.manager.find(Condutor.class, veiculo.getCondutor().getNroCnh());
			
			boolean pontuacaoAtualMaiorQueNovaPontuacao = multa.getPontuacao() > novaPontuacao;
			
			if (pontuacaoAtualMaiorQueNovaPontuacao) {
				int calculoPontuacao = condutor.getPontuacaoCnh() - Math.abs(multa.getPontuacao() - novaPontuacao);
				
				condutor.setPontuacaoCnh(calculoPontuacao);
				
				multa.setPontuacao(novaPontuacao);
			} else if (!pontuacaoAtualMaiorQueNovaPontuacao) {
				int calculoPontuacao = condutor.getPontuacaoCnh() + Math.abs(multa.getPontuacao() - novaPontuacao);
				
				condutor.setPontuacaoCnh(calculoPontuacao);
				
				multa.setPontuacao(novaPontuacao);
			}
			
			this.manager.getTransaction().begin();
			this.manager.persist(multa);
			this.manager.getTransaction().commit();
			
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|------------- [PONTUAÇÃO DA CNH ATUALIZADA.] ------------|");
			System.out.println("+---------------------------------------------------------+");
		} else if (multa == null) {
			System.err.println("+---------------------------------------------------------+");
			System.err.println("|----------------- [MULTA NÃO ENCONTRADA] ----------------|");
			System.err.println("+---------------------------------------------------------+");
		}
	}
}
