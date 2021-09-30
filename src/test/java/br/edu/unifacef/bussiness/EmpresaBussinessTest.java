package br.edu.unifacef.bussiness;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.unifacef.bussines.ClienteBussiness;
import br.edu.unifacef.bussines.EmpresaBussiness;
import br.edu.unifacef.dao.EmpresaDAO;
import br.edu.unifacef.model.Cliente;
import br.edu.unifacef.model.Empresa;


@RunWith(MockitoJUnitRunner.class)
public class EmpresaBussinessTest {
	
	@Mock
	private EmpresaDAO empresaDAO;
	
	
	@Test
	public void deveSalvarEmpresaSucesso() {
		Empresa empresaStub = new Empresa();
		empresaStub.setId(1L);
		empresaStub.setCnpj("97.216.163/0001-48");
		empresaStub.setFantasia("Garciar LTDA");
		
		Empresa novaEmpresa = new Empresa();
		novaEmpresa.setCnpj("16.753.683/0001-98");
		novaEmpresa.setFantasia("Empresa Teste");
		
		Mockito.when(empresaDAO.salvar(novaEmpresa)).thenReturn(empresaStub);
		
		EmpresaBussiness empresaBussiness = new EmpresaBussiness(empresaDAO);
		
		Empresa empresaSalva = empresaBussiness.salvarEmpresa(novaEmpresa);
		
		assertEquals(empresaStub, empresaSalva);
	}
	
	@Test
	public void deveRetornarRuntimeExceptionQuandoEmpresaNull() {
		Empresa novaEmpresa  = null;
		
		EmpresaBussiness empresaBussiness = new EmpresaBussiness(empresaDAO);
		
		try {
			empresaBussiness.salvarEmpresa(novaEmpresa);
		} catch(RuntimeException e) {
			assertEquals(e.getMessage(), "Empresa não informada!");
		}
	}
	
	@Test
	public void deveRetornarRuntimeExceptionQuandoFantasiaVazio() {
		Empresa novaEmpresa = new Empresa();
		novaEmpresa.setCnpj("16.753.683/0001-98");
		novaEmpresa.setFantasia("");
		
		EmpresaBussiness empresaBussiness = new EmpresaBussiness(empresaDAO);
		
		try {
			empresaBussiness.salvarEmpresa(novaEmpresa);
		} catch(RuntimeException e) {
			assertEquals(e.getMessage(), "Nome fantasia requerido");
		}
	}
	
	@Test
	public void deveRetornarRuntimeExceptionQuandoCnpjVazio() {
		Empresa novaEmpresa = new Empresa();
		novaEmpresa.setCnpj("");
		novaEmpresa.setFantasia("GARCIA LTDA");
		
		EmpresaBussiness empresaBussiness = new EmpresaBussiness(empresaDAO);
		
		try {
			empresaBussiness.salvarEmpresa(novaEmpresa);
		} catch(RuntimeException e) {
			assertEquals(e.getMessage(), "CNPJ requerido");
		}
	}
	
	@Test
	public void deveRetornarEmpresaQuandoChamadoMetodoBuscar() {	
		
		Empresa empresaStub = new Empresa();
		empresaStub.setId(1L);
		empresaStub.setCnpj("97.216.163/0001-48");
		empresaStub.setFantasia("Garciar LTDA");
		
		Mockito.when(empresaDAO.buscar(33L)).thenReturn(empresaStub);
		
		EmpresaBussiness empresaBussiness = new EmpresaBussiness(empresaDAO);
		
		Empresa empresaBusca = empresaBussiness.buscarEmpresa(33L);
		
		assertEquals(empresaStub, empresaBusca);
	}
	
	@Test
	public void deveRetornarExceptionCasoConexaoFalhar() {	
		Empresa novaEmpresa = new Empresa();
		novaEmpresa.setCnpj("16.753.683/0001-98");
		novaEmpresa.setFantasia("GARCIA LTDA");
		
		Mockito.when(empresaDAO.salvar(novaEmpresa)).thenThrow(new RuntimeException("Erro ao estabelecer conexão com banco"));
		
		EmpresaBussiness empresaBussiness = new EmpresaBussiness(empresaDAO);
		
		try {
			empresaBussiness.salvarEmpresa(novaEmpresa);
		} catch ( RuntimeException e ) {
			assertEquals(e.getMessage(), "Erro ao estabelecer conexão com banco");			
		}
	}

}
