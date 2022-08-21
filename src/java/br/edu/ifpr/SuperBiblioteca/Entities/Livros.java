/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Entities;

/**
 *
 * @author alquimista290
 */
public class Livros {
    private int id;
    private String titulo;
    private String autor;
    private int anopubli;
    private String editora;
    private String genero;

    public Livros(int id, String titulo, String autor, int anopubli, String editora, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anopubli = anopubli;
        this.editora = editora;
        this.genero = genero;
    }
    
    public Livros(String titulo, String autor, int anopubli, String editora, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.anopubli = anopubli;
        this.editora = editora;
        this.genero = genero;
    }

    
    
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnopubli() {
        return anopubli;
    }

    public String getEditora() {
        return editora;
    }

    public String getGenero() {
        return genero;
    }
}
