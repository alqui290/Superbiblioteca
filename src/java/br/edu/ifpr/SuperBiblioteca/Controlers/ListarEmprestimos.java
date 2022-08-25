/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Controlers;

import br.edu.ifpr.SuperBiblioteca.Models.EmprestimoModel;
import java.io.IOException;
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

@WebServlet(name = "ListarEmprestimos", urlPatterns = {"/ListarEmprestimos"})

public class ListarEmprestimos extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession sessao = request.getSession(false);
            EmprestimoModel model = new EmprestimoModel();
            request.setAttribute("emp", model.listar());
            
            if(sessao != null && sessao.getAttribute("autenticado") != null
                    && (boolean)sessao.getAttribute("autenticado") == true) {
                
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies) {
                    if("biblio".equals(cookie.getName()) || "adm".equals(cookie.getName())){
                        if("true".equals(cookie.getValue())){
                            request.getRequestDispatcher("WEB-INF/listartdemp.jsp").
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
            Logger.getLogger(ListarEmprestimos.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
