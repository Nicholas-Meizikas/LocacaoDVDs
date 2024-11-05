<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaEstados?acao=preparar"/>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <style>
            body{
                background-color: #484759 ; 
                text-align: center;
                font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
                font-size: 25px;
                font-weight: bold;
            }

            body a{
                color: #e4e7ed;
                border: 1px solid black;
                border-radius: 25%;
                text-decoration: none ;
            }
            
            body a:hover{
                text-decoration: underline ;
            }
            
            input{
                background-color:#99ff9d;
            }
        </style>
    </head>
    <body>
        <a href="${cp}/formularios/DVDs/listagem.jsp">Listagem de DVDs</a><br/>
        <a href="${cp}/formularios/Atores/listagem.jsp">Listagem de Atores</a><br/>
        <a href="${cp}/formularios/classificacaoEtaria/listagem.jsp">Listagem de Classificações</a><br/>
        <a href="${cp}/formularios/Genero/listagem.jsp">Listagem de Generos</a>
    </body>
</html>
