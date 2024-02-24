<%-- 
    Document   : listaUsuarios
    Created on : 16 de dez. de 2023, 09:59:53
    Author     : Morisko
--%>
<%-- <%@page import="br.edu.ifrs.burgerproject.modelo.CadastroUsuario"%>--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script language="javascript" src="Scripts.js"></script>
        <--!<link rel="stylesheet" type="text/css" href="estilos.css">-->
    </head>

    <body onload="buscarUsuarios()">
    <div id="principal">
        <div id="banner"></div>
        
        <div id="menu">
            <ul>
                <li><a href="index.html">Home</a></li><br>
                <li><a href="listaUsuarios.jsp">Usuários</a></li><br>
                <li><a href="">Clientes</a></li><br>
                <li><a href="Produtos.jsp">Produtos</a></li><br>
                <li><a href="">Pedidos</a></li><br>
    
            </ul>
        </div>
        <div id="texto">
            <h1>Usuários</h1>
            <hr>

            <form action="cadastroUsuario.jsp" method="post">
                <input type="submit" name="acao" value="Cadastro">
                <input type="submit" name="acao" value="Atualizar">
                <input type="button" value="Excluir" onclick="excluirUsuario()">


                <table border="1" id="tblUsuarios">
                        <tr>
                            <th>CPF</th>
                            <th>NOME</th>
                            <th>DATA NASCIMENTO</th>
                            <th>EMAIL</th>
                            <th>TELEFONE</th>
                            <th>WHATS</th>
                        </tr>


                </table>
            </form>
            <br><br>
            <a href="index.html">Voltar a página inicial.</a>
        </div>
    </div>
    </body>
</html>