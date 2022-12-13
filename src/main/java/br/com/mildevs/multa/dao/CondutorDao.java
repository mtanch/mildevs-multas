package br.com.mildevs.multa.dao;

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
	
	public boolean insereCondutor(Condutor condutor) {
		this.manager.getTransaction().begin();
		this.manager.persist(condutor);
		this.manager.getTransaction().commit();
		System.out.println("\n+---------------------------------------------------------+");
		System.out.println("|----------------- [CONDUTOR CADASTRADO] -----------------|");
		System.out.println("+---------------------------------------------------------+\n");
		return true;
	}
	
	public boolean removeCondutor(long nro_cnh) {
		Condutor condutor = this.manager.find(Condutor.class, nro_cnh);
		
		if (condutor != null) {
			this.manager.getTransaction().begin();
			this.manager.remove(nro_cnh);
			this.manager.getTransaction().commit();
			System.out.println("\n+---------------------------------------------------------+");
			System.out.println("|------------------ [CONDUTOR REMOVIDO] ------------------|");
			System.out.println("+---------------------------------------------------------+\n");
			return true;
		}
		return false;
	}
	
	public int consultarCondutor(int nro_cnh) {
		Query query = this.manager.createQuery("SELECT c FROM Condutor as c WHERE c.nro_cnh = :nro_cnh");
		query.setParameter("nro_cnh", nro_cnh);
		return query.getFirstResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Condutor> listarTodosOsCondutores() {
		Query query = this.manager.createQuery("SELECT c FROM Condutor as c");
		
		return query.getResultList();
	}
	
	public int nroVeiculos(int cnh) {
		Query query = this.manager.createQuery("SELECT COUNT(c.veiculo) FROM Condutor as c WHERE c.nro_cnh = :cnh");
		query.setParameter("cnh", cnh);
		
		return query.getFirstResult();
	}
	
	public boolean vendaVeiculo(int cnhVendedor, int cnhComprador, String placa) {
		
//		Veiculo veiculo = this.manager.find(Veiculo.class, placa);
		
		int qtdCarrosDoVendedor = nroVeiculos(cnhVendedor);
		
		if (qtdCarrosDoVendedor > 0) {
			
			Query query = this.manager.createQuery("UPDATE v FROM Veiculo AS v SET v.condutor = :comprador WHERE v.condutor = :vendedor "
												+  "AND v.placa = :placa");
			query.setParameter("comprador", cnhComprador);
			query.setParameter("vendedor", cnhVendedor);
			query.setParameter("placa", placa);
			
			return true;
		}
		System.out.println("O vendedor não possui carro.");
		return false;
	}
	

	public Condutor retornaCondutor(long cnhCondutor) {
		Condutor condutor = this.manager.find(Condutor.class, cnhCondutor);
		return condutor;
	}
	
	
}
