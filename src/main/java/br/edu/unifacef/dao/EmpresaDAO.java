package br.edu.unifacef.dao;

import br.edu.unifacef.model.Empresa;

public class EmpresaDAO {

	public Empresa salvar( Empresa empresa ) {
		
		try {
		empresa.setId(222L);
		
		return empresa;
		}catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public Empresa buscar(Long id) {
		
		try {
			Empresa empresaBusca = new Empresa();
			empresaBusca.setId(id);
			empresaBusca.setFantasia("Empresa Busca Fantasia");
			empresaBusca.setCnpj("57.542.861/0001-19");
			
			return empresaBusca;
			
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
