package br.edu.unifacef.bussiness;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.unifacef.bussines.ProdutoBussiness;
import br.edu.unifacef.dao.ProdutoDAO;
import br.edu.unifacef.model.Produto;

@RunWith(MockitoJUnitRunner.class)
public class ProdutoBussinessTest {
	
	@Mock
	private ProdutoDAO produtoDAO;

	@Test
	public void deveSalvarProdutoSucesso() {
		Produto produtoStub = new Produto();
		produtoStub.setId(1L);
		produtoStub.setNome("Teclado com fio USB");
		produtoStub.setDescricao("Teclado com fio USB Logitech K120 Resistente à Respingos e Layout ABNT2");
		produtoStub.setPreco(70.50);
		
		Produto novoProduto = new Produto();
		novoProduto.setNome("Mouse com fio USB");
		novoProduto.setDescricao("Mouse com fio USB Logitech M90 - Cinza");
		novoProduto.setPreco(70.50);
		
		Mockito.when(produtoDAO.salvar(novoProduto)).thenReturn(produtoStub);
		
		ProdutoBussiness produtoBussiness = new ProdutoBussiness(produtoDAO);
		
		Produto produtoSalvo = produtoBussiness.salvarProduto(novoProduto);
		
		assertEquals(produtoStub, produtoSalvo);
	}
	
	@Test
	public void deveRetornarRuntimeExceptionQuandoProdutoNull() {
		Produto novoProduto = null;
		
		ProdutoBussiness produtoBussiness = new ProdutoBussiness(produtoDAO);
		
		try {
			Produto produtoSalvo = produtoBussiness.salvarProduto(novoProduto);
		}catch(RuntimeException e) {
			assertEquals(e.getMessage(), "Produto não informado!");
		}
	}
	
	@Test
	public void deveRetornarRuntimeExceptionQuandoNomeVazio() {
		Produto novoProduto = new Produto();
		novoProduto.setNome("");
		novoProduto.setDescricao("Mouse com fio USB Logitech M90 - Cinza");
		novoProduto.setPreco(70.50);
		
		ProdutoBussiness produtoBussiness = new ProdutoBussiness(produtoDAO);
		
		try {
			Produto produtoSalvo = produtoBussiness.salvarProduto(novoProduto);
		}catch(RuntimeException e) {
			assertEquals(e.getMessage(), "Nome requerido");
		}
	}
	
	@Test
	public void deveRetornarRuntimeExceptionQuandoDescricaoVazia() {
		Produto novoProduto = new Produto();
		novoProduto.setNome("Mouse com fio USB ");
		novoProduto.setDescricao("");
		novoProduto.setPreco(70.50);
		
		ProdutoBussiness produtoBussiness = new ProdutoBussiness(produtoDAO);
		
		try {
			Produto produtoSalvo = produtoBussiness.salvarProduto(novoProduto);
		}catch(RuntimeException e) {
			assertEquals(e.getMessage(), "Descrição requerida");
		}
	}
	
	@Test
	public void deveRetornarProdutoQuandoChamadoMetodoBuscar() {	
		
		Produto produtoStub = new Produto();
		produtoStub.setId(1L);
		produtoStub.setNome("Teclado com fio USB");
		produtoStub.setDescricao("Teclado com fio USB Logitech K120 Resistente à Respingos e Layout ABNT2");
		produtoStub.setPreco(70.50);
		
		Mockito.when(produtoDAO.buscar(130L)).thenReturn(produtoStub);
		
		ProdutoBussiness produtoBussiness = new ProdutoBussiness(produtoDAO);
		
		Produto produtoBusca = produtoBussiness.buscarProduto(130L);
		
		assertEquals(produtoStub, produtoBusca);
	}
	
	@Test
	public void deveRetornarExceptionCasoConexaoFalhar() {	
		Produto novoProduto = new Produto();
		novoProduto.setNome("Mouse com fio USB");
		novoProduto.setDescricao("Mouse com fio USB Logitech M90 - Cinza");
		novoProduto.setPreco(70.50);
		
		Mockito.when(produtoDAO.salvar(novoProduto)).thenThrow(new RuntimeException("Erro ao estabelecer conexão com banco"));
		
		ProdutoBussiness produtoBussiness = new ProdutoBussiness(produtoDAO);
		
		try {
			produtoBussiness.salvarProduto(novoProduto);
		} catch ( RuntimeException e ) {
			assertEquals(e.getMessage(), "Erro ao estabelecer conexão com banco");			
		}
	}

}
