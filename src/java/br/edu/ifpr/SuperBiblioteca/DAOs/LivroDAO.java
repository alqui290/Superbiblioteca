/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.DAOs;

import br.edu.ifpr.SuperBiblioteca.Entities.Livros;
import br.edu.ifpr.SuperBiblioteca.Factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alquimista290
 */
public class LivroDAO {
    
        
    public void adcionar(Livros u) throws SQLException{
        String sql = "INSERT INTO LIVROS (TITULO, AUTOR, EDITORA, GENERO, ANOPUBLI) VALUES (?,?,?,?,?)";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, u.getTitulo());
        stmt.setString(2, u.getAutor());
        stmt.setString(3, u.getEditora());
        stmt.setString(4, u.getGenero());
        stmt.setInt(5, u.getAnopubli());
        
        stmt.execute();
        
        stmt.close();
        connection.close();
    }
    
    public ArrayList exibir() throws SQLException{
        ArrayList<Livros> livro = new ArrayList();
        String sql = "SELECT ID, TITULO, AUTOR, EDITORA, GENERO, ANOPUBLI FROM LIVROS";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Livros l;
            l = new Livros(rs.getInt("ID"), rs.getString("TITULO"), rs.getString("AUTOR"), rs.getInt("ANOPUBLI"), rs.getString("EDITORA"), rs.getString("GENERO"));
            livro.add(l);
        }
        
        connection.close();
        
        return livro;
    }
    
    public void deletar(int id) throws SQLException{
        String sql = "DELETE FROM LIVROS WHERE ID=?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        
        stmt.execute();
        
        stmt.close();
        
        connection.close();
    }
}
