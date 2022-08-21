<%-- 
    Document   : Cadastro bem sucedido
    Created on : 21 de ago de 2022, 16:51:06
    Author     : alquimista290
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sucesso!</title>
    </head>
    <body>
        O cadastro do ${tipo}: ${nome} foi um sucesso!<br>
        Deseja realizar um novo cadastro?<br>
        <a href="${tipo2}"><button>Sim</button></a><a href="Menu"><button>Não</button></a>
        
    </body>
</html>
