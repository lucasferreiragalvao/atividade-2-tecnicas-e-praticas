package br.edu.unifacef.bussines;

import br.edu.unifacef.dao.EmpresaDAO;
import br.edu.unifacef.model.Empresa;

public class EmpresaBussiness {

	private EmpresaDAO empresaDAO;
	
	public EmpresaBussiness(EmpresaDAO dao) {
		this.empresaDAO = dao;
	}
	
	public Empresa salvarEmpresa(Empresa empresa) {
		if( empresa == null ) {
			throw new RuntimeException("Empresa não informada!");	
		}
		
		if (empresa.getFantasia().isEmpty() ) {
			throw new RuntimeException("Nome fantasia requerido");
		}
		
		if ( empresa.getCnpj().isEmpty() ) {
			throw new RuntimeException("CNPJ requerido");	
		}
		
		return this.empresaDAO.salvar(empresa);
	}
	
	public Empresa buscarEmpresa(Long id) {
		return this.empresaDAO.buscar(id);
	}
	
}
