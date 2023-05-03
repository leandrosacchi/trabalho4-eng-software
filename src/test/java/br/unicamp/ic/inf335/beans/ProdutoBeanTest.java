package br.unicamp.ic.inf335.beans;

import br.unicamp.ic.inf335.app.beans.ProdutoBean;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class ProdutoBeanTest {

    @Test
    public void testSetterAndGetter() throws IOException {
        ProdutoBean produtoBean = new ProdutoBean();
        produtoBean.setCodigo("123");
        produtoBean.setNome("Playstation 5");
        produtoBean.setDescricao("Console Playstation 5 Digital Edition");
        produtoBean.setEstado("NOVO");
        produtoBean.setValor(4500.00);

        assertEquals("123",produtoBean.getCodigo());
        assertEquals("Playstation 5",produtoBean.getNome());
        assertEquals("Console Playstation 5 Digital Edition",produtoBean.getDescricao());
        assertEquals("NOVO",produtoBean.getEstado());
        assertEquals(4500.00,produtoBean.getValor());
    }

    @Test
    public void testComparable(){
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

        List<ProdutoBean> produtos = new ArrayList<>();
        produtos.add(produtoBean2);
        produtos.add(produtoBean);
        produtos.add(produtoBean3);

        Collections.sort(produtos);

        assertEquals(1000.00, produtos.get(0).getValor());
        assertEquals(3000.00, produtos.get(1).getValor());
        assertEquals(4500.00, produtos.get(2).getValor());
    }

}
