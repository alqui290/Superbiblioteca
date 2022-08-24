<%-- 
    Document   : listartdemp
    Created on : 14 de ago de 2022, 17:42:55
    Author     : alquimista290
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de emprestimos</title>
    </head>
    <body>
        <table>
            <tr>
                <td>Livro</td>
                <td>Usuario</td>
                <td>Data do emprestimo</td>
                <td>Data para devolução</td>
                <td>Data em que foi devolvido</td>
            </tr>
            <c:forEach var="emps" items="${emp}">
                <tr>
                    <td>${emps.nomel}</td>
                    <td>${emps.nomeu}</td>
                    <td>${emps.datain}</td>
                    <td>${emps.dataoff}</td>
                    <td>${emps.datafim}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="Menu"><button>Voltar</button></a>
    </body>
</html>
