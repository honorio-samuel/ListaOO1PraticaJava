package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PessoaTest {
    private Pessoa pessoa;

    @BeforeEach
    public void setUp() {

        pessoa = new Pessoa("Lucas", 15, 160.0, 55.0);
    }

    @Test
    public void deveEnvelhecerUmAno() {
        pessoa.envelhecer();
        Assertions.assertEquals(16, pessoa.getIdade());
    }

    @Test
    public void deveCrescerSeTiverMenosDe21Anos() {
        pessoa.crescer(2.0);
        Assertions.assertEquals(162.0, pessoa.getAltura());
    }

    @Test
    public void naoDeveCrescerSeTiver21AnosOuMais() {
        pessoa.setIdade(21);
        pessoa.crescer(2.0);
        Assertions.assertEquals(160.0, pessoa.getAltura());
    }

    @Test
    public void deveGanharPesoCorretamente() {
        pessoa.ganhar_peso(5.0);
        Assertions.assertEquals(60.0, pessoa.getPeso());
    }

    @Test
    public void devePerderPesoCorretamente() {
        pessoa.perder_peso(3.0);
        Assertions.assertEquals(52.0, pessoa.getPeso());
    }

    @Test
    public void deveLancarExcecaoParaCrescimentoNegativo() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            pessoa.crescer(-1.0);
        });
    }

    @Test
    public void naoDeveTerPesoNegativo() {
        pessoa.perder_peso(100.0);
        Assertions.assertEquals(0, pessoa.getPeso());
    }
}