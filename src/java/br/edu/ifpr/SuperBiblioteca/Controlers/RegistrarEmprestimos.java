/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Controlers;

import br.edu.ifpr.SuperBiblioteca.Entities.Emprestimo;
import br.edu.ifpr.SuperBiblioteca.Models.EmprestimoModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alquimista290
 */
public class RegistrarEmprestimos extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession(false);
        if(sessao != null && sessao.getAttribute("autenticado") != null
                && (boolean)sessao.getAttribute("autenticado") == true) {
            request.getRequestDispatcher("WEB-INF/cadastraremp.jsp").
                forward(request, response);
        }
        else {           
            response.sendRedirect("Publico");
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idl, idu;
            
            idl = Integer.parseInt(request.getParameter("livroid"));
            idu = Integer.parseInt(request.getParameter("userid"));
            
            EmprestimoModel model = new EmprestimoModel();
            model.registrar(new Emprestimo(idl, idu));
            
            response.sendRedirect("Menu");
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarEmprestimos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
