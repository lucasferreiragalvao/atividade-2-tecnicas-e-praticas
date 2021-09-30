package br.edu.unifacef.bussiness;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.unifacef.bussines.ClienteBussiness;
import br.edu.unifacef.dao.ClienteDAO;
import br.edu.unifacef.model.Cliente;

@RunWith(MockitoJUnitRunner.class)
public class ClienteBussinessTest {

	@Mock
	private ClienteDAO clienteDAO;
	
	@Test
	public void deveSalvarClienteSucesso() {
		Cliente clienteStub = new Cliente();
		clienteStub.setId(1L);
		clienteStub.setNome("Nome Stub");
		clienteStub.setCpf("111.111.111-11");
		clienteStub.setSexo('F');
		
		Cliente novoCliente = new Cliente();
		novoCliente.setNome("Galvão");
		novoCliente.setCpf("222.222.222-22");
		novoCliente.setSexo('M');
		
		Mockito.when(clienteDAO.salvar(novoCliente)).thenReturn(clienteStub);
		
		ClienteBussiness clienteBussiness = new ClienteBussiness(clienteDAO);
		
		Cliente clienteSalvo = clienteBussiness.salvarCliente(novoCliente);
		
		assertEquals(clienteStub, clienteSalvo);
	}
	
	@Test
	public void deveRetornarRuntimeExceptionQuandoClienteNull() {
		Cliente novoCliente = null;
		
		ClienteBussiness clienteBussiness = new ClienteBussiness(clienteDAO);
		
		try {
			Cliente clienteSalvo = clienteBussiness.salvarCliente(novoCliente);
		} catch(RuntimeException e) {
			assertEquals(e.getMessage(), "Cliente não informado!");
		}
	}
	
	@Test
	public void deveRetornarRuntimeExceptionQuandoNomeVazio() {
		Cliente novoCliente = new Cliente();
		novoCliente.setNome("");
		novoCliente.setCpf("222.222.222-22");
		novoCliente.setSexo('M');
		
		ClienteBussiness clienteBussiness = new ClienteBussiness(clienteDAO);
		
		try {
			Cliente clienteSalvo = clienteBussiness.salvarCliente(novoCliente);
		} catch(RuntimeException e) {
			assertEquals(e.getMessage(), "Nome requerido");
		}
	}
	
	@Test
	public void deveRetornarRuntimeExceptionQuandoCpfVazio() {
		Cliente novoCliente = new Cliente();
		novoCliente.setNome("Galvão");
		novoCliente.setCpf("");
		novoCliente.setSexo('M');
		
		ClienteBussiness clienteBussiness = new ClienteBussiness(clienteDAO);
		
		try {
			Cliente clienteSalvo = clienteBussiness.salvarCliente(novoCliente);
		} catch(RuntimeException e) {
			assertEquals(e.getMessage(), "CPF requerido");
		}
	}
	
	@Test
	public void deveRetornarClienteCasoSexoNaoInformado() {
		Cliente clienteStub = new Cliente();
		clienteStub.setId(1L);
		clienteStub.setNome("Nome Stub");
		clienteStub.setCpf("111.111.111-11");
		
		Cliente novoCliente = new Cliente();
		novoCliente.setNome("Galvão");
		novoCliente.setCpf("222.222.222-22");
		
		Mockito.when(clienteDAO.salvar(novoCliente)).thenReturn(clienteStub);
		
		ClienteBussiness clienteBussiness = new ClienteBussiness(clienteDAO);
		
		Cliente clienteSalvo = clienteBussiness.salvarCliente(novoCliente);
		assertEquals(clienteStub, clienteSalvo);
	}
	
	@Test
	public void deveRetornarExceptionCasoConexaoFalhar() {	
		Cliente novoCliente = new Cliente();
		novoCliente.setNome("Galvão");
		novoCliente.setCpf("222.222.222-22");
		novoCliente.setSexo('M');
		
		Mockito.when(clienteDAO.salvar(novoCliente)).thenThrow(new RuntimeException("Erro ao estabelecer conexão com banco"));
		
		ClienteBussiness clienteBussiness = new ClienteBussiness(clienteDAO);
		
		try {
			clienteBussiness.salvarCliente(novoCliente);
		} catch ( RuntimeException e ) {
			assertEquals(e.getMessage(), "Erro ao estabelecer conexão com banco");			
		}
	}
}
