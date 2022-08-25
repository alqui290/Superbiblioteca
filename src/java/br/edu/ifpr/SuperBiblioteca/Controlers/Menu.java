/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Controlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Menu", urlPatterns = {"/", "/Menu"})

public class Menu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession(false);
        if(sessao != null && sessao.getAttribute("autenticado") != null
                && (boolean)sessao.getAttribute("autenticado") == true) {
            request.getRequestDispatcher("WEB-INF/menu.jsp").
                forward(request, response);
        }
        else {
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for (Cookie cookie : cookies) {
                    if("manterLogado".equals(cookie.getName())){
                        sessao = request.getSession(true);
                        sessao.setAttribute("autenticado", true);
                        request.getRequestDispatcher("WEB-INF/menu.jsp").
                            forward(request, response);
                        break;
                    }
                }
            }
                        
            response.sendRedirect("Publico");
        }
    }
}
