<%-- 
    Document   : processamentoUsuario
    Created on : 20 de dez. de 2023, 20:31:52
    Author     : mauri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lojão Oba Oba</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script language="javascript" src="Scripts.js"></script>
    </head>
    <%
    String acao = request.getParameter("acao");
        
    %>
    <body onload="salvarUsuario('<%= request.getParameter("cpf")%>', '<%= request.getParameter("nome")%>', '<%= request.getParameter("data_nascimento")%>', '<%= request.getParameter("email")%>', '<%= request.getParameter("telefone")%>', <%= request.getParameter("whats")%>, '<%= request.getParameter("username")%>', '<%= request.getParameter("senha")%>', '<%= acao%>');">
        <h1>Cadastro de Usuarios</h1>
        <hr>
        
        <p id="msg"></p>
        <a href="index.html">Voltar para Lista de Usuarios</a>
    </body>
</html>
