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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        stmt.setInt(2, e.getIdlivro());
        stmt.setDate(3, new Date(c.getTimeInMillis()));
        c.add(Calendar.DATE, 15);
        stmt.setDate(4, new Date(c.getTimeInMillis()));
        
        
        stmt.execute();
        
        stmt.close();
        connection.close();
        
    }
    
    public Boolean testar(int id) throws SQLException{
        
        String sql = "SELECT * FROM EMPRESTIMOS WHERE LIVROS_ID = ? AND DATAFIM IS NULL";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            return true;
        }
        
        connection.close();
        
        return false;
        
    }
    
    public ArrayList listar() throws SQLException{
        
        ArrayList<Emprestimo> emp = new ArrayList();
        String sql = "SELECT E.ID, U.NOME, L.TITULO, E.DATAIN, E.DATAOFF, E.DATAFIM FROM EMPRESTIMOS E INNER JOIN LIVROS L ON L.ID = E.LIVROS_ID INNER JOIN USUARIOS U ON U.ID = E.USUARIOS_ID";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Emprestimo ep;
            ep = new Emprestimo(rs.getInt("ID"), rs.getString("TITULO"), rs.getString("NOME"), rs.getDate("DATAIN"), rs.getDate("DATAOFF"), rs.getDate("DATAFIM"));
            emp.add(ep);
        }
        
        connection.close();
        
        return emp;
        
    }
    
    public Boolean logar(int id, String senha) throws SQLException{
        String sql = "SELECT ID, ADM, BIBLIO FROM USUARIOS WHERE ID=? AND SENHA=?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, senha);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            return true;
        }
        
        connection.close();
        
        return false;
    }
    
    public void devolver(int id) throws SQLException{
        Calendar c = Calendar.getInstance();
        String sql = "UPDATE EMPRESTIMOS SET DATAFIM = ? WHERE LIVROS_ID = ? AND DATAFIM IS NULL";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setDate(1, new Date(c.getTimeInMillis()));
        stmt.setInt(2, id);
        
        stmt.execute();
        
        stmt.close();
        
        connection.close();
        
        verificar(id);
        
    }
    
    public void verificar(int id) throws SQLException{
        
        String sql = "SELECT ID, USUARIOS_ID, DATAFIM, DATAOFF FROM EMPRESTIMOS WHERE LIVROS_ID = ? ORDER BY ID DESC";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            if(rs.getDate("DATAFIM").after(rs.getDate("DATAOFF"))){
                punir(rs.getInt("ID"), rs.getInt("USUARIOS_ID"));
            }
        }
        
        connection.close();
        
    }
    
    public void punir(int eid, int uid) throws SQLException{
        Calendar c = Calendar.getInstance();
        String sql = "INSERT INTO PUNICAO (USUARIOS_ID, EMPRESTIMO_ID, DATAIN, DATAFIM) VALUES (?,?,?,?)";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, uid);
        stmt.setInt(2, eid);
        stmt.setDate(3, new Date(c.getTimeInMillis()));
        c.add(Calendar.DATE, 15);
        stmt.setDate(4, new Date(c.getTimeInMillis()));
        
        
        stmt.execute();
        
        stmt.close();
        connection.close();
        
    }
}
