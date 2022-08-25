/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Controlers;

import br.edu.ifpr.SuperBiblioteca.Models.EmprestimoModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Devolver", urlPatterns = {"/Devolver"})

public class Devolver extends HttpServlet {


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
        HttpSession sessao = request.getSession(false);
        
        
            
        if(sessao != null && sessao.getAttribute("autenticado") != null
            && (boolean)sessao.getAttribute("autenticado") == true) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if("biblio".equals(cookie.getName()) || "adm".equals(cookie.getName())){
                    if("true".equals(cookie.getValue())){
                        request.getRequestDispatcher("WEB-INF/devolver.jsp").
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idlivro = Integer.parseInt(request.getParameter("livro"));
        EmprestimoModel model = new EmprestimoModel();
        
        try {
            if(model.testar(idlivro)){
                model.devolver(idlivro);
                
                response.sendRedirect("Menu");
            }
            else{
                request.setAttribute("teste", true);
                request.setAttribute("msg", "Livro não esta emprestado!");
                
                request.getRequestDispatcher("WEB-INF/devolver.jsp").
                                forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Devolver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
