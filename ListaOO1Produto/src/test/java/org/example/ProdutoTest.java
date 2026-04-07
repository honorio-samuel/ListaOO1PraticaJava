package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTest {
    private Produto produto;

    @BeforeEach
    public void setUp() {
        produto = new Produto("Mouse Gamer", 150.0, 10);
    }

    @Test
    public void deveAdicionarEstoqueCorretamente() {
        produto.adicionarEstoque(5);
        Assertions.assertEquals(15, produto.getQuantidadeEstoque());
    }

    @Test
    public void deveRemoverEstoqueQuandoDisponivel() {
        produto.removerEstoque(3);
        Assertions.assertEquals(7, produto.getQuantidadeEstoque());
    }

    @Test
    public void deveCalcularValorTotalDoEstoque() {
        // 150.0 * 10 = 1500.0
        Assertions.assertEquals(1500.0, produto.calcularValorTotalEstoque());
    }

    @Test
    public void deveLancarExcecaoAoRemoverMaisQueOEstoque() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            produto.removerEstoque(11); // Tenta remover 11 tendo apenas 10
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
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            produto.adicionarEstoque(-1);
        });
    }
}
