package br.com.mildevs.multa.dao;

import java.util.List;

import br.com.mildevs.multa.entity.Condutor;
import br.com.mildevs.multa.entity.Multa;
import br.com.mildevs.multa.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class MultaDao {
	
	private EntityManager manager;
	
	public MultaDao() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("public");
		this.manager = entityManagerFactory.createEntityManager();
	}
	
	public boolean insereMulta(Multa multa) {
		this.manager.getTransaction().begin();
		this.manager.persist(multa);
		this.manager.getTransaction().commit();
		
		System.out.println("\n+---------------------------------------------------------+");
		System.out.println("|-------------------- [MULTA INSERIDA] -------------------|");
		System.out.println("+---------------------------------------------------------+\n");
		
		atualizaPontuacaoCarteira(multa, 1);
		
		System.out.println("\n+---------------------------------------------------------+");
		System.out.println("|------------- [PONTUAÇÃO DA CNH ATUALIZADA.] ------------|");
		System.out.println("+---------------------------------------------------------+\n");
		
		return true;
	}
	
	public int atualizaPontuacaoCarteira(Multa multa, int escolha) {
		Veiculo veiculo = this.manager.find(Veiculo.class, multa.getCodigoMulta());
		System.out.println(veiculo);
		Condutor condutor = this.manager.find(Condutor.class, veiculo.getCondutor());
		
		int atualizaPontuacaoCnh = 0;
		
		if (escolha == 1) {
			atualizaPontuacaoCnh = condutor.getPontuacaoCnh() + multa.getPontuacao();
		} else if (escolha == 2) {
			atualizaPontuacaoCnh = condutor.getPontuacaoCnh() - multa.getPontuacao();
		}
		
		return atualizaPontuacaoCnh;
	}
	
	public boolean removeMulta(String codigoMulta) {
		Multa multa = this.manager.find(Multa.class, codigoMulta);
		
		if (multa != null) {
			this.manager.getTransaction().begin();
			this.manager.remove(multa);
			this.manager.getTransaction().commit();
			
			System.out.println("\n+---------------------------------------------------------+");
			System.out.println("|-------------------- [MULTA REMOVIDA] -------------------|");
			System.out.println("+---------------------------------------------------------+\n");
			
			atualizaPontuacaoCarteira(multa, 2);
			
			System.out.println("\n+---------------------------------------------------------+");
			System.out.println("|------------- [PONTUAÇÃO DA CNH ATUALIZADA.] ------------|");
			System.out.println("+---------------------------------------------------------+\n");
			
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Multa> consultarMultasPorPlaca(String placa_fk) {
		Query query = this.manager.createNamedQuery("SELECT m FROM Multa as m WHERE placa_fk = :placa_fk");
		query.setParameter("placa_fk", placa_fk);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> listarTodasAsMultas() {
		Query query = this.manager.createQuery("SELECT m FROM Multa as m");
		return query.getResultList();
	}
	
}
