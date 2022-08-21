<%-- 
    Document   : cadastraremp
    Created on : 14 de ago de 2022, 17:42:13
    Author     : alquimista290
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar um umprestimo</title>
    </head>
    <body>
        <form method="post" action="RegistrarEmprestimos">
            ID de usuario:<input type="number" name="userid" required>
            ID de livro:<input type="number" name="livroid" required>
            <input value="registrar" type="submit">
        </form>
    </body>
</html>
