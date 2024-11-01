<%-- 
    Document   : listagem
    Created on : 1 de nov. de 2024, 15:06:21
    Author     : nicho
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaDVD?acao=preparar"/>
<!DOCTYPE html>

<html>
    <head>
        <title>DVDs Cadastrados</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
    </head>

    <body class="ListagemDVDs">
        <h1>DVDs Cadastradas</h1>

        <table>
            <thead> 
                <tr>
                    <th>Id</th>
                    <th>Titulo</th>
                    <th>data de Lançamento</th>
                    <th>ano de lançamento</th>
                    <th>Duração em minutos</th>
                    <th>Genero</th>
                    <th>Classificação Etária</th>
                    <th>Ator Principal Nome</th>
                    <th>Ator Coadjuvante Nome</th>
                </tr>
            </thead>
                <tbody>
                
                    <jsp:useBean
                        id="servicos"
                        scope="page"
                        class="locacaoDVDs.services.DVDServices"/>

                    <c:forEach items="${servicos.todos}" var="DVD">
                        <tr>
                            <td>${DVD.id}</td>
                            <td>${DVD.titulo}</td>
                            <td>${DVD.dataLancamento}</td>
                            <td>${DVD.anoLancamento}</td>
                            <td>${DVD.duracaoMinutos}</td>
                            <td>${DVD.genero.descricao}</td>
                            <td>${DVD.etaria.descricao}</td>
                            <td>${DVD.atorPrincipal.nome} ${DVD.atorPrincipal.sobrenome}</td>
                            <td>${DVD.atorCoadjuvante.nome} ${DVD.atorCoadjuvante.sobrenome}</td>
                            <td>
                                <a href="${cp}/${prefixo}Alteracao&id=${DVD.id}">
                                    Alterar
                                </a>
                            </td>
                            <td>
                                <a href="${cp}/${prefixo}Exclusao&id=${DVD.id}">
                                    Excluir
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

        </table>
    <p>
        <a href="${cp}/formularios/DVDs/novo.jsp">
            Novo Ator/Atris
        </a>
    </p>

    <p><a href="${cp}/index.jsp">Tela Principal</a></p>

    </body>

</html>