package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LivroTest {
    private Livro livro;

    @Test
    public void deveAbrirLivroCorretamente() {
        Livro livro = new Livro("O Hobbit", "J.R.R. Tolkien", 300);
        livro.abrir();
        livro.avancar_pagina();
        Assertions.assertEquals(1, livro.getPaginaAtual());
    }

    @Test
    public void naoDeveAvancarPaginaSeLivroEstiverFechado() {
        Livro livro = new Livro("O Hobbit", "J.R.R. Tolkien", 300);
        livro.avancar_pagina();
        Assertions.assertEquals(0, livro.getPaginaAtual());
    }

    @Test
    public void deveMarcarPaginaValida() {
        Livro livro = new Livro("O Hobbit", "J.R.R. Tolkien", 300);
        livro.marcar_pagina(150);
        Assertions.assertEquals(150, livro.getPaginaAtual());
    }

    @Test
    public void deveLancarExcecaoAoMarcarPaginaInexistente() {
        Livro livro = new Livro("O Hobbit", "J.R.R. Tolkien", 300);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            livro.marcar_pagina(350);
        });
    }

    @Test
    public void deveLancarExcecaoNumeroDePaginasInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Livro("Livro Vazio", "Autor", 0);
        });
    }

    @Test
    public void naoDeveRetrocederAbaixoDeZero() {
        Livro livro = new Livro("O Hobbit", "J.R.R. Tolkien", 300);
        livro.abrir();
        livro.retroceder_pagina();
        Assertions.assertEquals(0, livro.getPaginaAtual());
    }

    @Test
    public void naoDeveAvancarAlemDoLimiteDePaginas() {
        Livro livro = new Livro("O Hobbit", "J.R.R. Tolkien", 300);
        livro.abrir();
        livro.marcar_pagina(300);
        livro.avancar_pagina();
        Assertions.assertEquals(300, livro.getPaginaAtual());
    }
}