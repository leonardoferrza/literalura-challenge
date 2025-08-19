package com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    private Autor autor;

    private String idioma;
    private Double numeroDownloads;

    public Livro() {}

    public Livro(com.alura.literalura.dto.DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        this.idioma = dadosLivro.idiomas().get(0); // Pega apenas o primeiro idioma
        this.numeroDownloads = dadosLivro.numeroDownloads();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }
    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    public Double getNumeroDownloads() { return numeroDownloads; }
    public void setNumeroDownloads(Double numeroDownloads) { this.numeroDownloads = numeroDownloads; }

    @Override
    public String toString() {
        return  "----------- LIVRO -----------\n" +
                " Título: " + titulo + "\n" +
                " Autor: " + (autor != null ? autor.getNome() : "Desconhecido") + "\n" +
                " Idioma: " + idioma + "\n" +
                " Downloads: " + numeroDownloads + "\n" +
                "---------------------------\n";
    }
}