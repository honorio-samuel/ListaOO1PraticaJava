package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContaBancariaTest {
    private ContaBancaria conta;

    @BeforeEach
    void setUp() {
        this.conta = new ContaBancaria();
        this.conta.setTitular("João Silva");
        this.conta.setNumero_conta("12345-6");
    }

    @Test
    public void deveDepositarValorPositivo() {
        conta.depositar(500.0);
        Assertions.assertEquals(500.0, conta.getSaldo());
    }

    @Test
    public void deveSacarValorComSaldoSuficiente() {
        conta.depositar(1000.0);
        conta.sacar(400.0);
        Assertions.assertEquals(600.0, conta.getSaldo());
    }

    @Test
    public void deveLancarExcecaoAoSacarMaisQueOSaldo() {
        conta.depositar(100.0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            conta.sacar(100.01);
        });
    }

    @Test
    public void deveLancarExcecaoParaDepositoNegativo() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            conta.depositar(-50.0);
        });
    }

    @Test
    public void devePermitirZerarOSaldoNoSaque() {
        conta.depositar(250.0);
        conta.sacar(250.0);
        Assertions.assertEquals(0.0, conta.getSaldo());
    }
}