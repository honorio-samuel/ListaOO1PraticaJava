package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContaBancariaTest {
    private ContaBancaria conta;

    @Test
    public void deveDepositarValorPositivo() {
        ContaBancaria conta = new ContaBancaria("João Silva", "12345-6");
        conta.depositar(500.0);
        Assertions.assertEquals(500.0, conta.getSaldo());
    }

    @Test
    public void deveSacarValorComSaldoSuficiente() {
        ContaBancaria conta = new ContaBancaria("João Silva", "12345-6");
        conta.depositar(1000.0);
        conta.sacar(400.0);
        Assertions.assertEquals(600.0, conta.getSaldo());
    }

    @Test
    public void deveLancarExcecaoAoSacarMaisQueOSaldo() {
        ContaBancaria conta = new ContaBancaria("João Silva", "12345-6");
        conta.depositar(100.0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            conta.sacar(100.01);
        });
    }

    @Test
    public void deveLancarExcecaoParaDepositoNegativo() {
        ContaBancaria conta = new ContaBancaria("João Silva", "12345-6");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            conta.depositar(-50.0);
        });
    }

    @Test
    public void devePermitirZerarOSaldoNoSaque() {
        ContaBancaria conta = new ContaBancaria("João Silva", "12345-6");
        conta.depositar(250.0);
        conta.sacar(250.0);
        Assertions.assertEquals(0.0, conta.getSaldo());
    }
}