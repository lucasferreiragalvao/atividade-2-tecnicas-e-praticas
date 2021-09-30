package br.edu.unifacef.model;

public class Empresa {
	private Long id;
	private String fantasia;
	private String cnpj;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFantasia() {
		return fantasia;
	}
	
	public void setFantasia(String fantasia) {
		this.fantasia = fantasia.trim();
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", fantasia=" + fantasia + ", cnpj=" + cnpj + "]";
	}
	
	
}
