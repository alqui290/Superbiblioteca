<%-- 
    Document   : cadastro
    Created on : 14 de ago de 2022, 17:40:51
    Author     : alquimista290
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar novo usuario</title>
    </head>
    <body>
        <form method="post" action="CadastrarUsuarios">
            Nome:<input type="text" name="nome" required>
            Email:<input type="email" name="email" required>
            Nome de Usuario:<input type="text" name="username" required>
            Senha:<input type="password" name="senha" required>
            Idade:<input type="number" name="idade" min=16 required>
            <input type="submit">
        </form>
    </body>
</html>
