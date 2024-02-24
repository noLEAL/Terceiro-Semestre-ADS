<%-- 
    Document   : processamento
    Created on : 12 de dez. de 2023, 11:30:04
    Author     : SAMSUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lojão Oba Oba</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script language="javascript" src="scripts.js"></script>
    </head>
    <%
    String acao = request.getParameter("acao");
    %>
    <body onload="salvar(<%= request.getParameter("id")%>, '<%= request.getParameter("modelo")%>', '<%= request.getParameter("tamanho")%>', <%= request.getParameter("preco")%>, <%= request.getParameter("qtde")%>, '<%= acao%>');">
        <h1>Cadastro de Camisas</h1>
        <hr>
        <p id="msg"></p>
        <a href="/FrontEnd1012/camisas/lista.jsp">Voltar para Lista de Camisas</a>
    </body>
</html>
