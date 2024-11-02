<%-- 
    Document   : alterar
    Created on : 1 de nov. de 2024, 10:23:15
    Author     : nicho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Alterar Genero</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
    </head>

    <body>

    <h1>Alterar Genero</h1>

        <form method="post" action="${cp}/processaGenero">

            <input name="acao" type="hidden" value="alterar"/>
            <input name="id" type="hidden" value="${requestScope.genero.id}"/>
            <table>
                <tr>
                    <td>descrição:</td>
                    <td>
                        <input name="descricao" type="text"
                            value="${requestScope.genero.descricao}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${cp}/formularios/Genero/listagem.jsp">
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