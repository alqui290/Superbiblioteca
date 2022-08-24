/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Models;

import br.edu.ifpr.SuperBiblioteca.DAOs.EmpDAO;
import br.edu.ifpr.SuperBiblioteca.Entities.Emprestimo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alquimista290
 */
public class EmprestimoModel {
    
    EmpDAO dao = new EmpDAO();
    
    public void registrar(Emprestimo e) throws SQLException{
        dao.registrar(e);
    }
    
    public Boolean testar(int id) throws SQLException{
        return dao.testar(id);
    }
    
    public Boolean testaru(int id) throws SQLException{
        return dao.testaru(id);
    }
    
    public ArrayList listar() throws SQLException{
        return dao.listar();
    }
    
    public Boolean Autenticar(int id, String senha) throws SQLException{
        return dao.logar(id, senha);
    }
    
    public void devolver(int id) throws SQLException{
        dao.devolver(id);
    }
}
