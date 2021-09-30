package br.edu.unifacef.dao;

import br.edu.unifacef.model.Empresa;

public class EmpresaDAO {

	public Empresa salvar( Empresa empresa ) {
		empresa.setId(222L);
		
		return empresa;
	}
	
}
