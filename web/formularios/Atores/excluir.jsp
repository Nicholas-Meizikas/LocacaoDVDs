<%-- 
    Document   : excluir
    Created on : 1 de nov. de 2024, 14:29:35
    Author     : nicho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Excluir Ator/Atris</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
    </head>

    <body class="ExcluirAtor">

        <h1>Excluir Ator/Atris</h1>

        <form method="post" action="${cp}/processaAtor">
    
            <input name="acao" type="hidden" value="excluir"/>
            <input name="id" type="hidden" value="${requestScope.Ator.id}"/>

            <table>
                <tr>
                    <td>Nome:</td>
                    <td>${requestScope.Ator.nome}</td>
                </tr>
                <tr>
                    <td>Sobrenome:</td>
                    <td>${requestScope.Ator.sobrenome}</td>
                </tr>
                <tr>
                    <td>Data de Estreia:</td>
                    <td>${requestScope.Ator.dataEstreia}</td>
                </tr>
                <tr>
                    <td>
                        <a href="${cp}/formularios/Atores/listagem.jsp">
                            Voltar
                        </a>
                    </td>
                    <td>
                        <input type="submit" value="Excluir"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
