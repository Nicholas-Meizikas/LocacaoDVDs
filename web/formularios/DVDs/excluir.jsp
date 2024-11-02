<%-- 
    Document   : excluir
    Created on : 1 de nov. de 2024, 15:06:37
    Author     : nicho
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Excluir DVD</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
    </head>

    <body>

        <h1>Excluir DVD</h1>

        <form method="post" action="${cp}/processaDVD">
    
            <input name="acao" type="hidden" value="excluir"/>
            <input name="id" type="hidden" value="${requestScope.DVD.id}"/>

            <table>
                <tr>
                    <td>Titulo:</td>
                    <td>${requestScope.DVD.titulo}</td>
                </tr>
                <tr>
                    <td>Ano de Lançamento:</td>
                    <td>${requestScope.DVD.anoLancamento}</td>
                </tr>
                <tr>
                    <td>Data de Lançamento:</td>
                    <td>
                        ${requestScope.DVD.dataLancamento}
                    </td>
                </tr>
                <tr>
                    <td>Duração em Minutos:</td>
                    <td>${requestScope.DVD.duracaoMinutos}</td>
                </tr>
                <tr>
                    <td>Ator Principal:</td>
                    <td>${requestScope.DVD.atorPrincipal.nome} ${requestScope.DVD.atorPrincipal.sobrenome}</td>
                </tr>
                <tr>
                    <td>Ator Coadjuvante:</td>
                    <td>${requestScope.DVD.atorCoadjuvante.nome} ${requestScope.DVD.atorCoadjuvante.sobrenome}</td>
                </tr>
                <tr>
                    <td>Genero:</td>
                    <td>${requestScope.DVD.genero.descricao}</td>
                </tr>
                <tr>
                    <td>Classificação Etária:</td>
                    <td>${requestScope.DVD.etaria.descricao}</td>
                </tr>
                <tr>
                    <td>
                        <a href="${cp}/formularios/DVDs/listagem.jsp">
                            Voltar
                        </a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Excluir"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
