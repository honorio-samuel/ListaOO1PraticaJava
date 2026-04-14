package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FuncionarioTest {
    private Funcionario funcionario;

    @Test
    public void deveAplicarReajusteCorretamente() {
        Funcionario funcionario = new Funcionario("João Silva", "Analista", 5000.0);
        funcionario.aplicarReajuste(10.0);
        Assertions.assertEquals(5500.0, funcionario.getSalario());
    }

    @Test
    public void deveCalcularSalarioAnualCorretamente() {
        Funcionario funcionario = new Funcionario("João Silva", "Analista", 5000.0);
        Assertions.assertEquals(60000.0, funcionario.calcularSalarioAnual());
    }

    @Test
    public void deveLancarExcecaoParaReajusteNegativo() {
        Funcionario funcionario = new Funcionario("João Silva", "Analista", 5000.0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            funcionario.aplicarReajuste(-5.0);
        });
    }

    @Test
    public void deveLancarExcecaoParaSalarioNegativoNoConstrutor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Funcionario("Invalido", "Cargo", -100.0);
        });
    }

    @Test
    public void devePermitirAlterarCargo() {
        Funcionario funcionario = new Funcionario("João Silva", "Analista", 5000.0);
        funcionario.setCargo("Gerente");
        Assertions.assertEquals("Gerente", funcionario.getCargo());
    }
}
