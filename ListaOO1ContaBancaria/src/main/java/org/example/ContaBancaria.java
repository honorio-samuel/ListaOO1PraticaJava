package org.example;

public class ContaBancaria {
    private String titular;
    private String numero_conta;
    private double saldo;

    public ContaBancaria(String titular, String numero_conta) {
        this.titular = titular;
        this.numero_conta = numero_conta;
        this.saldo = 0.0; // Começa zerada
    }

    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumero_conta() {
        return numero_conta;
    }
    public void setNumero_conta(String numero_conta) {
        this.numero_conta = numero_conta;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor > this.saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo");
        }
        this.saldo -= valor;
    }
}
