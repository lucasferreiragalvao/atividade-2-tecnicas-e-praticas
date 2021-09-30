package br.edu.unifacef.dao;

import br.edu.unifacef.model.Venda;

public class VendaDAO {
	
	public Venda salvarVenda(Venda venda) {
		venda.setId(103L);
		
		return venda;
	}
}
