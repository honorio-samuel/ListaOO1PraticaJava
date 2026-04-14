package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    @Test
    public void deveAdicionarEstoqueCorretamente() {
        Produto produto = new Produto("Mouse Gamer", 150.0, 10);
        produto.adicionarEstoque(5);
        Assertions.assertEquals(15, produto.getQuantidadeEstoque());
    }

    @Test
    public void deveRemoverEstoqueQuandoDisponivel() {
        Produto produto = new Produto("Mouse Gamer", 150.0, 10);
        produto.removerEstoque(3);
        Assertions.assertEquals(7, produto.getQuantidadeEstoque());
    }

    @Test
    public void deveCalcularValorTotalDoEstoque() {
        Produto produto = new Produto("Mouse Gamer", 150.0, 10);
        // 150.0 * 10 = 1500.0
        Assertions.assertEquals(1500.0, produto.calcularValorTotalEstoque());
    }

    @Test
    public void deveLancarExcecaoAoRemoverMaisQueOEstoque() {
        Produto produto = new Produto("Mouse Gamer", 150.0, 10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            produto.removerEstoque(11);
        });
    }

    @Test
    public void deveLancarExcecaoParaPrecoNegativoNoConstrutor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Teclado", -50.0, 5);
        });
    }

    @Test
    public void deveLancarExcecaoParaAdicaoNegativa() {
        Produto produto = new Produto("Mouse Gamer", 150.0, 10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            produto.adicionarEstoque(-1);
        });
    }
}
