package br.com.mildevs.multa.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//	Condutor(nroCnh, dataEmissao, orgaoEmissor, pontuacao, Veiculo)

@Entity
public class Condutor {
	
	@Id
	@Column(name = "nro_cnh")
	private long nroCnh;
	
	@Column(name = "data_emissao", nullable = false)
	private LocalDate dataEmissao;
	
	@Column(name = "orgao_emissor", nullable = false)
	private String orgaoEmissor;
	
	@Column(nullable = false, name = "pontuacao_cnh")
	private int pontuacaoCnh;
	
	@OneToMany(mappedBy = "condutor")
	@Cascade(CascadeType.ALL)
	private List<Veiculo> veiculo;
	
	public Condutor(long nroCnh, LocalDate dataEmissao, String orgaoEmissor, int pontuacaoCnh) {
		this.nroCnh = nroCnh;
		this.dataEmissao = dataEmissao;
		this.orgaoEmissor = orgaoEmissor;
		this.pontuacaoCnh = pontuacaoCnh;
	}
	
	public Condutor() {
		
	}
	
	public long getNroCnh() {
		return nroCnh;
	}
	public void setNroCnh(long nroCnh) {
		this.nroCnh = nroCnh;
	}
	public LocalDate getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}
	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}
	public int getPontuacaoCnh() {
		return pontuacaoCnh;
	}
	public void setPontuacaoCnh(int pontuacao) {
		this.pontuacaoCnh = pontuacao;
	}
	public List<Veiculo> getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}
	
	@Override
	public String toString() {
		
		return    "\n	[Condutor]: "
				+ "\n	CNH:" + this.nroCnh
				+ "\n	Data de Emissão: " + this.dataEmissao
				+ "\n	Orgão Emissor: " + this.orgaoEmissor
				+ "\n	Pontuação: " + this.pontuacaoCnh
				+ "\n 	Veículos: " + this.getVeiculo() + "\n";
	}
}

