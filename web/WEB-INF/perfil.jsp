<%-- 
    Document   : Perfil
    Created on : 14 de ago de 2022, 17:53:18
    Author     : alquimista290
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
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
                <tr>
                    <td>${usuario.id}</td>
                    <td>${usuario.nome}</td>
                    <td>${usuario.username}</td>
                    <td>${usuario.email}</td>
                    <td>${usuario.idade}</td>
                </tr>
        </table>
        <a href="Menu"><button>Voltar</button></a>
    </body>
</html>
