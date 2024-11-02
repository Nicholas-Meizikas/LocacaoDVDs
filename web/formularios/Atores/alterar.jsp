<%-- 
    Document   : alterar
    Created on : 1 de nov. de 2024, 14:29:44
    Author     : nicho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Alterar Ator</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
    </head>

    <body>

    <h1>Alterar Ator</h1>

        <form method="post" action="${cp}/processaAtor">

            <input name="acao" type="hidden" value="alterar"/>
            <input name="id" type="hidden" value="${requestScope.Ator.id}"/>
            <table>
                <tr>
                    <td>Nome:</td>
                    <td>
                        <input name="nome" type="text"
                            value="${requestScope.Ator.nome}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Sobrenome:
                    </td>
                    <td>
                        <input name="sobrenome" type="text"
                               value="${requestScope.Ator.sobrenome}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Data de Estreia:
                    </td>
                    <td>
                        <input name="data" type="date" value="${requestScope.Ator.dataEstreia}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${cp}/formularios/Atores/listagem.jsp">
                            Voltar
                        </a>
                    </td>
                    <td>
                        <input type="submit" value="Alterar"/>
                    </td>
                </tr>
            </table>

        </form>
    </body>

</html>