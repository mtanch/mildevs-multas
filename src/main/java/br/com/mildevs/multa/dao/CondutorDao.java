package br.com.mildevs.multa.dao;

import java.time.LocalDate;
import java.util.List;

import br.com.mildevs.multa.entity.Condutor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

//	- é possível criar um condutor sem um veículo;

public class CondutorDao {
	private EntityManager manager;
	
	public CondutorDao() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("public");
		this.manager = entityManagerFactory.createEntityManager();
	}
	
	public boolean cadastraCondutor(Condutor condutor) {
		this.manager.getTransaction().begin();
		this.manager.persist(condutor);
		this.manager.getTransaction().commit();
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|----------------- [CONDUTOR CADASTRADO] -----------------|");
		System.out.println("+---------------------------------------------------------+");
		return true;
	}
	
	public boolean removeCondutor(long nroCnh) {
		Condutor condutor = this.manager.find(Condutor.class, nroCnh);
		
		if (condutor != null) {
			this.manager.getTransaction().begin();
			this.manager.remove(condutor);
			this.manager.getTransaction().commit();
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|------------------ [CONDUTOR REMOVIDO] ------------------|");
			System.out.println("+---------------------------------------------------------+");
			return true;
		}
		
		System.err.println("+---------------------------------------------------------+");
		System.err.println("|--------------- [CONDUTOR NÃO ENCONTRADO] ---------------|");
		System.err.println("+---------------------------------------------------------+");
		
		return false;
	}
	
	public void editaCnh(long nroCnh, long novaCnh) {
		Condutor condutor = this.manager.find(Condutor.class, nroCnh);
		condutor.setNroCnh(novaCnh);
		
		this.manager.getTransaction().begin();
		this.manager.persist(condutor);
		this.manager.getTransaction().commit();
	}
	
	public void editaDataEmissaoCnh(long nroCnh, LocalDate novaData) {
		Condutor condutor = this.manager.find(Condutor.class, novaData);
		
		condutor.setDataEmissao(novaData);
		
		this.manager.getTransaction().begin();
		this.manager.persist(condutor);
		this.manager.getTransaction().commit();
	}
	
	public void editaOrgaoEmissor(long nroCnh, String novoOrgaoEmissor) {
		
		Condutor condutor = this.manager.find(Condutor.class, novoOrgaoEmissor);
		
		condutor.setOrgaoEmissor(novoOrgaoEmissor);
		
		this.manager.getTransaction().begin();
		this.manager.persist(condutor);
		this.manager.getTransaction().commit();
		
	}
	
	public void consultarCondutor(long nroCnh) {
		Condutor condutor = this.manager.find(Condutor.class, nroCnh);
		System.out.println(condutor);
	}
	
	@SuppressWarnings("unchecked")
	public List<Condutor> listarTodosOsCondutores() {
		Query query = this.manager.createQuery("SELECT c FROM Condutor as c");
		
		return query.getResultList();
	}
	
	public Condutor retornaCondutor(long nroCnh) {
		Condutor condutor = this.manager.find(Condutor.class, nroCnh);
		if (condutor != null) {
			return condutor;
		}
		return null;
	}
	
}
