package br.edu.unifacef.bussines;

import br.edu.unifacef.dao.VendaDAO;
import br.edu.unifacef.model.Venda;

public class VendaBussiness {
	
	private VendaDAO vendaDAO;
	
	public VendaBussiness(VendaDAO dao) {
		this.vendaDAO = dao;
	}
	
	public Venda salvarVenda(Venda venda) {
		if(venda == null) {
			throw new RuntimeException("Venda não informada!");
		}
		
		if(venda.getCliente() == null) {
			throw new RuntimeException("Cliente não informado!");
		}
		
		if(venda.getEmpresa() == null) {
			throw new RuntimeException("Empresa não informada!");
		}
		
		if(venda.getProduto() == null) {
			throw new RuntimeException("Produto não informada!");
		}
		
		if(venda.getEndereco() == null) {
			throw new RuntimeException("Endereço não informada!");
		}
		
		return vendaDAO.salvarVenda(venda);
	}
}
