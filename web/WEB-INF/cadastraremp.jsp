<%-- 
    Document   : cadastraremp
    Created on : 14 de ago de 2022, 17:42:13
    Author     : alquimista290
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar um umprestimo</title>
        <c:if test="${teste}">
            <script>
                function funcao1()
                {
                    alert("${msg}");
                }
            </script>
        </c:if>
    </head>
    <body onload="funcao1()">
        <form method="post" action="RegistrarEmprestimos">
            ID de usuario:<input type="number" name="userid" value="${user}" required>
            Senha:<input type="password" name="senha" required>
            ID de livro:<input type="number" name="livroid" value="${livro}" required>
            <input value="registrar" type="submit">
            
        </form>
            <a href="Menu"><button>Cancelar</button></a>
    </body>
</html>
