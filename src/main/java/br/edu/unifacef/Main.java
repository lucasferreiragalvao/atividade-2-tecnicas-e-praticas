package br.edu.unifacef;

import br.edu.unifacef.bussines.ClienteBussines;
import br.edu.unifacef.dao.ClienteDAO;
import br.edu.unifacef.model.Cliente;

public class Main {

	public static void main(String[] args) {		
		Cliente cliente = new Cliente();
		ClienteBussines clienteBussines = new ClienteBussines( new ClienteDAO() );
		
		cliente.setNome("Vinícius Manso Carrijo");
		cliente.setCpf("448.071.858.37");
		cliente.setSexo('M');
		
		Cliente c = clienteBussines.salvarCliente(cliente);
		
		System.out.println(c);
	}

}
