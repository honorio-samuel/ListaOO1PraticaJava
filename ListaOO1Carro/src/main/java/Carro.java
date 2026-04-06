public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private int velocidadeAtual;
    private String estado = "Desligado";

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano <= 1886) {
            throw new IllegalArgumentException("Ano deve ser posterior a 1886");
        }
        this.ano = ano;
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(int velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void acelerar(int quantidade) {
        if (quantidade<0){
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        this.velocidadeAtual = this.velocidadeAtual + quantidade;
        if (velocidadeAtual < 0) {
            throw new IllegalArgumentException("Velocidade atual deve ser maior igual a zero");
        }
    }

    public void freiar(int quantidade) {
        if (quantidade<0){
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        this.velocidadeAtual = this.velocidadeAtual - quantidade;
        if (velocidadeAtual < 0) {
            this.velocidadeAtual = 0;
        }
    }

    public void ligar(){
        this.estado = "Ligado";
    }

    public void desligar(){
        this.estado = "Desligado";
        this.velocidadeAtual = 0;
    }
}

