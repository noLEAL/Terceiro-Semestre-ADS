<%-- 
    Document   : processamentoProduto
    Created on : 20 de dez. de 2023, 02:19:33
    Author     : mauri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script language="javascript" src="Scripts.js"></script>
    </head>
    <%
    String acao = request.getParameter("acao");
    %>
    <body onload="salvarProduto(<%= request.getParameter("id")%>, '<%= request.getParameter("nome")%>', '<%= request.getParameter("descricao")%>', '<%= request.getParameter("unidade")%>', 
	<%= request.getParameter("preco")%>, '<%= acao%>');">
        <h1>Dados do Produto</h1>
        <hr>
        <p id="msg"></p>
        <a href="index.html">Voltar para o Início</a>
    </body>
</html>
