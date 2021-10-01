package br.edu.unifacef;

import br.edu.unifacef.bussines.ClienteBussiness;
import br.edu.unifacef.bussines.EmpresaBussiness;
import br.edu.unifacef.bussines.EnderecoBussiness;
import br.edu.unifacef.bussines.ProdutoBussiness;
import br.edu.unifacef.bussines.VendaBussiness;
import br.edu.unifacef.dao.ClienteDAO;
import br.edu.unifacef.dao.EmpresaDAO;
import br.edu.unifacef.dao.EnderecoDAO;
import br.edu.unifacef.dao.ProdutoDAO;
import br.edu.unifacef.dao.VendaDAO;
import br.edu.unifacef.model.Cliente;
import br.edu.unifacef.model.Empresa;
import br.edu.unifacef.model.Endereco;
import br.edu.unifacef.model.Produto;
import br.edu.unifacef.model.Venda;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("============================================================================================================");
		System.out.println("Criando o Cliente");
		Cliente cliente = new Cliente();
		ClienteBussiness clienteBussiness = new ClienteBussiness( new ClienteDAO() );
		
		cliente.setNome("Vinícius Manso Carrijo");
		cliente.setCpf("448.071.858.37");
		cliente.setSexo('M');
		
		Cliente clienteSalvo = clienteBussiness.salvarCliente(cliente);		
		System.out.println(clienteSalvo);

		
		System.out.println("============================================================================================================");
		System.out.println("Criando a Empresa");
		Empresa empresa = new Empresa();
		EmpresaBussiness empresaBussiness = new EmpresaBussiness( new EmpresaDAO() );
		
		empresa.setFantasia("Vinícius Manso Carrijo");
		empresa.setCnpj("42.297.954/0001-58");
		
		Empresa empresaSalva = empresaBussiness.salvarEmpresa(empresa);
		System.out.println(empresaSalva);
		
		System.out.println("============================================================================================================");
		System.out.println("Buscar a Empresa");
		
		Empresa empresaBusca = empresaBussiness.buscarEmpresa(44L);
		System.out.println(empresaBusca);

		
		System.out.println("============================================================================================================");
		System.out.println("Criando o Produto");
		Produto produto = new Produto();
		ProdutoBussiness produtoBussiness = new ProdutoBussiness(new ProdutoDAO());
	
		produto.setNome("Monitor 29 Polegadas");
		produto.setDescricao("Monitor Pro Gamer - 29” LED Full HD UltraWide IPS HDMI 75kHz 1ms");
		produto.setPreco(1250.20);
		
		Produto produtoSalvo = produtoBussiness.salvarProduto(produto);
		System.out.println(produtoSalvo);
		
		System.out.println("============================================================================================================");
		System.out.println("Buscando o Produto");
		
		Produto produtoBusca = produtoBussiness.buscarProduto(122L);
		System.out.println(produtoBusca);
		
		
		System.out.println("============================================================================================================");
		System.out.println("Criando um endereço");
		Endereco endereco = new Endereco();
		EnderecoBussiness enderecoBussiness = new EnderecoBussiness(new EnderecoDAO());
	
		endereco.setPais("Brasil");
		endereco.setCidade("Franca");
		endereco.setBairro("São Luis II");
		endereco.setRua("João Nestor dos Santos");
		endereco.setNumero("2550");
		
		Endereco enderecoSalvo = enderecoBussiness.salvarEndereco(endereco);
		System.out.println(enderecoSalvo);
		
		System.out.println("============================================================================================================");
		System.out.println("Buscando um Endereço");
		
		Endereco enderecoBusca = enderecoBussiness.buscarEndereco(122L);
		System.out.println(enderecoBusca);
		
		System.out.println("============================================================================================================");
		System.out.println("Criando uma Venda");
		Venda venda = new Venda();
		VendaBussiness vendaBussinness = new VendaBussiness(new VendaDAO());
		
		venda.setProduto(produtoSalvo);
		venda.setCliente(clienteSalvo);
		venda.setEndereco(enderecoSalvo);
		venda.setEmpresa(empresaSalva);
		
		Venda vendaSalva = vendaBussinness.salvarVenda(venda);
		System.out.println(vendaSalva);
	}

}
