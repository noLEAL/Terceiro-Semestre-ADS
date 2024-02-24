<%-- 
    Document   : cadastroUsuario
    Created on : 17 de dez. de 2023, 20:26:43
    Author     : mauri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String cpf = request.getParameter("cpf");
    String acao = request.getParameter("acao");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <script language="javascript" src="Scripts.js"></script>
    </head>
    
        <%
            if (acao.equals("Atualizar") || acao.equals("Excluir")) {
        %>
    <body onload="selecionarPorCpf(<%= cpf%>)">
        <%
            } else {
        %>
    
    <body>
        
        <%
            cpf = "-1";
            }
        %> 
        
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
                    <form action="processamento.jsp" method="POST">
                        <h1>CADASTRO DE USUÁRIO</h1>
                        <label for="cpf">CPF:</label>
                        <input typpe="text" id="cpf" name="cpf"  required placeholder="000.000.000-00"><br><br>

                        <label for="nome">Nome:</label>
                        <input type="text" id="nome" name="nome" required><br><br>

                        <label for="data_nascimento">Data de Nascimento:</label>
                        <input type="date" id="data_nascimento" name="data_nascimento"><br><br>

                        <label for="email">E-mail:</label>
                        <input type="email" id="email" name="email" required><br><br>

                        <label for="telefone">Telefone:</label>
                        <input type="tel" id="telefone" name="telefone"  placeholder="+55(00)00000-0000"><br><br>

                        <label for="whats">Whatsapp:</label>
                        <input type="number" id="whats" name="whats" min="0" max="1">
                        <small>(1 - Possui Whats, 0 - Não Possui)</small><br><br>

                        <label for="username">Username:</label>
                        <input type="text" id="username" name="username" pattern=".{8,}" title="Deve conter pelo menos 8 caracteres" required><br><br>

                        <label for="senha">Senha:</label>
                        <input type="password" id="senha" name="senha"  title="Deve conter pelo menos 8 caracteres, sendo ao menos uma letra ou um número" required><br><br>

                        <input type="submit" name="acao" value="<%= acao%>">
                    </form>
                    <br><br>
                    <a href="index.html">Voltar a página inicial.</a>
                </div>
            </div>
        </body>
</html>
