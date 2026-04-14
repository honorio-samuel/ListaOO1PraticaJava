package org.example;

public class Livro {
    //titulo, autor, ano_publicacao, numero_paginas, genero
    private String titulo;
    private String autor;
    private int ano_publicacao;
    private int numero_paginas;
    private String genero;
    private boolean aberto = false;
    private int paginaAtual = 0;

    public Livro(String titulo, String autor, int numero_paginas) {
        this.titulo = titulo;
        this.autor = autor;
        setNumero_paginas(numero_paginas);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(int ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public int getNumero_paginas() {
        return numero_paginas;
    }

    public void setNumero_paginas(int numero_paginas) {
        if (numero_paginas <= 0){
            throw new IllegalArgumentException("Numero de paginas deve ser pelo menos 1");
        }
        this.numero_paginas = numero_paginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public void abrir() {
        this.aberto = true;
        System.out.println("O livro foi aberto.");
    }

    public void fechar() {
        this.aberto = false;
        System.out.println("O livro foi fechado.");
    }

    public void marcar_pagina(int pagina) {
        if (pagina >= 0 && pagina <= this.numero_paginas) {
            this.paginaAtual = pagina;
        } else {
            throw new IllegalArgumentException("Página inválida.");
        }
    }

    public void avancar_pagina() {
        if (this.aberto && this.paginaAtual < this.numero_paginas) {
            this.paginaAtual++;
        }
    }

    public void retroceder_pagina() {
        // Retrocede se estiver aberto e não for a primeira página [cite: 21]
        if (this.aberto && this.paginaAtual > 0) {
            this.paginaAtual--;
        }
    }
}
