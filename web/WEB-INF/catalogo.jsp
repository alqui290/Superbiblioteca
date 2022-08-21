<%-- 
    Document   : catalogo
    Created on : 14 de ago de 2022, 17:40:32
    Author     : alquimista290
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"
          prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogo de livros</title>
    </head>
    <body>
        <table>
            <tr>
                <td>ID</td>
                <td>Titulo</td>
                <td>Autor</td>
                <td>Genero</td>
                <td>Editora</td>
                <td>Ano de publicação</td>
            </tr>
            <c:forEach varStatus="status" var="livros" items="${livro}">
                <tr>
                    <td>${livros.id}</td>
                    <td>${livros.titulo}</td>
                    <td>${livros.autor}</td>
                    <td>${livros.genero}</td>
                    <td>${livros.editora}</td>
                    <td>${livros.anopubli}</td>
                    <td><a href="RemoverLivro?indice=${livros.id}">remover</a></td>
                    <td><a href="Alterar?indice=${livros.id}">alterar</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="Menu"><button>Voltar</button></a>
    </body>
</html>
