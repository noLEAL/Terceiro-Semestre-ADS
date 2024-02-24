<%-- 
    Document   : listaUsuarios
    Created on : 16 de dez. de 2023, 09:59:53
    Author     : noLEAL
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
        <link rel="stylesheet" type="text/css" href="estilos.css">
    </head>
    
    <body onload="buscarClientes()">
    
    <div id="principal">
        <div id="banner"></div>
        
        <div id="menu">
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="listaUsuarios.jsp">Usuários</a></li>
                <li><a href="listaCliente.jsp">Clientes</a></li>
                <li><a href="Produtos.jsp">Produtos</a></li>
                <li><a href="">Pedidos</a></li>
            </ul>
        </div>
        <div id="texto">
            <h1>Cientes</h1>
            <hr>

            <form action="cadastroCliente.jsp" method="post">
                <input type="submit" name="acao" value="cadastro">
                <input type="submit" name="acao" value="Atualizar">
                <input type="button" value="Excluir" onclick="excluirCliente()">


                <table border="1" id="tblClientes">
                        <tr>
                            <th>Nome</th>
                            <th>Data Nascimento</th>
                            <th>CPF</th>
                            <th>RG</th>
                            <th>Orgão Emissor</th>
                            <th>Sexo</th>
                            <th>Email</th>
                            <th>Telefone</th>
                            <th>Whats</th>
                            <th>Logradouro</th>
                            <th>Número</th>
                            <th>Bairro</th>
                            <th>Cidade</th>
                            <th>Estado</th>
                            <th>CEP</th>
                        </tr>
                </table>
            </form>
            <br><br>
            <a href="index.html">Voltar a página inicial.</a>
        </div>
    </div>
    </body>
</html>