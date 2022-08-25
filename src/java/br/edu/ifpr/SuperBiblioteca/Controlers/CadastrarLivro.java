/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Controlers;

import br.edu.ifpr.SuperBiblioteca.Entities.Livros;
import br.edu.ifpr.SuperBiblioteca.Models.LivroModel;
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

@WebServlet(name = "CadastrarLivro", urlPatterns = {"/CadastrarLivro"})
public class CadastrarLivro extends HttpServlet {

    
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
                        request.getRequestDispatcher("WEB-INF/registrolivro.jsp").
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
        try {
            String titulo, nomeautor, genero, editora;
            int ano;
            titulo = request.getParameter("titulo");
            nomeautor = request.getParameter("nomeautor");
            genero = request.getParameter("genero");
            editora = request.getParameter("editora");
            ano = Integer.parseInt(request.getParameter("ano"));

            LivroModel model = new LivroModel();
        
            model.adcionar(new Livros(titulo, nomeautor, ano, editora, genero));
            
            request.setAttribute("tipo", "livro");
            request.setAttribute("tipo2", "CadastrarLivro");
            request.setAttribute("nome", titulo);
            
            request.getRequestDispatcher("WEB-INF/sucesso.jsp").
                    forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
