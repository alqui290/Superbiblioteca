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
    private Calendar datain;
    private Calendar dataoff;
    private Calendar datafim;

    public Emprestimo(int idlivro, int iduser) {
        this.idlivro = idlivro;
        this.iduser = iduser;
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

    public Calendar getDatain() {
        return datain;
    }

    public Calendar getDataoff() {
        return dataoff;
    }

    public Calendar getDatafim() {
        return datafim;
    }

    
}
