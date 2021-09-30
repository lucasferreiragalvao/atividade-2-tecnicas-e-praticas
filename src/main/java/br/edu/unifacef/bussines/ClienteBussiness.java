package br.edu.unifacef.bussines;

import br.edu.unifacef.dao.ClienteDAO;
import br.edu.unifacef.model.Cliente;

public class ClienteBussiness {
	
	private ClienteDAO clienteDAO;
	
	public ClienteBussiness(ClienteDAO dao) {
		this.clienteDAO = dao;
	}
	
	public Cliente salvarCliente(Cliente cliente) {
		if( cliente == null ) {
			throw new RuntimeException("Cliente não informado!");	
		}
		
		if ( cliente.getNome().isEmpty() ) {
			throw new RuntimeException("Nome requerido");
		}
		
		if ( cliente.getCpf().isEmpty() ) {
			throw new RuntimeException("CPF requerido");	
		}
		
		return this.clienteDAO.salvar(cliente);
	}
}
