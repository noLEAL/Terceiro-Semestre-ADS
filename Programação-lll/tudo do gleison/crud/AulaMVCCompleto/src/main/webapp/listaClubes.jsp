<%-- 
    Document   : listaClubes
    Created on : 28 de jun. de 2023, 15:34:58
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
        <h1>Cadastro de Clubes</h1>
        <hr>

        <a href="formularioClubes.jsp?acao=Inserir">Inserir</a><br><br>
        <table border="1">
            <tr>
                <th colspan="2">Operação</th>
                <th>ID</th>
                <th>Sigla</th>
                <th>Nome</th>
            </tr>
            
            <%
                Clubes x = new Clubes();
                Clubes lista[] = x.selecionar();
                for (int i=0; i<lista.length; i++) {
            %>
            <tr>
                <td>
                    <a href="formularioClubes.jsp?acao=Editar&id=<%= lista[i].getId()%>">Editar</a>
                </td>
                <td>
                    <a href="Processamento?acao=Apagar&id=<%= lista[i].getId()%>">Apagar</a>
                </td>
                <td><%= lista[i].getId()%></td>
                <td><%= lista[i].getSigla()%></td>
                <td><%= lista[i].getNome()%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
