/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Controlers;

import br.edu.ifpr.SuperBiblioteca.Models.LivroModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alquimista290
 */
public class ListarLivro extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession sessao = request.getSession(false);
            LivroModel model = new LivroModel();

            request.setAttribute("livro", model.listar());
            
            if(sessao != null && sessao.getAttribute("autenticado") != null
                    && (boolean)sessao.getAttribute("autenticado") == true) {
                
                
                request.getRequestDispatcher("WEB-INF/catalogo.jsp").
                forward(request, response);
                         
                
            }
            else {           
                response.sendRedirect("Publico");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarLivro.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
