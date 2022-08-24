/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Controlers;

import br.edu.ifpr.SuperBiblioteca.Models.LivroModel;
import br.edu.ifpr.SuperBiblioteca.Models.UsuarioModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alquimista290
 */
public class RemoverLivro extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LivroModel model = new LivroModel();
        int id = Integer.parseInt(request.getParameter("indice"));
        
        try {
            model.deletar(id);
            response.sendRedirect("ListarLivro");
        } catch (SQLException ex) {
            Logger.getLogger(RemoverLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}