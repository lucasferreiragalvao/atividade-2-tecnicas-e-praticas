package br.edu.unifacef.dao;

import br.edu.unifacef.model.Cliente;

public class ClienteDAO {

	public Cliente salvar( Cliente cliente ) {
		cliente.setId(111L);
		
		return cliente;
	}
	
}
