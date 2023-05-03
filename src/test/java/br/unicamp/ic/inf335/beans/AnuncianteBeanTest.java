/**
 * 
 */
package br.unicamp.ic.inf335.beans;

import br.unicamp.ic.inf335.app.beans.AnuncianteBean;
import br.unicamp.ic.inf335.app.beans.AnuncioBean;
import br.unicamp.ic.inf335.app.beans.ProdutoBean;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static junit.framework.Assert.*;

public class AnuncianteBeanTest {

	@Test
	public void	testSetterAndGetter() throws IOException {
		ArrayList<URL> urls = new ArrayList<>();
		urls.add(new URL("https://www.mercadolivre.com.br"));

		ProdutoBean produtoBean = new ProdutoBean();
		produtoBean.setCodigo("123");
		produtoBean.setNome("Playstation 5");
		produtoBean.setDescricao("Console Playstation 5 Digital Edition");
		produtoBean.setEstado("NOVO");
		produtoBean.setValor(4500.00);

		AnuncioBean anuncioBean = new AnuncioBean();
		anuncioBean.setDesconto(0.15);
		anuncioBean.setProduto(produtoBean);
		anuncioBean.setFotosUrl(urls);

		ArrayList<AnuncioBean> anuncios = new ArrayList<>();
		anuncios.add(anuncioBean);

		AnuncianteBean anuncianteBean = new AnuncianteBean();
		anuncianteBean.setCPF("36537256828");
		anuncianteBean.setNome("Leandro");
		anuncianteBean.setAnuncios(anuncios);

		assertEquals("36537256828",anuncianteBean.getCPF());
		assertEquals("Leandro",anuncianteBean.getNome());
		assertEquals(0.15,anuncianteBean.getAnuncios().get(0).getDesconto());
		assertEquals("www.mercadolivre.com.br",anuncianteBean.getAnuncios().get(0).getFotosUrl().get(0).getHost());
		assertEquals("https",anuncianteBean.getAnuncios().get(0).getFotosUrl().get(0).getProtocol());
		assertEquals(3825.00,anuncianteBean.getAnuncios().get(0).getValor());
		assertEquals("123",anuncianteBean.getAnuncios().get(0).getProduto().getCodigo());
		assertEquals("Playstation 5",anuncianteBean.getAnuncios().get(0).getProduto().getNome());
		assertEquals("Console Playstation 5 Digital Edition",anuncianteBean.getAnuncios().get(0).getProduto().getDescricao());
		assertEquals("NOVO",anuncianteBean.getAnuncios().get(0).getProduto().getEstado());
		assertEquals(4500.00,anuncianteBean.getAnuncios().get(0).getProduto().getValor());
	}

	@Test
	public void testAddAnuncio() throws MalformedURLException {
		ArrayList<URL> urls = new ArrayList<>();
		urls.add(new URL("https://www.mercadolivre.com.br"));

		ProdutoBean produtoBean = new ProdutoBean();
		produtoBean.setCodigo("123");
		produtoBean.setNome("Playstation 5");
		produtoBean.setDescricao("Console Playstation 5 Digital Edition");
		produtoBean.setEstado("NOVO");
		produtoBean.setValor(4500.00);

		AnuncioBean anuncioBean = new AnuncioBean();
		anuncioBean.setDesconto(0.15);
		anuncioBean.setProduto(produtoBean);
		anuncioBean.setFotosUrl(urls);

		AnuncianteBean anuncianteBean = new AnuncianteBean();
		anuncianteBean.addAnuncio(anuncioBean);
		anuncianteBean.addAnuncio(anuncioBean);

		assertEquals(2, anuncianteBean.getAnuncios().size());
		assertEquals(0.15,anuncianteBean.getAnuncios().get(0).getDesconto());
		assertEquals("www.mercadolivre.com.br",anuncianteBean.getAnuncios().get(0).getFotosUrl().get(0).getHost());
		assertEquals("https",anuncianteBean.getAnuncios().get(0).getFotosUrl().get(0).getProtocol());
		assertEquals(3825.00,anuncianteBean.getAnuncios().get(0).getValor());
		assertEquals("123",anuncianteBean.getAnuncios().get(0).getProduto().getCodigo());
		assertEquals("Playstation 5",anuncianteBean.getAnuncios().get(0).getProduto().getNome());
		assertEquals("Console Playstation 5 Digital Edition",anuncianteBean.getAnuncios().get(0).getProduto().getDescricao());
		assertEquals("NOVO",anuncianteBean.getAnuncios().get(0).getProduto().getEstado());
		assertEquals(4500.00,anuncianteBean.getAnuncios().get(0).getProduto().getValor());
	}

	@Test
	public void testRemoveAnuncio() throws MalformedURLException {
		ArrayList<URL> urls = new ArrayList<>();
		urls.add(new URL("https://www.mercadolivre.com.br"));

		ProdutoBean produtoBean = new ProdutoBean();
		produtoBean.setCodigo("123");
		produtoBean.setNome("Playstation 5");
		produtoBean.setDescricao("Console Playstation 5 Digital Edition");
		produtoBean.setEstado("NOVO");
		produtoBean.setValor(4500.00);

		AnuncioBean anuncioBean = new AnuncioBean();
		anuncioBean.setDesconto(0.15);
		anuncioBean.setProduto(produtoBean);
		anuncioBean.setFotosUrl(urls);

		AnuncianteBean anuncianteBean = new AnuncianteBean();
		anuncianteBean.addAnuncio(anuncioBean);
		anuncianteBean.addAnuncio(anuncioBean);
		anuncianteBean.addAnuncio(anuncioBean);
		anuncianteBean.addAnuncio(anuncioBean);
		anuncianteBean.addAnuncio(anuncioBean);
		anuncianteBean.removeAnuncio(1);

		assertEquals(4, anuncianteBean.getAnuncios().size());
	}

	@Test
	public void testValorMedioAnuncio() throws MalformedURLException {
		ArrayList<URL> urls = new ArrayList<>();
		urls.add(new URL("https://www.mercadolivre.com.br"));

		ProdutoBean produtoBean = new ProdutoBean();
		produtoBean.setCodigo("123");
		produtoBean.setNome("Playstation 5");
		produtoBean.setDescricao("Console Playstation 5 Digital Edition");
		produtoBean.setEstado("NOVO");
		produtoBean.setValor(4500.00);

		ProdutoBean produtoBean2 = new ProdutoBean();
		produtoBean2.setCodigo("456");
		produtoBean2.setNome("TV Samsung 65 polegadas");
		produtoBean2.setDescricao("TV Samsung 65 polegadas");
		produtoBean2.setEstado("NOVO");
		produtoBean2.setValor(3000.00);

		ProdutoBean produtoBean3 = new ProdutoBean();
		produtoBean3.setCodigo("789");
		produtoBean3.setNome("Geladeira Consul 450 L");
		produtoBean3.setDescricao("Geladeira Consul 450 L");
		produtoBean3.setEstado("USADA");
		produtoBean3.setValor(1000.00);

		AnuncioBean anuncioBean = new AnuncioBean();
		anuncioBean.setDesconto(0.15);
		anuncioBean.setProduto(produtoBean);
		anuncioBean.setFotosUrl(urls);

		AnuncioBean anuncioBean2 = new AnuncioBean();
		anuncioBean2.setDesconto(0.00);
		anuncioBean2.setProduto(produtoBean2);
		anuncioBean2.setFotosUrl(urls);

		AnuncioBean anuncioBean3 = new AnuncioBean();
		anuncioBean3.setDesconto(0.10);
		anuncioBean3.setProduto(produtoBean3);
		anuncioBean3.setFotosUrl(urls);

		AnuncianteBean anuncianteBean = new AnuncianteBean();
		anuncianteBean.addAnuncio(anuncioBean);
		anuncianteBean.addAnuncio(anuncioBean2);
		anuncianteBean.addAnuncio(anuncioBean3);

		//Valores:
		//Anuncio 1: 4500*(1-0,15)= 3825
		//Anuncio 2: 3000*(1-0,00)= 3000
		//Anuncio 3: 1000*(1-0,10)= 900
		//Média esperada: 7725 / 3 = 2575
		assertEquals(2575.00, anuncianteBean.valorMedioAnuncios());
	}


}
