package org.example;

public class Pessoa {
    private String nome;
    private int idade;
    private double altura; // em centímetros
    private double peso;   // em quilos

    public Pessoa(String nome, int idade, double altura, double peso) {
        if(idade < 0) throw new IllegalArgumentException("Idade não pode ser negativa");
        if(altura < 0) throw new IllegalArgumentException("Altura não pode ser negativa");

        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void envelhecer() {
        this.idade++;
    }

    public void crescer(double centimetros) {
        if (centimetros < 0) {
            throw new IllegalArgumentException("Valor de crescimento deve ser positivo");
        }
        if (this.idade < 21) {
            this.altura += centimetros;
        }
    }

    public void ganhar_peso(double quilos) {
        if (quilos < 0) {
            throw new IllegalArgumentException("Valor de peso deve ser positivo");
        }
        this.peso += quilos;
    }
    public void perder_peso(double quilos) {
        if (quilos < 0) {
            throw new IllegalArgumentException("Valor de peso deve ser positivo");
        }
        this.peso -= quilos;
        if (this.peso < 0) this.peso = 0;
    }
}