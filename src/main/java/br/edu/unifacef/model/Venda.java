package br.edu.unifacef.model;

public class Venda {
	private Long id;
	private Cliente cliente;
	private Produto produto;
	private Empresa empresa;
	private Endereco endereco;
	private double desconto;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", cliente=" + cliente + ", produto=" + produto + ", empresa=" + empresa
				+ ", endereco=" + endereco + ", desconto=" + desconto + "]";
	}

	
	
	
	
}
