<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Nova Classificação Etária</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
    </head>

    <body>

        <h1>Nova Classificação Etária</h1>

            <form method="post" action="${cp}/processaCE">

                <input name="acao" type="hidden" value="inserir"/>

            <table>
                <tr>
                    <td>Descricao:</td>
                    <td>
                    <input name="descricao" type="text" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${cp}/formularios/classificacaoEtaria/listagem.jsp">
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