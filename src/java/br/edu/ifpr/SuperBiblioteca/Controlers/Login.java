/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Controlers;

import br.edu.ifpr.SuperBiblioteca.Entities.Usuarios;
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
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        request.getRequestDispatcher("WEB-INF/login.jsp").
                forward(request, response);
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
        
        
        try {
            String user, senha;
        
            senha = request.getParameter("senha");
            user= request.getParameter("user");

            UsuarioModel model = new UsuarioModel();
            Usuarios u = model.logar(new Usuarios(user, senha));
            
            if(u == null){
                response.sendRedirect("Login");
            }
            else{
                HttpSession sessao = request.getSession(true);
                sessao.setAttribute("autenticado", true);
                
                if("s".equals(request.getParameter("manter"))){
                    Cookie cookie = new Cookie("manterLogado", "manter");
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(cookie);
                    Cookie biblio = new Cookie("biblio", String.valueOf(u.isBiblio()));
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(biblio);
                    Cookie adm = new Cookie("adm", String.valueOf(u.isAdm()));
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(adm);
                    Cookie identidade = new Cookie("identidade", String.valueOf(u.getId()));
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(identidade);
                }
                else{
                    Cookie biblio = new Cookie("biblio", String.valueOf(u.isBiblio()));
                    response.addCookie(biblio);
                    Cookie adm = new Cookie("adm", String.valueOf(u.isAdm()));
                    response.addCookie(adm);
                    Cookie identidade = new Cookie("identidade", String.valueOf(u.getId()));
                    response.addCookie(identidade);
                }
                
                response.sendRedirect("Menu");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
