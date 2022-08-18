/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Models;

import br.edu.ifpr.SuperBiblioteca.DAOs.UsuarioDAO;
import br.edu.ifpr.SuperBiblioteca.Entities.Usuarios;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alquimista290
 */
public class UsuarioModel {
    UsuarioDAO dao = new UsuarioDAO();
    
    public void cadastrar(Usuarios u) throws SQLException{
        dao.cadastrar(u);
    }

    public ArrayList getUsuario() throws SQLException {
        return dao.exibir();
    }
    
    public Usuarios logar(Usuarios u) throws SQLException{
        return dao.logar(u);
    }
}
