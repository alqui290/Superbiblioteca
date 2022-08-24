/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Controlers;

import br.edu.ifpr.SuperBiblioteca.Entities.Emprestimo;
import br.edu.ifpr.SuperBiblioteca.Models.EmprestimoModel;
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
public class RegistrarEmprestimos extends HttpServlet {



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
                        request.getRequestDispatcher("WEB-INF/cadastraremp.jsp").
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
            int idl, idu;
            String senha;
            
            
            idl = Integer.parseInt(request.getParameter("livroid"));
            idu = Integer.parseInt(request.getParameter("userid"));
            senha = request.getParameter("senha");
            
            EmprestimoModel model = new EmprestimoModel();
            
            if(model.testar(idl)){
                request.setAttribute("livro", idl);
                request.setAttribute("user", idu);
                request.setAttribute("teste", model.testar(idl));
                request.setAttribute("msg", "Livro já esta emprestado!");
                
                
                request.getRequestDispatcher("WEB-INF/cadastraremp.jsp").
                forward(request, response);
            }
            else if(model.Autenticar(idu, senha) && model.testaru(idu)){
                model.registrar(new Emprestimo(idl, idu));

                response.sendRedirect("Menu");
            }
            else if(!model.Autenticar(idu, senha)){
                request.setAttribute("livro", idl);
                request.setAttribute("user", idu);
                request.setAttribute("teste", !model.Autenticar(idu, senha));
                request.setAttribute("msg", "senha ou usuario incorretos!");
                request.getRequestDispatcher("WEB-INF/cadastraremp.jsp").
                forward(request, response);
            }
            else{
                request.setAttribute("livro", idl);
                request.setAttribute("user", idu);
                request.setAttribute("teste", !model.testaru(idu));
                request.setAttribute("msg", "Usuario sendo punido por atrasar um ou mais livros!");
                request.getRequestDispatcher("WEB-INF/cadastraremp.jsp").
                forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarEmprestimos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
