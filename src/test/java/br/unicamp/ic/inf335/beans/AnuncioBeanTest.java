package br.unicamp.ic.inf335.beans;

import br.unicamp.ic.inf335.app.beans.AnuncioBean;
import br.unicamp.ic.inf335.app.beans.ProdutoBean;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static junit.framework.Assert.*;

public class AnuncioBeanTest {

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

        assertEquals(0.15,anuncioBean.getDesconto());
        assertEquals("www.mercadolivre.com.br",anuncioBean.getFotosUrl().get(0).getHost());
        assertEquals("https",anuncioBean.getFotosUrl().get(0).getProtocol());
        assertEquals(3825.00,anuncioBean.getValor());
        assertEquals("123",anuncioBean.getProduto().getCodigo());
        assertEquals("Playstation 5",anuncioBean.getProduto().getNome());
        assertEquals("Console Playstation 5 Digital Edition",anuncioBean.getProduto().getDescricao());
        assertEquals("NOVO",anuncioBean.getProduto().getEstado());
        assertEquals(4500.00,anuncioBean.getProduto().getValor());
    }


}
