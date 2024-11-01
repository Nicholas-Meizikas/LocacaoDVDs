<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaGenero?acao=preparar"/>
<!DOCTYPE html>

<html>
    <head>
        <title>generos Cadastrados</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
    </head>

    <body class="ListagemGenero">
        <h1>Generos Cadastrados</h1>

        <table class="tabelaListagem">
            <thead> 
                <tr>
                    <th>Id</th>
                    <th>Descricao</th>
                </tr>
            </thead>
                <tbody>
                
                    <jsp:useBean
                        id="servicos"
                        scope="page"
                        class="locacaoDVDs.services.GeneroServices"/>

                    <c:forEach items="${servicos.todos}" var="genero">
                        <tr>
                            <td>${genero.id}</td>
                            <td>${genero.descricao}</td>
                            
                            <td>
                                <a href="${cp}/${prefixo}Alteracao&id=${genero.id}">
                                    Alterar
                                </a>
                            </td>
                            <td>
                                <a href="${cp}/${prefixo}Exclusao&id=${genero.id}">
                                    Excluir
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

        </table>
    <p>
        <a href="${cp}/formularios/Genero/novo.jsp">
            Novo Genero
        </a>
    </p>

    <p><a href="${cp}/index.jsp">Tela Principal</a></p>

    </body>

</html>