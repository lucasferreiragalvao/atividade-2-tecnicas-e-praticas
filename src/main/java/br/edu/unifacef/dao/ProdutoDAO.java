package br.edu.unifacef.dao;

import br.edu.unifacef.model.Produto;

public class ProdutoDAO {
	
	public Produto salvar(Produto produto) {
		
		produto.setId(112L);
		
		return produto;
	}
}
