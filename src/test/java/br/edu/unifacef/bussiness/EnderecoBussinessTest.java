package br.edu.unifacef.bussiness;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.unifacef.bussines.EnderecoBussiness;
import br.edu.unifacef.dao.EnderecoDAO;

import br.edu.unifacef.model.Endereco;



@RunWith(MockitoJUnitRunner.class)
public class EnderecoBussinessTest {
	
	@Mock
	private EnderecoDAO enderecoDAO;

	@Test
	public void deveSalvarEnderecoSucesso() {
		Endereco enderecoStub = new Endereco();
		enderecoStub.setId(1L);
		enderecoStub.setPais("Brasil");
		enderecoStub.setCidade("Franca");
		enderecoStub.setBairro("São Luis II");
		enderecoStub.setRua("João Nestor dos Santos");
		enderecoStub.setNumero("2550");
		
		Endereco novoEndereco = new Endereco();
		novoEndereco.setPais("Brasil");
		novoEndereco.setCidade("Ribeirão Preto");
		novoEndereco.setBairro("São Jorge");
		novoEndereco.setRua("Pedro Mendonça");
		novoEndereco.setNumero("125");
		
		Mockito.when(enderecoDAO.salvar(novoEndereco)).thenReturn(enderecoStub);
		
		EnderecoBussiness enderecoBussiness = new EnderecoBussiness(enderecoDAO);
		
		Endereco enderecoSalvo = enderecoBussiness.salvarEndereco(novoEndereco);
		
		assertEquals(enderecoStub, enderecoSalvo);
	}
	
	@Test
	public void deveRetornarRuntimeExceptionQuandoEnderecoNull() {
		Endereco novoEndereco  = null;
		
		EnderecoBussiness enderecoBussiness = new EnderecoBussiness(enderecoDAO);
		
		try {
			enderecoBussiness.salvarEndereco(novoEndereco);
		} catch(RuntimeException e) {
			assertEquals(e.getMessage(), "Endereço não informado!");
		}
	}
	
	@Test
	public void deveRetornarRuntimeExceptionQuandoNumeroVazio() {
		Endereco novoEndereco = new Endereco();
		novoEndereco.setPais("Brasil");
		novoEndereco.setCidade("Ribeirão Preto");
		novoEndereco.setBairro("São Jorge");
		novoEndereco.setRua("Pedro Mendonça");
		novoEndereco.setNumero("");
		
		EnderecoBussiness enderecoBussiness = new EnderecoBussiness(enderecoDAO);
		
		try {
			enderecoBussiness.salvarEndereco(novoEndereco);
		} catch(RuntimeException e) {
			assertEquals(e.getMessage(), "Endereço deve conter um número");
		}
	}
	
	@Test
	public void deveRetornarRuntimeExceptionQuandoRuaVazia() {
		Endereco novoEndereco = new Endereco();
		novoEndereco.setPais("Brasil");
		novoEndereco.setCidade("Ribeirão Preto");
		novoEndereco.setBairro("São Jorge");
		novoEndereco.setRua("");
		novoEndereco.setNumero("125");
		
		EnderecoBussiness enderecoBussiness = new EnderecoBussiness(enderecoDAO);
		
		try {
			enderecoBussiness.salvarEndereco(novoEndereco);
		} catch(RuntimeException e) {
			assertEquals(e.getMessage(), "Rua deve conter um nome");
		}
	}
	
	@Test
	public void deveRetornarRuntimeExceptionQuandoBairroVazia() {
		Endereco novoEndereco = new Endereco();
		novoEndereco.setPais("Brasil");
		novoEndereco.setCidade("Ribeirão Preto");
		novoEndereco.setBairro("");
		novoEndereco.setRua("Pedro Mendonça");
		novoEndereco.setNumero("125");
		
		EnderecoBussiness enderecoBussiness = new EnderecoBussiness(enderecoDAO);
		
		try {
			enderecoBussiness.salvarEndereco(novoEndereco);
		} catch(RuntimeException e) {
			assertEquals(e.getMessage(), "Bairro deve conter um nome");
		}
	}
	
	@Test
	public void deveRetornarRuntimeExceptionQuandoCidadeVazia() {
		Endereco novoEndereco = new Endereco();
		novoEndereco.setPais("Brasil");
		novoEndereco.setCidade("");
		novoEndereco.setBairro("São Jorge");
		novoEndereco.setRua("Pedro Mendonça");
		novoEndereco.setNumero("125");
		
		EnderecoBussiness enderecoBussiness = new EnderecoBussiness(enderecoDAO);
		
		try {
			enderecoBussiness.salvarEndereco(novoEndereco);
		} catch(RuntimeException e) {
			assertEquals(e.getMessage(), "Cidade deve conter um nome");
		}
	}
	
	@Test
	public void deveRetornarRuntimeExceptionQuandoPaisVazio() {
		Endereco novoEndereco = new Endereco();
		novoEndereco.setPais("");
		novoEndereco.setCidade("Ribeirão Preto");
		novoEndereco.setBairro("São Jorge");
		novoEndereco.setRua("Pedro Mendonça");
		novoEndereco.setNumero("125");
		
		EnderecoBussiness enderecoBussiness = new EnderecoBussiness(enderecoDAO);
		
		try {
			enderecoBussiness.salvarEndereco(novoEndereco);
		} catch(RuntimeException e) {
			assertEquals(e.getMessage(), "País deve conter um nome");
		}
	}
	
	@Test
	public void deveRetornarEnderecoQuandoChamadoMetodoBuscar() {	
		
		Endereco enderecoStub = new Endereco();
		enderecoStub.setId(1L);
		enderecoStub.setPais("Brasil");
		enderecoStub.setCidade("Franca");
		enderecoStub.setBairro("São Luis II");
		enderecoStub.setRua("João Nestor dos Santos");
		enderecoStub.setNumero("2550");
		
		Mockito.when(enderecoDAO.buscar(13L)).thenReturn(enderecoStub);
		
		EnderecoBussiness enderecoBussiness = new EnderecoBussiness(enderecoDAO);
		
		Endereco enderecoBusca = enderecoBussiness.buscarEndereco(13L);
		
		assertEquals(enderecoStub, enderecoBusca);
	}
	
	
	@Test
	public void deveRetornarExceptionCasoConexaoFalhar() {	
		Endereco novoEndereco = new Endereco();
		novoEndereco.setPais("Brasil");
		novoEndereco.setCidade("Ribeirão Preto");
		novoEndereco.setBairro("São Jorge");
		novoEndereco.setRua("Pedro Mendonça");
		novoEndereco.setNumero("125");
		
		Mockito.when(enderecoDAO.salvar(novoEndereco)).thenThrow(new RuntimeException("Erro ao estabelecer conexão com banco"));
		
		EnderecoBussiness enderecoBussiness = new EnderecoBussiness(enderecoDAO);
		
		try {
			enderecoBussiness.salvarEndereco(novoEndereco);
		} catch ( RuntimeException e ) {
			assertEquals(e.getMessage(), "Erro ao estabelecer conexão com banco");			
		}
	}

}
