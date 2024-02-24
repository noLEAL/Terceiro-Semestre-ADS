<%-- 
    Document   : formularioClubes
    Created on : 28 de jun. de 2023, 15:45:10
    Author     : SAMSUNG
--%>

<%@page import="br.edu.ifrs.modelo.Clubes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CBF</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h1>Cadastro de Clube</h1>
        <hr>
        
        <%
            String a = request.getParameter("acao");
            Clubes x = new Clubes();
            if (a.equals("Editar")) {
                x.setId(Integer.parseInt(request.getParameter("id")));
                x.selecionarId();
            }
        %>
        
        <form action="Processamento" method="post">
            <label for="id">Identificador: </label>
            <input type="number" name="id" id="id" value="<%= x.getId()%>" readonly="readonly" size="5"><br>

            <label for="sigla">Sigla: </label>
            <input type="text" name="sigla" id="sigla"  value="<%= x.getSigla()%>" size="10" maxlength="3"><br>

            <label for="nome">Nome: </label>
            <input type="text" name="nome" id="nome"  value="<%= x.getNome()%>" size="30"><br>

            <input type="submit" name="acao" value="<%= a%>">
            <input type="reset" value="Limpar">
        </form>
    </body>
</html>