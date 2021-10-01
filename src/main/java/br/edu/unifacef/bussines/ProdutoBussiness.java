package br.edu.unifacef.bussines;

import br.edu.unifacef.dao.ProdutoDAO;
import br.edu.unifacef.model.Produto;

public class ProdutoBussiness {
	
	private ProdutoDAO produtoDAO;
	
	public ProdutoBussiness(ProdutoDAO dao) {
		this.produtoDAO = dao;
	}
	
	public Produto salvarProduto(Produto produto) {
		
		if(produto == null) {
			throw new RuntimeException("Produto não informado!");
		}
		
		if(produto.getNome().isEmpty()) {
			throw new RuntimeException("Nome requerido");
		}
		
		if(produto.getDescricao().isEmpty()) {
			throw new RuntimeException("Descrição requerida");
		}
		
		return produtoDAO.salvar(produto);	
	}
	
	public Produto buscarProduto(Long id) {
		return produtoDAO.buscar(id);
	}
}
