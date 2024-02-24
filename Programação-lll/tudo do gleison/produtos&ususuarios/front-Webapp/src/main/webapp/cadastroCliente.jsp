<%-- 
    Document   : cadastroCliente
    Created on : 19 de dez. de 2023, 23:50:10
    Author     : noLEAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String id = request.getParameter("id");
    String acao = request.getParameter("acao");
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script language="javascript" src="Scripts.js"></script>
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <script>       
        
        function mascaraCPF(i,t){
            var v = i.value;

            if(isNaN(v[v.length-1])){
              i.value = v.substring(0, v.length-1);
              return;
            }

            if(t === "cpf"){
              i.setAttribute("maxlength", "14");
              if (v.length === 3 || v.length === 7) i.value += ".";
              if (v.length === 11) i.value += "-";
            }
        }
        
        function mascaraNacimento(){
            var data = document.getElementById("dataNascimento").value;
            var dataNascimento = new Date(data);

            if (isNaN(dataNascimento.getTime())) {
                return false;
            } else {
                return true;
            }
        }
                                
        function validaEmail(i,t){
            var v = i.value;

            if(t === "email"){
                var regex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
                if(!regex.test(v)){
                    alert("Você inseriu um endereço de e-mail inválido!");
                    return false;
                }
            }
            return true;
        }
        
        </script>
    
    </head>
    
    <%
        if (acao.equals("Atualizar") || acao.equals("Excluir")) {
    %>
        <body onload="buscarClientePorId(<%= id%>)">
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
                    <li><a href="index.html">Home</a></li><br>
                    <li><a href="listaUsuarios.jsp">Usuários</a></li><br>
                    <li><a href="listaCliente.jsp">Clientes</a></li><br>
                    <li><a href="Produtos.jsp">Produtos</a></li><br>
                    <li><a href="">Pedidos</a></li>
                </ul>
            </div>
            <div id="texto">
                <h1>Cadastros</h1>
                <form id="formulario" action="processamentoCliente.jsp" method="POST">
                    
                    <input type="hidden" name="id" id="id" value="<%= id%>">
                    
                    <label for="nome">Nome:</label><br>
                    <input type="text" id="nome" name="nome" maxlength="100" required><br>
                     
                    
                    <label for="dataNascimento">Data de Nascimento:</label><br>
                    <input type="text" id="dataNascimento" placeholder="dd/mm/ano" name="dataNascimento" maxlength="8" oninput="mascaraNacimento(this, 'nascimento')" required><br>
                    
                     
                    <label for="cpf">CPF:</label><br>
                    <input type="text" id="cpf" name="cpf" maxlength="14" oninput="mascaraCPF(this, 'cpf')" required><br>

                    <label for="rg">RG:</label><br>
                    <input type="text" id="rg" name="rg"  maxlength="15"><br>

                    <label for="orgaoEmissor">Orgão Emissor:</label><br>
                    <input type="text" id="orgaoEmissor" name="orgaoEmissor" maxlength="20"><br>
                    <%-- 
                    <label for="sexo">Sexo:</label><br>
                    <input type="radio" id="sexo_feminino" name="sexo" value="FEMININO" required>
                    <label for="sexo_feminino">Feminino</label><br>
                    <input type="radio" id="sexo_masculino" name="sexo" value="MASCULINO" required>
                    <label for="sexo_masculino">Masculino</label><br>
                    --%> 
                    <label for="sexo">Unidade:</label>
                    <select name="sexo" id="sexo" required="required">
                        <option>Sexo</option>
                        <option value="FEMININO">Feminino</option><!-- comment -->
                        <option value="MASCULINO">Masculino</option>
                    </select><br>

                    <label for="email">Email:</label><br>
                    <input type="email" id="email" name="email" maxlength="100" onchange="validaEmail(this, 'email')" required><br>

                    <label for="telefone">Telefone:</label><br>
                    <input type="tel" id="telefone" name="telefone" maxlength="19"  required><br>

                    <label for="whats">Whats:</label><br>
                    <input type="checkbox" id="whats" name="whats"><br>

                    <label for="logradouro">Logradouro:</label><br>
                    <input type="text" id="logradouro" name="logradouro" maxlength="200"><br>

                    <label for="numero">Número:</label><br>
                    <input type="text" id="numero" name="numero" maxlength="20"><br>

                    <label for="bairro">Bairro:</label><br>
                    <input type="text" id="bairro" name="bairro" maxlength="100"><br>

                    <label for="cidade">Cidade:</label><br>
                    <input type="text" id="cidade" name="cidade"><br>

                    <label for="estado">Estado:</label><br>
                    <input type="text" id="estado" name="estado" placeholder="Sigla" maxlength="2"><br>

                    <label for="cep">CEP:</label><br>
                    <input type="text" id="cep" name="cep" maxlength="8" placeholder="Apenas números" required><br>
                    
                    
                    <input type="submit" name="acao" value="<%= acao%>">
                    <input type="reset" value="Limpar">
                    
                </form>
            </div>
        </div>
    </body>
</html>