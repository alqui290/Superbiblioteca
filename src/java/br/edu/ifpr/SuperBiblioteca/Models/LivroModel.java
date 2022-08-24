/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Models;

import br.edu.ifpr.SuperBiblioteca.DAOs.LivroDAO;
import br.edu.ifpr.SuperBiblioteca.Entities.Livros;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alquimista290
 */
public class LivroModel {
    
    LivroDAO dao = new LivroDAO();
    
    public void adcionar(Livros u) throws SQLException{
        dao.adcionar(u);
    }
    
    public ArrayList listar() throws SQLException{
        
        return dao.exibir(); 
    }
    
    public void deletar(int id) throws SQLException{
        dao.deletar(id);
    }
    
}
