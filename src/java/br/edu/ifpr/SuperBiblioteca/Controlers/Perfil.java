/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Controlers;

import br.edu.ifpr.SuperBiblioteca.Models.UsuarioModel;
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
public class Perfil extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioModel model = new UsuarioModel();
            
            
            HttpSession sessao = request.getSession(false);
            
            if(sessao != null && sessao.getAttribute("autenticado") != null
                && (boolean)sessao.getAttribute("autenticado") == true) {
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies) {
                    if("identidade".equals(cookie.getName())){
                        try {
                            request.setAttribute("usuario", model.getUsuario(Integer.parseInt(cookie.getValue())));
                            request.getRequestDispatcher("WEB-INF/perfil.jsp").
                            forward(request, response);
                            break;
                        } catch (SQLException ex) {
                            Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
                        }
                            

                        
                    }
                }
                response.sendRedirect("Menu");
            }
            else {           
                response.sendRedirect("Publico");
            }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
