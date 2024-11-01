<%-- 
    Document   : listagem
    Created on : 1 de nov. de 2024, 14:29:21
    Author     : nicho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaAtor?acao=preparar"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Atores Cadastrados</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
    </head>

    <body class="ListagemAtor">
        <h1>Atores Cadastrados</h1>

        <table>
            <thead> 
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>Sobrenome</th>
                    <th>Data de Estreia</th>
                </tr>
            </thead>
                <tbody>
                    <jsp:useBean
                        id="servicos"
                        scope="page"
                        class="locacaoDVDs.services.AtorServices"/>

                    <c:forEach items="${servicos.todos}" var="ator">
                        <tr>
                            <td>${ator.id}</td>
                            <td>${ator.nome}</td>
                            <td>${ator.sobrenome}</td>
                            <td>${ator.dataEstreia} </td>
                            <td>
                                <a href="${cp}/${prefixo}Alteracao&id=${ator.id}">
                                    Alterar
                                </a>
                            </td>
                            <td>
                                <a href="${cp}/${prefixo}Exclusao&id=${ator.id}">
                                    Excluir
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

        </table>
    <p>
        <a href="${cp}/formularios/Atores/novo.jsp">
            Novo Ator
        </a>
    </p>

    <p><a href="${cp}/index.jsp">Tela Principal</a></p>

    </body>

</html>