package br.edu.unifacef;

import br.edu.unifacef.bussines.ClienteBussines;
import br.edu.unifacef.bussines.ProdutoBussiness;
import br.edu.unifacef.dao.ClienteDAO;
import br.edu.unifacef.dao.ProdutoDAO;
import br.edu.unifacef.model.Cliente;
import br.edu.unifacef.model.Produto;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("============================================================================================================");
		System.out.println("Criando o Cliente");
		Cliente cliente = new Cliente();
		ClienteBussines clienteBussines = new ClienteBussines( new ClienteDAO() );
		
		cliente.setNome("Vin�cius Manso Carrijo");
		cliente.setCpf("448.071.858.37");
		cliente.setSexo('M');
		
		Cliente clienteSalvo = clienteBussines.salvarCliente(cliente);
		
		System.out.println(clienteSalvo);
		
		
		System.out.println("============================================================================================================");
		System.out.println("Criando o Produto");
		Produto produto = new Produto();
		ProdutoBussiness produtoBussiness = new ProdutoBussiness(new ProdutoDAO());
		produto.setNome("Monitor 29 Polegadas");
		produto.setDescricao("Monitor Pro Gamer - 29” LED Full HD UltraWide IPS HDMI 75kHz 1ms");
		produto.setPreco(1250.20);
		
		
		Produto produtoSalvo = produtoBussiness.salvarProduto(produto);
		
		System.out.println(produtoSalvo);
	}

}
