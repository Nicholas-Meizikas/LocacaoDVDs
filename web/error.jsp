<%-- 
    Document   : error
    Created on : 26 de out. de 2024, 13:37:42
    Author     : nicho
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
        <title>Erro</title>
    </head>
    <body>
        
        <form method="POST" action="${cp}${requestScope.erro.processa}">
            <input name="acao" type="hidden" value="erro">
            <input name="caminho" type="hidden" value="${requestScope.erro.caminho}">
            <input name="id" type="hidden" value="${requestScope.erro.id}">
            
            <h1>${requestScope.erro.mensagem}</h1>
            <input type="submit" value="Voltar">
        </form>
    </body>
</html>
