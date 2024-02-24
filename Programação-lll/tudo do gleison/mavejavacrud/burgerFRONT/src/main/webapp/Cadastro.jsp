<%-- 
    Document   : Cadastro
    Created on : 7 de dez. de 2023, 17:26:03
    Author     : noLEAL
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <script>
        function redirecionar() {
            window.location.href = "Pesquisa.html";
        }
        
        
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
        
        function mascaraNacimento(i,t){
           var v = i.value;

           if(isNaN(v[v.length-1])){
               i.value = v.substring(0, v.length-1);
               return;
           }

           if(t === "nascimento"){
               i.setAttribute("maxlength", "10");
               if (v.length === 2 || v.length === 5) i.value += "/";
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
    <body>
        <div id="principal">
            <div id="banner"></div>
            <div id="menu">
                <ul>
                    <li><a href="index.html">HOME</a></li>
                    <li><a href="Pesquisa.html">PESQUISA</a></li>
                    <li><a href="Cadastro.jsp">CADASTRO</a></li>
    
                </ul>
            </div>
            <div id="texto">
                <h1>Cadastros</h1>
                <form id="formulario" action="http://localhost:8080/burgerProject/webresources/ProcessamentoWS/cadastro" method="POST">
                    <label for="nome">Nome:</label><br>
                    <input type="text" id="nome" name="nome" maxlength="100" required><br>
                     
                    
                    <label for="data_nascimento">Data de Nascimento:</label><br>
                    <input type="text" id="data_nascimento" name="data_nascimento" maxlength="8" oninput="mascaraNacimento(this, 'nascimento')" required><br>
                    
                     
                    <label for="cpf">CPF:</label><br>
                    <input type="text" id="cpf" name="cpf" maxlength="14" oninput="mascaraCPF(this, 'cpf')" required><br>

                    <label for="rg">RG:</label><br>
                    <input type="text" id="rg" name="rg"  maxlength="15"><br>

                    <label for="orgao_emissor">Orgão Emissor:</label><br>
                    <input type="text" id="orgao_emissor" name="orgao_emissor" maxlength="20"><br>

                    <label for="sexo">Sexo:</label><br>
                    <input type="radio" id="sexo_feminino" name="sexo" value="FEMININO" required>
                    <label for="sexo_feminino">Feminino</label><br>
                    <input type="radio" id="sexo_masculino" name="sexo" value="MASCULINO" required>
                    <label for="sexo_masculino">Masculino</label><br>

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

                    <input type="submit" value="Salvar">
                    <button type="button" onclick="redirecionar()">Cancelar</button>
                </form>
            </div>
        </div>
    </body>
</html>
