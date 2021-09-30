package br.edu.unifacef.bussines;

import br.edu.unifacef.dao.ClienteDAO;
import br.edu.unifacef.model.Cliente;

public class ClienteBussines {
	
	private ClienteDAO clienteDAO;
	
	public ClienteBussines(ClienteDAO dao) {
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
			throw new RuntimeException("Cpf requerido");	
		}
		
		return this.clienteDAO.salvar(cliente);
	}
}
