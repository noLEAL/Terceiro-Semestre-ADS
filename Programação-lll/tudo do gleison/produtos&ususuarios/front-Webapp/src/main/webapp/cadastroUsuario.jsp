NOVO

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String cpf = request.getParameter("cpf");
    String acao = request.getParameter("acao");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--<link rel="stylesheet" type="text/css" href="estilos.css">-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script language="javascript" src="Scripts.js"></script>
        <title>JSP Page</title>
    </head>
    <%
    if (acao.equals("Atualizar") || acao.equals("Excluir")) {
    %>
    <body onload="buscarUsuarioPorCpf(<%= cpf%>)">
    <%
    } else {
    %>
    <body>
    <%
        cpf = "";
    }
    %>  
        <div id="principal">
            <div id="banner"></div>
            <div id="menu">
                <ul>
                    <li><a href="index.html">HOME</a></li><br>
                    <li><a href="Pesquisa.html">PESQUISA</a></li><br>
                    <li><a href="Cadastro.html">CADASTRO</a></li>
    
                </ul>
            </div>
            
            <div id="div_cadastro_usuario">
                
                <form action="processamentoUsuario.jsp" method="post">
                    <h1>CADASTRO DE USUÁRIO</h1>
                    <label for="cpf">CPF:</label>
                    <input type="text" id="cpf" name="cpf"  required placeholder="000.000.000-00" value="<%= cpf%>"><br><br>

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
            </div>
    </body>
</html>