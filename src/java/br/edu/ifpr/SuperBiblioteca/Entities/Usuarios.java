/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Entities;

/**
 *
 * @author alquimista290
 */
public class Usuarios {
    private String nome;
    private String username;
    private String email;
    private String senha;
    private int idade;
    private int id;
    private boolean adm;
    private boolean biblio;

    public Usuarios(int id, boolean adm, boolean biblio) {
        this.id = id;
        this.adm = adm;
        this.biblio = biblio;
    }

    public Usuarios(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }

    public Usuarios(String nome, String username, String email, String senha, int idade) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
    }

    public Usuarios(String nome, String username, String email, String senha, int idade, int id) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
        this.id = id;
    }

    

    

    

    public String getNome() {
        return nome;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }

    public int getId() {
        return id;
    }

    public boolean isAdm() {
        return adm;
    }

    public boolean isBiblio() {
        return biblio;
    }
}
