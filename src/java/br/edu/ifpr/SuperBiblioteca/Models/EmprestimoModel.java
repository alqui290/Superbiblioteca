/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Models;

import br.edu.ifpr.SuperBiblioteca.DAOs.EmpDAO;
import br.edu.ifpr.SuperBiblioteca.Entities.Emprestimo;
import java.sql.SQLException;

/**
 *
 * @author alquimista290
 */
public class EmprestimoModel {
    
    EmpDAO dao = new EmpDAO();
    
    public void registrar(Emprestimo e) throws SQLException{
        dao.registrar(e);
    }
}
