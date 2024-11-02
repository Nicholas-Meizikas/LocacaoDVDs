<%-- 
    Document   : novo
    Created on : 1 de nov. de 2024, 14:29:28
    Author     : nicho
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Novo(a) Ator(a)</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
    </head>

    <body>

        <h1>Novo(a) Ator(a)</h1>

            <form method="post" action="${cp}/processaAtor">

                <input name="acao" type="hidden" value="inserir"/>

            <table>
                <tr>
                    <td>Nome:</td>
                    <td>
                    <input name="nome" type="text" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Sobrenome:
                    </td>
                    <td>
                        <input name="sobrenome" type="text" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Data de Estreia:
                    </td>
                    <td>
                        <input name="data" type="date" placeholder="dd/mm/yyyy" 
                               required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${cp}/formularios/Atores/listagem.jsp">
                            Voltar
                        </a>
                    </td>
                    <td>
                        <input type="submit" value="Salvar"/>
                    </td>
                </tr>
            </table>
        </form>

    </body>

</html>