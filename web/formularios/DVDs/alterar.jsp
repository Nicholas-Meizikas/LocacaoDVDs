<%-- 
    Document   : alterar
    Created on : 1 de nov. de 2024, 15:06:44
    Author     : nicho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Alterar DVD</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
        
    </head>

    <body>

    <h1>Alterar DVD</h1>

        <form method="post" action="${cp}/processaDVD">

            <input name="acao" type="hidden" value="alterar"/>
            <input name="id" type="hidden" value="${requestScope.DVD.id}"/>
            
            <table>
                <tr>
                    <td>Titulo:</td>
                    <td>
                        <input name="titulo" type="text" value="${requestScope.DVD.titulo}" required/>
                    </td>
                </tr>
                <tr>
                    <td>Ano de lançamento:</td>
                    <td> 
                        <input name="anoLancamento" type="number" value="${requestScope.DVD.anoLancamento}" required/>
                    </td>
                </tr>
                <tr>
                    <td>Data do lançamento:</td>
                    <td>
                        <input name="dataLancamento" type="date"
                               placeholder="dd/mm/yyyy" value="${requestScope.DVD.dataLancamento}" required/>
                    </td>
                </tr>
                <tr>
                    <td>Duração em minutos:</td>
                    <td>
                        <input name="duracao" type="number" value="${requestScope.DVD.duracaoMinutos}" required/>
                    </td>
                </tr>
                <tr>
                    <td>Ator Principal:</td>
                    <td>
                        <jsp:useBean id="atorServicos" scope="page"
                                     class="locacaoDVDs.services.AtorServices"/>
                        
                        <select name="idAtorPrincipal" required>
                            <c:forEach items="${atorServicos.todos}" var="ator">
                                <c:choose>
                                    <c:when test="${requestScope.DVD.atorPrincipal.id eq ator.id}">
                                        <option value="${ator.id}" selected>
                                            ${ator.nome} ${ator.sobrenome}
                                        </option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${ator.id}">
                                            ${ator.nome} ${ator.sobrenome}
                                        </option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Ator Coadjuvante:</td>
                    <td>
                        <select name="idAtorCoadjuvante" required>
                            <c:forEach items="${atorServicos.todos}" var="ator">
                                <c:choose>
                                    <c:when test="${requestScope.DVD.atorCoadjuvante.id eq ator.id}">
                                        <option value="${ator.id}" selected>
                                            ${ator.nome} ${ator.sobrenome}
                                        </option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${ator.id}">
                                            ${ator.nome} ${ator.sobrenome}
                                        </option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Genero:</td>
                    <td>
                        <jsp:useBean id="generoServicos" scope="page"
                                     class="locacaoDVDs.services.GeneroServices"/>
                        
                        <select name="idgenero" required>
                            <c:forEach items="${generoServicos.todos}" var="genero">
                                <c:choose>
                                    <c:when test="${requestScope.DVD.genero.id eq genero.id}">
                                        <option value="${genero.id}" selected>
                                            ${genero.descricao}
                                        </option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${genero.id}">
                                            ${genero.descricao}
                                        </option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Classificação etária:</td>
                    <td>
                        <jsp:useBean id="CEServicos" scope="page"
                                     class="locacaoDVDs.services.ClassificacaoEtariaServices"/>
                        
                        <select name="idCE" required>
                            <c:forEach items="${CEServicos.todos}" var="CE">
                                <c:choose>
                                    <c:when test="${requestScope.DVD.etaria.id eq CE.id}">
                                        <option value="${CE.id}" selected>
                                            ${CE.descricao}
                                        </option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${CE.id}">
                                            ${CE.descricao}
                                        </option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <br/>
                        <a href="${cp}/formularios/DVDs/listagem.jsp">
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