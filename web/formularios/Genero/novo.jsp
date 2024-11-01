<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Novo Genero</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
    </head>

    <body class="NovoGenero">

        <h1>Novo Genero</h1>

            <form method="post" action="${cp}/processaGenero">

                <input name="acao" type="hidden" value="inserir"/>

            <table>
                <tr>
                    <td>Desccricao:</td>
                    <td>
                    <input name="descricao" type="text" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${cp}/formularios/Genero/listagem.jsp">
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