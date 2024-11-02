<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaEstados?acao=preparar"/>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
        <title>Home</title>
    </head>
    <body>
        <a href="${cp}/formularios/DVDs/listagem.jsp">Listagem de DVDs</a><br/>
        <a href="${cp}/formularios/Atores/listagem.jsp">Listagem de Atores</a><br/>
        <a href="${cp}/formularios/classificacaoEtaria/listagem.jsp">Listagem de Classificações</a><br/>
        <a href="${cp}/formularios/Genero/listagem.jsp">Listagem de Generos</a>
    </body>
</html>
