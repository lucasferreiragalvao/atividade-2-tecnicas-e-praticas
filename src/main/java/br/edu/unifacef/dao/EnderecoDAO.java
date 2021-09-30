package br.edu.unifacef.dao;

import br.edu.unifacef.model.Endereco;

public class EnderecoDAO {
	
	public Endereco salvar(Endereco endereco) {
		endereco.setId(333L);
		
		return endereco;
	}
	
}
