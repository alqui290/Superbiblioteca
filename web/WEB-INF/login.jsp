<%-- 
    Document   : login
    Created on : 14 de ago de 2022, 18:01:29
    Author     : alquimista290
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form method="post" action="Login">
            Usename:<input type="text" name="user" required>
            Senha:<input type="password" name="senha" required>
            <label>Manter-me Logado</label>
            <input type="checkbox" name="manter" value="s"/>
            <input type="submit" value="Logar">
        </form>
    </body>
</html>
