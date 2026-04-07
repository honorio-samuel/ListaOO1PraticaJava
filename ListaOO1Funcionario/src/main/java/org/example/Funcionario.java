package org.example;

public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        if (salario < 0) {
            throw new IllegalArgumentException("Salário não pode ser negativo");
        }
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void aplicarReajuste(double porcentagem) {
        if (porcentagem < 0) {
            throw new IllegalArgumentException("A porcentagem de reajuste deve ser positiva");
        }
        this.salario += (this.salario * (porcentagem / 100));
    }

    public double calcularSalarioAnual() {
        return this.salario * 12;
    }
}
