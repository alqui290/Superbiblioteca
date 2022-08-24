/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Controlers;

import java.io.IOException;
import java.io.PrintWriter;
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
public class Sair extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();

        sessao.invalidate();

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if ("manterLogado".equals(cookie.getName()) || "adm".equals(cookie.getName()) || "biblio".equals(cookie.getName()) || "identidade".equals(cookie.getName())) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

        response.sendRedirect("Publico");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
