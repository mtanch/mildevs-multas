package br.com.mildevs.multa.entity;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

//Veiculo (placa, ano, modelo, marca, Condutor, List<Multa> multas))

@Entity
public class Veiculo {
	@Id
	private String placa;
	
	@Column(nullable = false)
	private int ano;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(nullable = false)
	private String marca;
	
	@ManyToOne
	@JoinColumn(name = "nro_cnh_fk", referencedColumnName = "nro_cnh")
	private Condutor condutor;
	
	@Column(nullable = false)
	@Cascade(CascadeType.ALL)
	@OneToMany(mappedBy = "veiculo")
	private List<Multa> multas;
	
	public Veiculo(String placa, int ano, String marca, String modelo, Condutor condutor) {
		this.placa = placa;
		this.ano = ano;
		this.marca = marca;
		this.modelo = modelo;
		this.condutor = condutor;
	}
	
	public Veiculo() {
		
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Condutor getCondutor() {
		return condutor;
	}
	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}
	public List<Multa> getMultas() {
		return multas;
	}
	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}
	
	@Override
	public String toString() {
		return	  "\n		[Veículo]:"
				+ "\n		Placa = " + placa
				+ "\n		Ano = " + ano
				+ "\n		Modelo = " + modelo
				+ "\n		Marca = " + marca
				+ "\n		CNH Condutor = " + condutor.getNroCnh()
				+ "\n		Multas = " + multas + "\n";
	}
	
}

