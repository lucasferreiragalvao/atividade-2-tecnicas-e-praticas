package br.edu.unifacef.bussiness;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.unifacef.bussines.EmpresaBussiness;
import br.edu.unifacef.bussines.VendaBussiness;
import br.edu.unifacef.dao.VendaDAO;
import br.edu.unifacef.model.Cliente;
import br.edu.unifacef.model.Empresa;
import br.edu.unifacef.model.Endereco;
import br.edu.unifacef.model.Produto;
import br.edu.unifacef.model.Venda;

@RunWith(MockitoJUnitRunner.class)
public class VendaBussinessTest {

	@Mock
	private VendaDAO vendaDAO;
	
	@Test
	public void deveSalvarVendaSucesso() {
		Cliente cliente = new Cliente();
		cliente.setNome("Vinícius Manso Carrijo");
		cliente.setCpf("448.071.858.37");
		cliente.setSexo('M');
		
		Produto produto = new Produto();
		produto.setNome("Monitor 29 Polegadas");
		produto.setDescricao("Monitor Pro Gamer - 29” LED Full HD UltraWide IPS HDMI 75kHz 1ms");
		produto.setPreco(1250.20);
		
		Empresa empresa = new Empresa();
		empresa.setFantasia("Vinícius Manso Carrijo");
		empresa.setCnpj("42.297.954/0001-58");
		
		Endereco endereco = new Endereco();
		endereco.setPais("Brasil");
		endereco.setCidade("Franca");
		endereco.setBairro("São Luis II");
		endereco.setRua("João Nestor dos Santos");
		endereco.setNumero("2550");
		
		Venda vendaStub = new Venda();
		vendaStub.setId(1L);
		vendaStub.setCliente(cliente);
		vendaStub.setProduto(produto);
		vendaStub.setEmpresa(empresa);
		vendaStub.setEndereco(endereco);
		vendaStub.setDesconto(10.0);
		
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setProduto(produto);
		venda.setEmpresa(empresa);
		venda.setEndereco(endereco);
		venda.setDesconto(0.0);
		
		Mockito.when(vendaDAO.salvarVenda(venda)).thenReturn(vendaStub);
		
		VendaBussiness vendaBussiness = new VendaBussiness(vendaDAO);
		
		Venda vendaSalva = vendaBussiness.salvarVenda(venda);
		
		assertEquals(vendaStub, vendaSalva);
	}
	
	@Test
	public void deveRetornarRuntimeExceptionCasoClienteNull() {		
		Produto produto = new Produto();
		produto.setNome("Monitor 29 Polegadas");
		produto.setDescricao("Monitor Pro Gamer - 29” LED Full HD UltraWide IPS HDMI 75kHz 1ms");
		produto.setPreco(1250.20);
		
		Empresa empresa = new Empresa();
		empresa.setFantasia("Vinícius Manso Carrijo");
		empresa.setCnpj("42.297.954/0001-58");
		
		Endereco endereco = new Endereco();
		endereco.setPais("Brasil");
		endereco.setCidade("Franca");
		endereco.setBairro("São Luis II");
		endereco.setRua("João Nestor dos Santos");
		endereco.setNumero("2550");		
		
		Venda venda = new Venda();
		venda.setCliente(null);
		venda.setProduto(produto);
		venda.setEmpresa(empresa);
		venda.setEndereco(endereco);
		venda.setDesconto(0.0);
		
		VendaBussiness vendaBussiness = new VendaBussiness(vendaDAO);
		try {
			Venda vendaSalva = vendaBussiness.salvarVenda(venda);
		} catch ( RuntimeException e ) {
			assertEquals(e.getMessage(), "Cliente não informado!");
		}
	}
	
	@Test
	public void deveRetornarRuntimeExceptionCasoEmpresaNull() {
		Cliente cliente = new Cliente();
		cliente.setNome("Vinícius Manso Carrijo");
		cliente.setCpf("448.071.858.37");
		cliente.setSexo('M');
		
		Produto produto = new Produto();
		produto.setNome("Monitor 29 Polegadas");
		produto.setDescricao("Monitor Pro Gamer - 29” LED Full HD UltraWide IPS HDMI 75kHz 1ms");
		produto.setPreco(1250.20);
		
		Endereco endereco = new Endereco();
		endereco.setPais("Brasil");
		endereco.setCidade("Franca");
		endereco.setBairro("São Luis II");
		endereco.setRua("João Nestor dos Santos");
		endereco.setNumero("2550");		
		
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setProduto(produto);
		venda.setEmpresa(null);
		venda.setEndereco(endereco);
		venda.setDesconto(0.0);
		
		VendaBussiness vendaBussiness = new VendaBussiness(vendaDAO);			
		try {
			Venda vendaSalva = vendaBussiness.salvarVenda(venda);
		} catch ( RuntimeException e ) {
			assertEquals(e.getMessage(), "Empresa não informada!");			
		}
	}
	
	@Test
	public void deveRetornarRuntimeExceptionCasoProdutoNull() {
		Cliente cliente = new Cliente();
		cliente.setNome("Vinícius Manso Carrijo");
		cliente.setCpf("448.071.858.37");
		cliente.setSexo('M');
		
		Empresa empresa = new Empresa();
		empresa.setFantasia("Vinícius Manso Carrijo");
		empresa.setCnpj("42.297.954/0001-58");
		
		Endereco endereco = new Endereco();
		endereco.setPais("Brasil");
		endereco.setCidade("Franca");
		endereco.setBairro("São Luis II");
		endereco.setRua("João Nestor dos Santos");
		endereco.setNumero("2550");		
		
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setProduto(null);
		venda.setEmpresa(empresa);
		venda.setEndereco(endereco);
		venda.setDesconto(0.0);
		
		VendaBussiness vendaBussiness = new VendaBussiness(vendaDAO);			
		try {
			Venda vendaSalva = vendaBussiness.salvarVenda(venda);
		} catch ( RuntimeException e ) {
			assertEquals(e.getMessage(), "Produto não informada!");			
		}
	}

	@Test
	public void deveRetornarRuntimeExceptionCasoEnderecoNull() {
		Cliente cliente = new Cliente();
		cliente.setNome("Vinícius Manso Carrijo");
		cliente.setCpf("448.071.858.37");
		cliente.setSexo('M');
		
		Produto produto = new Produto();
		produto.setNome("Monitor 29 Polegadas");
		produto.setDescricao("Monitor Pro Gamer - 29” LED Full HD UltraWide IPS HDMI 75kHz 1ms");
		produto.setPreco(1250.20);	
		
		Empresa empresa = new Empresa();
		empresa.setFantasia("Vinícius Manso Carrijo");
		empresa.setCnpj("42.297.954/0001-58");
		
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setProduto(produto);
		venda.setEmpresa(empresa);
		venda.setEndereco(null);
		venda.setDesconto(0.0);
		
		VendaBussiness vendaBussiness = new VendaBussiness(vendaDAO);			
		try {
			Venda vendaSalva = vendaBussiness.salvarVenda(venda);
		} catch ( RuntimeException e ) {
			assertEquals(e.getMessage(), "Endereço não informada!");
		}
	}
	
	@Test
	public void deveRetornarRuntimeExceptionCasoVendaNull() {
		Cliente cliente = new Cliente();
		cliente.setNome("Vinícius Manso Carrijo");
		cliente.setCpf("448.071.858.37");
		cliente.setSexo('M');
		
		Produto produto = new Produto();
		produto.setNome("Monitor 29 Polegadas");
		produto.setDescricao("Monitor Pro Gamer - 29” LED Full HD UltraWide IPS HDMI 75kHz 1ms");
		produto.setPreco(1250.20);	
		
		Empresa empresa = new Empresa();
		empresa.setFantasia("Vinícius Manso Carrijo");
		empresa.setCnpj("42.297.954/0001-58");
		
		Endereco endereco = new Endereco();
		endereco.setPais("Brasil");
		endereco.setCidade("Franca");
		endereco.setBairro("São Luis II");
		endereco.setRua("João Nestor dos Santos");
		endereco.setNumero("2550");
		
		VendaBussiness vendaBussiness = new VendaBussiness(vendaDAO);			
		try {
			Venda vendaSalva = vendaBussiness.salvarVenda(null);
		} catch ( RuntimeException e ) {
			assertEquals(e.getMessage(), "Venda não informada!");
		}
	}
	
	@Test
	public void deveConcluirVendaCasoDescontoNull() {
		Cliente cliente = new Cliente();
		cliente.setNome("Vinícius Manso Carrijo");
		cliente.setCpf("448.071.858.37");
		cliente.setSexo('M');
		
		Produto produto = new Produto();
		produto.setNome("Monitor 29 Polegadas");
		produto.setDescricao("Monitor Pro Gamer - 29” LED Full HD UltraWide IPS HDMI 75kHz 1ms");
		produto.setPreco(1250.20);
		
		Empresa empresa = new Empresa();
		empresa.setFantasia("Vinícius Manso Carrijo");
		empresa.setCnpj("42.297.954/0001-58");
		
		Endereco endereco = new Endereco();
		endereco.setPais("Brasil");
		endereco.setCidade("Franca");
		endereco.setBairro("São Luis II");
		endereco.setRua("João Nestor dos Santos");
		endereco.setNumero("2550");
		
		Venda vendaStub = new Venda();
		vendaStub.setId(1L);
		vendaStub.setCliente(cliente);
		vendaStub.setProduto(produto);
		vendaStub.setEmpresa(empresa);
		vendaStub.setEndereco(endereco);
		vendaStub.setDesconto(null);
		
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setProduto(produto);
		venda.setEmpresa(empresa);
		venda.setEndereco(endereco);
		venda.setDesconto(null);
		
		Mockito.when(vendaDAO.salvarVenda(venda)).thenReturn(vendaStub);
		
		VendaBussiness vendaBussiness = new VendaBussiness(vendaDAO);
		
		Venda vendaSalva = vendaBussiness.salvarVenda(venda);
		
		assertEquals(vendaStub, vendaSalva);
	}
	
	@Test
	public void deveRetornarExceptionCasoConexaoFalhar() {	
		Cliente cliente = new Cliente();
		cliente.setNome("Vinícius Manso Carrijo");
		cliente.setCpf("448.071.858.37");
		cliente.setSexo('M');
		
		Produto produto = new Produto();
		produto.setNome("Monitor 29 Polegadas");
		produto.setDescricao("Monitor Pro Gamer - 29” LED Full HD UltraWide IPS HDMI 75kHz 1ms");
		produto.setPreco(1250.20);
		
		Empresa empresa = new Empresa();
		empresa.setFantasia("Vinícius Manso Carrijo");
		empresa.setCnpj("42.297.954/0001-58");
		
		Endereco endereco = new Endereco();
		endereco.setPais("Brasil");
		endereco.setCidade("Franca");
		endereco.setBairro("São Luis II");
		endereco.setRua("João Nestor dos Santos");
		endereco.setNumero("2550");
		
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setProduto(produto);
		venda.setEmpresa(empresa);
		venda.setEndereco(endereco);
		venda.setDesconto(0.0);
		
		Mockito.when(vendaDAO.salvarVenda(venda)).thenThrow(new RuntimeException("Erro ao estabelecer conexão com banco"));
		
		VendaBussiness vendaBussiness = new VendaBussiness(vendaDAO);
		
		try {
			vendaBussiness.salvarVenda(venda);
		} catch ( RuntimeException e ) {
			assertEquals(e.getMessage(), "Erro ao estabelecer conexão com banco");
		}
	}	
}
