<%-- 
    Document   : menu
    Created on : 14 de ago de 2022, 17:41:49
    Author     : alquimista290
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"
          prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <div><a href=""><button>Perfil de usuario</button></a></div>
        <div><a href="ListarLivro"><button>Catalogo</button></a></div>
        <div><a><button>Seus Emprestimos</button></a></div>
        <div><a><button>Fazer reserva</button></a></div>
        <c:if test="${biblio || adm}">
        <div><a href="CadastrarUsuarios"><button>Cadastrar usuario</button></a></div>
        <div><a href="CadastrarLivro"><button>Cadastrar livro</button></a></div>
        <div><a><button>Listar todos emprestimos</button></a></div>
        <c:if test="${adm}">
        <div><a><button>Listar usuarios</button></a></div> 
        </c:if>
        <div><a><button>Realizar emprestimos</button></a></div>
        </c:if>
        <div><a><button>Sair</button></a></div>
    </body>
</html>
