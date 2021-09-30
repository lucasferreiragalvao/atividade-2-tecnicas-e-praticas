package br.edu.unifacef.bussines;

import br.edu.unifacef.dao.EnderecoDAO;
import br.edu.unifacef.model.Endereco;

public class EnderecoBussiness {
		
	private EnderecoDAO enderecoDAO;
	
	public EnderecoBussiness(EnderecoDAO dao) {
		this.enderecoDAO = dao;
	}
	
	public Endereco salvarEndereco(Endereco endereco) {
		
		if( endereco == null ) {
			throw new RuntimeException("Endereço não informado!");
		}
		
		if( endereco.getNumero().isEmpty() ) {
			throw new RuntimeException("Endereço deve conter um número");	
		}
		
		if( endereco.getRua().isEmpty() ) {
			throw new RuntimeException("Rua deve conter um nome");
		}
		
		if( endereco.getBairro().isEmpty() ) {
			throw new RuntimeException("Bairro deve conter um nome");
		}
		
		if( endereco.getCidade().isEmpty() ) {
			throw new RuntimeException("Cidade deve conter um nome");
		}
		
		if( endereco.getPais().isEmpty() ) {
			throw new RuntimeException("País deve conter um nome");
		}
		
		return this.enderecoDAO.salvar(endereco);
	}
	
}
