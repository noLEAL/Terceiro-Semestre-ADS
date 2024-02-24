

/* Certifique-se de que a biblioteca jQuery está incluída:
   <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
*/

function buscarProdutos() {
    var params = '';

    // Certifique-se de que a tabela existe antes de adicionar linhas
    var tabelaProdutos = $("#tblProdutos");
    if (!tabelaProdutos.length) {
        console.error("A tabela #tblProdutos não foi encontrada no DOM.");
        return;
    }

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/back-Webapp/webresources/generic/busca",
        data: params,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(msg, status) {
            // Limpa a tabela antes de adicionar novas linhas
            tabelaProdutos.empty();

            for (var i = 0; i < msg.length; i++) {
                var linha = "";
                linha = "<tr>";
                linha += "<td><input type=\"radio\" name=\"id\" value=\""+msg[i].id+"\"></td>";
                linha += "<td>" + msg[i].nome + "</td>";
                linha += "<td>" + msg[i].descricao + "</td>";
                linha += "<td>" + msg[i].unidade + "</td>";
                linha += "<td>" + msg[i].preco + "</td>";
                linha += "</tr>";

                tabelaProdutos.append(linha);
            }
        },
        error: function(xhr, msg, e) {
            console.error("Erro na requisição AJAX:", JSON.stringify(xhr));
        }
    });
}

function buscarClientes() {
   var params = '';

   // Certifique-se de que a tabela existe antes de adicionar linhas
   var tabelaClientes = $("#tblUsuarios");
   if (!tabelaClientes.length) {
       console.error("A tabela #tblUsuarios não foi encontrada no DOM.");
       return;
   }

   $.ajax({
       type: "GET",
       url: "http://localhost:8080/back-Webapp/webresources/backSeparado/busca",
       data: params,
       contentType: "application/json; charset=utf-8",
       dataType: "json",
       success: function(msg, status) {
           // Limpa a tabela antes de adicionar novas linhas
           tabelaClientes.empty();

           for (var i = 0; i < msg.length; i++) {
               var linha = "";
               linha = "<tr>";
               linha += "<td><input type=\"radio\" name=\"id\" value=\""+msg[i].id+"\"></td>";
               linha += "<td>" + msg[i].cpf + "</td>";
               linha += "<td>" + msg[i].rg + "</td>";
               linha += "<td>" + msg[i].orgaoEmissor + "</td>";
               linha += "<td>" + msg[i].sexo + "</td>";
               linha += "<td>" + msg[i].email + "</td>";
               linha += "<td>" + msg[i].telefone + "</td>";
               linha += "<td>" + msg[i].whats + "</td>";
               linha += "<td>" + msg[i].logradouro + "</td>";
               linha += "<td>" + msg[i].numero + "</td>";
               linha += "<td>" + msg[i].bairro + "</td>";
               linha += "<td>" + msg[i].cidade + "</td>";
               linha += "<td>" + msg[i].estado + "</td>";
               linha += "<td>" + msg[i].cep + "</td>";
               linha += "</tr>";

               tabelaClientes.append(linha);
           }
       },
       error: function(xhr, msg, e) {
           console.error("Erro na requisição AJAX:", JSON.stringify(xhr));
       }
   });
}


function buscarUsuarios() {
    var params = '';

    // Certifique-se de que a tabela existe antes de adicionar linhas
    var tabelaUsuarios = $("#tblUsuarios");
    if (!tabelaUsuarios.length) {
        console.error("A tabela #tblUsuarios não foi encontrada no DOM.");
        return;
    }

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/back-Webapp/webresources/usuarios/listar",
        data: params,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(msg, status) {
            // Limpa a tabela antes de adicionar novas linhas
            tabelaUsuarios.empty();

            for (var i = 0; i < msg.length; i++) {
                var linha ="";
                linha = "<tr>";
                linha += "<td><input type=\"radio\" name=\"cpf\" value=\""+msg[i].cpf+"\"></td>";
                linha += "<td>" + msg[i].nome + "</td>";
                linha += "<td>" + msg[i].data_nascimento + "</td>";
                linha += "<td>" + msg[i].email + "</td>";
                linha += "<td>" + msg[i].telefone + "</td>";
                linha += "<td>" + msg[i].whats + "</td>";
                linha += "</tr>";

                tabelaUsuarios.append(linha);
            }
        },
        error: function(xhr, msg, e) {
            console.error("Erro na requisição AJAX:", JSON.stringify(xhr));
        }
    });
}

function excluir() {
    var cpfSelecionado = $('input[name="cpf"]:checked').val();

    // Verificar se um rádio está selecionado
    if (cpfSelecionado === undefined || cpfSelecionado === null) {
        alert('Por favor, selecione um CPF.');
        return;
    }

    var params = JSON.stringify({ "cpf": cpfSelecionado });

    $.ajax({
        type: "PUT",
        url: "http://localhost/back-Webapp/webresources/usuarios/excluir",
        data: params,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (msg, status) {
            alert('Sucesso!!!!');
            window.location.reload();
        },
        error: function (xhr, msg, e) {
            alert('Erro: ' + JSON.stringify(xhr));
        }
    });
}