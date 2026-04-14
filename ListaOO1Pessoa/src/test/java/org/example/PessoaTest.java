package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaTest {
    private Pessoa pessoa;

    @Test
    public void deveEnvelhecerUmAno() {
        Pessoa pessoa = new Pessoa("Carlos", 15, 160.0, 50.0);
        pessoa.envelhecer();
        Assertions.assertEquals(16, pessoa.getIdade());
    }

    @Test
    public void deveCrescerSeTiverMenosDe21Anos() {
        Pessoa pessoa = new Pessoa("Carlos", 15, 160.0, 50.0);
        pessoa.crescer(2.0);
        Assertions.assertEquals(162.0, pessoa.getAltura());
    }

    @Test
    public void naoDeveCrescerSeTiver21AnosOuMais() {
        Pessoa pessoa = new Pessoa("Carlos", 21, 160.0, 50.0);
        pessoa.crescer(2.0);
        Assertions.assertEquals(160.0, pessoa.getAltura());
    }

    @Test
    public void deveGanharPesoCorretamente() {
        Pessoa pessoa = new Pessoa("Carlos", 15, 160.0, 50.0);
        pessoa.ganhar_peso(5.0);
        Assertions.assertEquals( 55.0, pessoa.getPeso());
    }

    @Test
    public void devePerderPesoCorretamente() {
        Pessoa pessoa = new Pessoa("Carlos", 15, 160.0, 55.0);
        pessoa.perder_peso(3.0);
        Assertions.assertEquals(52.0, pessoa.getPeso());
    }

    @Test
    public void deveLancarExcecaoParaCrescimentoNegativo() {
        Pessoa pessoa = new Pessoa("Carlos", 15, 160.0, 50.0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            pessoa.crescer(-1.0);
        });
    }

    @Test
    public void naoDeveTerPesoNegativo() {
        Pessoa pessoa = new Pessoa("Carlos", 15, 160.0, 50.0);
        pessoa.perder_peso(100.0);
        Assertions.assertEquals(0, pessoa.getPeso());
    }
}