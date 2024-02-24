<%-- 
    Document   : Cadastro
    Created on : 6 de dez. de 2023, 00:58:01
    Author     : mauri

<%-- <%@page import="br.edu.ifrs.back-Webapp.modelo.Produto"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String id = request.getParameter("id");
    String acao = request.getParameter("acao");
%>

<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script language="javascript" src="Scripts.js"></script>
        <link rel="stylesheet" type="text/css" href="estilos.css">
    </head>
    
    <%
        if (acao.equals("Atualizar") || acao.equals("Excluir")) {
    %>
        <body onload="buscarProdutoPorId(<%= id%>)">
    <%
        } else {
    %>
    <body>
    <%
        id = "-1";
    }
    %> 
           
        <div id="principal">
            <div id="banner"></div>
            
            <div id="menu">
                <ul>
                    <li><a href="index.html">home</a></li><br>
                    <li><a href="listaUsuario.jsp">Usuários</a></li><br>
                    <li><a href="listaCliente.jsp">Clientes</a></li><br>
                    <li><a href="Produtos.jsp">Produtos</a></li><br>
                    <li><a href="">Pedidos</a></li><br>
    
                </ul>
            </div>
            <div id="texto">
                <h1>Dados do Produto</h1>
                <hr>

                <form action="processamentoProduto.jsp"  method="POST">
                    
                    <input type="hidden" name="id" id="id" value="<%= id%>">
                    <br><br><!-- comment -->

                    <label for="nome">Nome: </label>
                    <input type="text" name="nome" id="nome" maxlength="100" value="">
                    <br><br>

                    <label for="descricao">Descricao: </label>
                    <input type="text" name="descricao" id="descricao" maxlength="200" value="">
                    <br><br>

                    <label for="unidade">Unidade:</label>
                    <select name="unidade" id="unidade" required="required">
                        <option>-- Selecione uma unidade --</option>
                        <option value="UNI">Unidade - Un</option><!-- comment -->
                        <option value="LT"> Litros - Lt</option>
                        <option value="KG"> Kilos - Kg</option>
                    </select>
                    <br><br>

                    <label for="preco">Preço: </label>
                    <input type="number" name="preco" id="preco"" value="">
                    <br><br><!--  -->

                    <input type="submit" name="acao" value="<%= acao%>">
                    <input type="reset" value="Limpar">


                </form>
            </div>    
        </div>
    </body>
</html>
