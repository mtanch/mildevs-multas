package br.com.mildevs.multa.dao;

import java.util.List;

import br.com.mildevs.multa.entity.Condutor;
import br.com.mildevs.multa.entity.Multa;
import br.com.mildevs.multa.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class VeiculoDao {
	
	private EntityManager manager;
	
	public VeiculoDao() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("public");
		this.manager = entityManagerFactory.createEntityManager();
	}
	
	public boolean insereVeiculo(Veiculo veiculo) {
		this.manager.getTransaction().begin();
		this.manager.persist(veiculo);
		this.manager.getTransaction().commit();
		System.out.println("\n+---------------------------------------------------------+");
		System.out.println("|------------------ [VEÍCULO CADASTRADO] -----------------|");
		System.out.println("+---------------------------------------------------------+\n");
		return true;
	}
	
	public boolean removeVeiculo(String placa) {
		Veiculo veiculo = this.manager.find(Veiculo.class, placa);
		
		if (veiculo != null) {
			this.manager.getTransaction().begin();
			this.manager.remove(veiculo);
			this.manager.getTransaction().commit();
			System.out.println("\n+---------------------------------------------------------+");
			System.out.println("|------------------- [VEÍCULO REMOVIDO] ------------------|");
			System.out.println("+---------------------------------------------------------+\n");
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> consultarVeiculo(String placa) {
		Query query = this.manager.createQuery("SELECT v FROM Veiculo as v WHERE v.placa = :placa");
		query.setParameter("placa", placa);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> listarTodosOsVeiculos() {
		Query query = this.manager.createQuery("SELECT v FROM Veiculo as v");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Multa> listarMultas(String placa) {
		Query query = this.manager.createQuery("SELECT m FROM Multa as m WHERE m.placa = :placa");
		return query.getResultList();
	}
	
	public Veiculo retornaVeiculo(String placa) {
		Veiculo veiculo = this.manager.find(Veiculo.class, placa);
		return veiculo;
	}
	
}
