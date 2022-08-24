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
public class ListarUser extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UsuarioModel model = new UsuarioModel();
            request.setAttribute("usuario", model.getUsuario());
            
            HttpSession sessao = request.getSession(false);
            
            if(sessao != null && sessao.getAttribute("autenticado") != null
                && (boolean)sessao.getAttribute("autenticado") == true) {
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies) {
                    if("adm".equals(cookie.getName())){
                        if("true".equals(cookie.getValue())){
                            request.getRequestDispatcher("WEB-INF/listarusuarios.jsp").
                            forward(request, response);
                            break;
                        } 
                    }
                }
                response.sendRedirect("Menu");
            }
            else {           
                response.sendRedirect("Publico");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
