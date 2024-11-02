<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaCE?acao=preparar"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Classificação Etária Cadastradas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
    </head>

    <body>
        <h1>Classificações Etárias Cadastradas</h1>

        <table>
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
                        class="locacaoDVDs.services.ClassificacaoEtariaServices"/>

                    <c:forEach items="${servicos.todos}" var="etaria">
                        <tr>
                            <td>${etaria.id}</td>
                            <td>${etaria.descricao}</td>
                            
                            <td>
                                <a href="${cp}/${prefixo}Alteracao&id=${etaria.id}">
                                    Alterar
                                </a>
                            </td>
                            <td>
                                <a href="${cp}/${prefixo}Exclusao&id=${etaria.id}">
                                    Excluir
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

        </table>
    <p>
        <a href="${cp}/formularios/classificacaoEtaria/novo.jsp">
            Nova Classificação Etária
        </a>
    </p>

    <p><a href="${cp}/index.jsp">Tela Principal</a></p>

    </body>

</html>