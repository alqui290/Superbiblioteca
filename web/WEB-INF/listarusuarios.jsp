<%-- 
    Document   : listarusuarios
    Created on : 14 de ago de 2022, 17:41:40
    Author     : alquimista290
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista usuarios</title>
    </head>
    <body>
        <table>
            <tr>
                <td>ID</td>
                <td>Nome</td>
                <td>Username</td>
                <td>Email</td>
                <td>idade</td>
            </tr>
            <c:forEach var="usuarios" items="${usuario}">
                <tr>
                    <td>${usuarios.id}</td>
                    <td>${usuarios.nome}</td>
                    <td>${usuarios.username}</td>
                    <td>${usuarios.email}</td>
                    <td>${usuarios.idade}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="Menu"><button>Voltar</button></a>
    </body>
</html>
