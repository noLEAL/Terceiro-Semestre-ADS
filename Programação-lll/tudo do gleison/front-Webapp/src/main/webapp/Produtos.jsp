<%-- 
    Document   : Produtos
    Created on : 17 de dez. de 2023, 10:21:13
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
        <link rel="stylesheet" type="text/css" href="estilos.css">
    </head>
    <body onload="buscarProdutos()">
        <div id="principal">
        <div id="banner"></div>    
        
        <div id="menu">
            <ul>
                <li><a href="index.html">Home</a></li><br>
                <li><a href="listaUsuarios.jsp">Usuários</a></li><br>
                <li><a href="listaCliente.jsp">Clientes</a></li><br>
                <li><a href="Produtos.jsp">Produtos</a></li><br>
                <li><a href="">Pedidos</a></li><br>
    
            </ul>
        </div>
         
        <div id="texto">
            <h1>PRODUTOS</h1>
            <hr>

            <form action="Forms.jsp" method="post">
                <input type="submit" name="acao" value="Cadastro">
                <input type="submit" name="acao" value="Atualizar">
                <input type="button" value="Excluir" onclick="excluirProduto()">

                <br>
                <br>

                <fieldset>    
                    <table border="1" id="tblProdutos">
                        <legend>Lista de Produtos</legend>
                        <tr>
                        <th>Selecionar</th>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Unidade</th>
                        <th>Preço</th>
                        </tr>

                    </table>
                </fieldset>    
            </form>
            <br><br>
            <a href="index.html">Voltar a página inicial.</a>
        </div>
    </div>
  </body>
</html>