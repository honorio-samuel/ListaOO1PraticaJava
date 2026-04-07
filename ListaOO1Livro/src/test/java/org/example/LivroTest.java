package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LivroTest {
    private Livro livro;

    @BeforeEach
    public void setUp() {
        livro = new Livro();
        livro.setTitulo("O Hobbit");
        livro.setAutor("J.R.R. Tolkien");
        livro.setNumero_paginas(300);
    }

    @Test
    public void deveAbrirLivroCorretamente() {
        livro.abrir();
        livro.avancar_pagina();
        Assertions.assertEquals(1, livro.getPaginaAtual());
    }

    @Test
    public void naoDeveAvancarPaginaSeLivroEstiverFechado() {
        livro.fechar();
        livro.avancar_pagina();
        Assertions.assertEquals(0, livro.getPaginaAtual());
    }

    @Test
    public void deveMarcarPaginaValida() {
        livro.marcar_pagina(150);
        Assertions.assertEquals(150, livro.getPaginaAtual());
    }

    @Test
    public void deveLancarExcecaoAoMarcarPaginaInexistente() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            livro.marcar_pagina(350); // Livro só tem 300 páginas
        });
    }

    @Test
    public void deveLancarExcecaoNumeroDePaginasInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            livro.setNumero_paginas(0);
        });
    }

    @Test
    public void naoDeveRetrocederAbaixoDeZero() {
        livro.abrir();
        livro.retroceder_pagina();
        Assertions.assertEquals(0, livro.getPaginaAtual());
    }

    @Test
    public void naoDeveAvancarAlemDoLimiteDePaginas() {
        livro.abrir();
        livro.marcar_pagina(300);
        livro.avancar_pagina();
        Assertions.assertEquals(300, livro.getPaginaAtual());
    }
}