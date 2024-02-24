<%-- 
    Document   : processamento
    Created on : 18 de dez. de 2023, 21:43:02
    Author     : mauri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script language="javascript" src="Scripts.js"></script>
    </head>
    <%
    String acao = request.getParameter("acao");
    %>
    <body onload="salvar(<%= request.getParameter("cpf")%>, '<%= request.getParameter("nome")%>', '<%= request.getParameter("data_nascimento")%>', <%= request.getParameter("email")%>, <%= request.getParameter("telefone")%>, <%= request.getParameter("whats")%>, <%= request.getParameter("username")%>, <%= request.getParameter("senha")%>, '<%= acao%>');">
        <h1>Cadastro de Camisas</h1>
        <hr>
        <p id="msg"></p>
        <a href="listaUsuarios.jsp">Voltar para Lista de Camisas</a>
    </body>
</html>
