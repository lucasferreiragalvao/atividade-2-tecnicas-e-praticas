package br.edu.unifacef.dao;

import br.edu.unifacef.model.Endereco;

public class EnderecoDAO {
	
	public Endereco salvar(Endereco endereco) {
		try {
			endereco.setId(333L);
			
			return endereco;
		}catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public Endereco buscar(Long id) {
		try {
			Endereco enderecoBusca = new Endereco();
			enderecoBusca.setId(id);
			enderecoBusca.setNumero("1000");
			enderecoBusca.setBairro("São Judas");
			enderecoBusca.setCidade("Franca");
			enderecoBusca.setRua("Rua Amarildo");
			enderecoBusca.setPais("Brasil");
			
			return enderecoBusca;
			
		}catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
