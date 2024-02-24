<%-- 
    Document   : processamentoCliente
    Created on : 20 de dez. de 2023, 02:19:33
    Author     : noLEAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script language="javascript" src="Scripts.js"></script>
    </head>
    <%
        String acao = request.getParameter("acao");
    %>
    <body onload="salvarCliente(<%= request.getParameter("id")%>, '<%= request.getParameter("nome")%>', '<%= request.getParameter("data_nascimento")%>', '<%= request.getParameter("cpf")%>', '<%= request.getParameter("rg")%>', '<%= request.getParameter("orgao_emissor")%>', '<%= request.getParameter("sexo")%>', '<%= request.getParameter("email")%>', '<%= request.getParameter("telefone")%>', '<%= request.getParameter("whats")%>', '<%= request.getParameter("logradouro")%>', '<%= request.getParameter("numero")%>', '<%= request.getParameter("bairro")%>', '<%= request.getParameter("cidade")%>', '<%= request.getParameter("estado")%>', '<%= request.getParameter("cep")%>', '<%= acao%>');">
        <h1>Dados do Cliente</h1>
        <hr>
        <p id="msg"></p>
        <a href="index.html">Voltar para o Início</a>
    </body>
</html>
