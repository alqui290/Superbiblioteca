/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Entities;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author alquimista290
 */
public class Emprestimo {
    private int id;
    private int idlivro;
    private int iduser;
    private Date datain;
    private Date dataoff;
    private Date datafim;
    private String nomel;
    private String nomeu;

    public Emprestimo(int idlivro, int iduser) {
        this.idlivro = idlivro;
        this.iduser = iduser;
    }

    public Emprestimo(int id, String nomel, String nomeu, Date datain, Date dataoff, Date datafim) {
        this.id = id;
        this.nomel = nomel;
        this.nomeu = nomeu;
        this.datain = datain;
        this.dataoff = dataoff;
        this.datafim = datafim;
    }

    

    
    
    public int getId() {
        return id;
    }

    public int getIdlivro() {
        return idlivro;
    }

    public int getIduser() {
        return iduser;
    }

    public Date getDatain() {
        return datain;
    }

    public Date getDataoff() {
        return dataoff;
    }

    public Date getDatafim() {
        return datafim;
    }

    public String getNomel() {
        return nomel;
    }

    public String getNomeu() {
        return nomeu;
    }

    
}
