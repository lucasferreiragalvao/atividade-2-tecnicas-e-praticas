package br.edu.unifacef.model;

public class Endereco {
	private Long id;
	private String numero;
	private String rua;
	private String bairro;
	private String cidade;
	private String pais;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua.trim();
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro.trim();
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade.trim();
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais.trim();
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", numero=" + numero + ", rua=" + rua + ", bairro=" + bairro + ", cidade="
				+ cidade + ", pais=" + pais + "]";
	}
	
	
}
