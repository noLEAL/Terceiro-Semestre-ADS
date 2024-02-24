<%-- 
    Document   : lista
    Created on : 12 de dez. de 2023, 11:29:44
    Author     : SAMSUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    String acao = request.getParameter("acao");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lojão Oba Oba</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script language="javascript" src="scripts.js"></script>
    </head>
    <%
    if (acao.equals("Atualizar") || acao.equals("Excluir")) {
    %>
    <body onload="buscarCamisaPorId(<%= id%>)">
    <%
    } else {
    %>
    <body>
    <%
        id = "-1";
    }
    %>    
        <h1>Cadastro de Camisas</h1>
        <hr>
        <form action="processamento.jsp" method="post">
            <input type="hidden" name="id" id="id" value="<%= id%>">
                   
            <label for="modelo">Modelo: </label>
            <input type="text" name="modelo" id="modelo" size="30" value=""><br><br>
            
            <label for="tamanho">Tamanho: </label>
            <select name="tamanho" id="tamanho">
                <option value="">-- Selecione um Tamanho --</option>
                <option id="optp" value="P">Pequeno</option>
                <option id="optm" value="M">Média</option>
                <option id="optg" value="G">Grande</option>
            </select><br><br>
            
            <label for="preco">Preço Unitário: </label>
            <input type="number" name="preco" id="preco" step="0.1" value=""><br><br>
            
            <label for="qtde">Quantidade em Estoque: </label>
            <input type="number" name="qtde" id="qtde" value=""><br><br>
            
            <input type="submit" name="acao" value="<%= acao%>">
        </form>
    </body>
</html>
