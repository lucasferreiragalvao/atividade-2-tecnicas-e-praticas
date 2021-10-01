package br.edu.unifacef.dao;

import br.edu.unifacef.model.Produto;

public class ProdutoDAO {
	
	public Produto salvar(Produto produto) {
		
		try {
			produto.setId(112L);
			return produto;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public Produto buscar(Long id) {
		try {
			
			Produto produtoBusca = new Produto();
			produtoBusca.setId(id);
			produtoBusca.setNome("Mouse Pad Tecido Emborrachado Reflex");
			produtoBusca.setDescricao("Mouse Pad Tecido Emborrachado Reflex, Multicor, 23 x 16 cm");
			produtoBusca.setPreco(20.50);
			
			return produtoBusca;	
			
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
