package br.com.mildevs.multa.dao;

import java.util.List;

import br.com.mildevs.multa.entity.Condutor;
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
	
	public boolean cadastraVeiculo(Veiculo veiculo) {
		this.manager.getTransaction().begin();
		this.manager.persist(veiculo);
		this.manager.getTransaction().commit();
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------------------ [VEÍCULO CADASTRADO] -----------------|");
		System.out.println("+---------------------------------------------------------+");
		return true;
	}
	
	public boolean removeVeiculo(String placa) {
		Veiculo veiculo = this.manager.find(Veiculo.class, placa);
		
		if (veiculo != null) {
			this.manager.getTransaction().begin();
			this.manager.remove(veiculo);
			this.manager.getTransaction().commit();
			System.out.println("+---------------------------------------------------------+");
			System.out.println("|------------------- [VEÍCULO REMOVIDO] ------------------|");
			System.out.println("+---------------------------------------------------------+");
			return true;
		}
		
		System.err.println("+---------------------------------------------------------+");
		System.err.println("|---------------- [VEÍCULO NÃO ENCONTRADO] ---------------|");
		System.err.println("+---------------------------------------------------------+");
		return false;
	}

	public void editaPlaca(String placa, String novaPlaca) {
		
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca(novaPlaca);
		
		this.manager.getTransaction().begin();
		this.manager.persist(veiculo);
		this.manager.getTransaction().commit();
		
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|------------------- [PLACA ATUALIZADA] ------------------|");
		System.out.println("+---------------------------------------------------------+");
		
	}
	
	public void editaAnoVeiculo(String placa, int novoAno) {
		Veiculo veiculo = this.manager.find(Veiculo.class, placa);
		veiculo.setAno(novoAno);
		
		this.manager.getTransaction().begin();
		this.manager.persist(veiculo);
		this.manager.getTransaction().commit();
		
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|--------------- [ANO DO VEÍCULO ATUALIZADO] -------------|");
		System.out.println("+---------------------------------------------------------+");
	}
	
	public void editaModelo(String placa, String novoModelo) {
		
		Veiculo veiculo = this.manager.find(Veiculo.class, novoModelo);
		veiculo.setModelo(novoModelo);
		
		this.manager.getTransaction().begin();
		this.manager.persist(veiculo);
		this.manager.getTransaction().commit();
		
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|--------------- [ANO DO VEÍCULO ATUALIZADO] -------------|");
		System.out.println("+---------------------------------------------------------+");
		
	}
	
	public boolean vendaVeiculo(long cnhComprador, String placa) {
		
		Condutor comprador = this.manager.find(Condutor.class, cnhComprador);
		
		Veiculo veiculo = this.manager.find(Veiculo.class, placa);
		veiculo.setCondutor(comprador);
		
		this.manager.getTransaction().begin();
		this.manager.persist(veiculo);
		this.manager.getTransaction().commit();
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> listarTodosOsVeiculos() {
		Query query = this.manager.createQuery("SELECT v FROM Veiculo as v");
		return query.getResultList();
	}
	
	public Veiculo retornaVeiculo(String placa) {
		Veiculo veiculo = this.manager.find(Veiculo.class, placa);
		return veiculo;
	}
}
