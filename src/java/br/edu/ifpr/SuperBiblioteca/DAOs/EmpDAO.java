/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.DAOs;

import br.edu.ifpr.SuperBiblioteca.Entities.Emprestimo;
import br.edu.ifpr.SuperBiblioteca.Factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author alquimista290
 */
public class EmpDAO {
    
    
    public void registrar(Emprestimo e) throws SQLException{
        Calendar c = Calendar.getInstance();
        String sql = "INSERT INTO EMPRESTIMOS (USUARIOS_ID, LIVROS_ID, DATAIN, DATAOFF) VALUES (?,?,?,?)";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, e.getIduser());
        stmt.setInt(2, e.getIduser());
        stmt.setDate(3, new Date(c.getTimeInMillis()));
        c.add(Calendar.DATE, 15);
        stmt.setDate(4, new Date(c.getTimeInMillis()));
        
        
        stmt.execute();
        
        stmt.close();
        connection.close();
        
    }
}
