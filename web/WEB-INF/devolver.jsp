<%-- 
    Document   : devolver
    Created on : 23 de ago de 2022, 18:59:48
    Author     : alquimista290
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Devolver Livro</title>
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
        <form method="post" action="Devolver">
            ID do livro:<input name="livro" type="number" required>
            <input type="submit" value="Enviar">
        </form>
        <a href="Menu"><button>Cancelar</button></a>
    </body>
</html>
