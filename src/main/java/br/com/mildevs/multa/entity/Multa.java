package br.com.mildevs.multa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//Multa(codigoMulta, valor, pontuacao, Veiculo)

@Entity
public class Multa {
	@Id
	@Column(name = "codigo_multa")
	private String codigoMulta;
	
	@Column(nullable = false)
	private float valor;
	
	@Column(name = "pontuacao_multa", nullable = false)
	private int pontuacaoMulta;
	
	@ManyToOne
	@JoinColumn(name = "placa_fk", referencedColumnName = "placa")
	private Veiculo veiculo;
	
	public Multa(String codigoMulta, float valor, int pontuacao, Veiculo veiculo) {
		this.codigoMulta = codigoMulta;
		this.valor = valor;
		this.pontuacaoMulta = pontuacao;
		this.veiculo = veiculo;
	}
	
	public Multa() {
		super();
	}
	
	public String getCodigoMulta() {
		return codigoMulta;
	}
	public void setCodigoMulta(String codigoMulta) {
		this.codigoMulta = codigoMulta;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getPontuacao() {
		return pontuacaoMulta;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacaoMulta = pontuacao;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	@Override
	public String toString() {
		return "\n[Multa]: "
				+ "\n	Código: " + codigoMulta
				+ "\n	Valor: " + valor
				+ "\n	Pontuação: " + pontuacaoMulta
				+ "\n	Veiculo: " + veiculo.getPlaca() + "\n";
	}
	
}
