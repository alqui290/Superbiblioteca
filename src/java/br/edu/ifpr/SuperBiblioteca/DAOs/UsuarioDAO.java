/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.DAOs;

import br.edu.ifpr.SuperBiblioteca.Entities.Usuarios;
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
public class UsuarioDAO {
    public void cadastrar(Usuarios u) throws SQLException{
        String sql = "INSERT INTO USUARIOS(NOME, EMAIL, USERNAME, IDADE, SENHA, ADM, BIBLIO) VALUES(?,?,?,?,?,false,false)";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getEmail());
        stmt.setString(3, u.getUsername());
        stmt.setInt(4, u.getIdade());
        stmt.setString(5, u.getSenha());
        
        stmt.execute();
        
        stmt.close();
        connection.close();
    }
    
    public void alterar(Usuarios u) throws SQLException{
        String sql = "UPDATE USUARIOS SET NOME=?, EMAIL=?,USERNAME=?, IDADE=?, SENHA=? WHERE ID=?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getEmail());
        stmt.setString(3, u.getUsername());
        stmt.setInt(4, u.getIdade());
        stmt.setString(5, u.getSenha());
        stmt.setInt(6, u.getId());
        
        stmt.execute();
        
        stmt.close();
        connection.close();
    }
    
    public ArrayList exibir() throws SQLException{
        ArrayList<Usuarios> usuario = new ArrayList();
        String sql = "SELECT ID, NOME, CURSO, EMAIL, IDADE, SENHA FROM USUARIOS";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Usuarios u = new Usuarios(rs.getString("NOME"), rs.getString("USERNAME"), rs.getString("EMAIL"), rs.getString("SENHA"), rs.getInt("IDADE"), rs.getInt("ID"));
            usuario.add(u);
        }
        
        connection.close();
        
        return usuario;
    }
    
    public Usuarios logar(Usuarios u) throws SQLException{
        String sql = "SELECT ID, ADM, BIBLIO FROM USUARIOS WHERE USERNAME=? AND SENHA=?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, u.getUsername());
        stmt.setString(2, u.getSenha());
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            Usuarios ul = new Usuarios(rs.getInt("ID"), rs.getBoolean("ADM"), rs.getBoolean("BIBLIO"));
            return ul;
        }
        
        connection.close();
        
        return null;
    }
}
