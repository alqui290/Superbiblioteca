<%-- 
    Document   : registrolivro
    Created on : 14 de ago de 2022, 17:41:07
    Author     : alquimista290
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar novos livros</title>
    </head>
    <body>
        <form method="post" action="CadastrarLivro">
            Titulo:<input name="titulo" type="text" required>
            Autor:<input name="nomeautor" type="text" required>
            Genero:<input name="genero" type="text" required>
            Editora:<input name="editora" type="text" required>
            Ano de publicação:<input name="ano" type="number" max="2020" required>
            <button type="submit">Enviar</button>
        </form>
    </body>
</html>
