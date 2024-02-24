

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

function excluirProduto() {
    var params = '{\"id\":'+$('input[name="id"]:checked').val()+'}';
    
   
    $.ajax({
        type: "POST",  
        url: "http://localhost:8080/back-Webapp/webresources/generic/excluir",
        data: params,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(msg, status) {
            console.log("Resposta bem-sucedida: ", msg);
            alert('Sucesso!!!!');
            window.location.reload();
        },
        error: function(xhr, msg, e) {
            alert(JSON.stringify(xhr));
        }
    });
}

/*function salvarProduto(id, nome, descricao, unidade, preco, acao) {
    var params = "{\"id\":"+id+",";
    params += "\"nome\":\""+nome+"\",";
    params += "\"descricao\":"+descricao+",";
    params += "\"unidade\":"+unidade+",";
    params += "\"preco\":}"+preco+"}";
    
    $.ajax({
        type: "POST",  
        url: "http://localhost:8080/back-Webapp/webresources/generic/"+acao.toLowerCase(),
        data: params,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(msg, status) {
            $("#msg").append('Sucesso!!!!');
        },
        error: function(xhr, msg, e) {
            $("#msg").append(JSON.stringify(xhr));
        }
    });
}*/

function salvarProduto(id, nome, descricao, unidade, preco, acao) {
    var params = {
        "id": id,
        "nome": nome,
        "descricao": descricao,
        "unidade": unidade,
        "preco": preco
    };

    $.ajax({
        type: "POST",  
        url: "http://localhost:8080/back-Webapp/webresources/generic/" + acao.toLowerCase(),
        data: JSON.stringify(params),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(msg, status) {
            $("#msg").append('Sucesso!!!!');
        },
        error: function(xhr, msg, e) {
            $("#msg").append(JSON.stringify(xhr));
        }
    });
}

function buscarProdutoPorId(id) {
    var params = '';
    $.ajax({
        type: "GET",  /* método de envio dos parâmetros para o web service */
        url: "http://localhost:8080/back-Webapp/webresources/generic/"+id,
        data: params,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(msg, status) {
            $("#nome").val(msg.nome);
            $("#descricao").val(msg.descricao);
            $("#unidade").val(msg.unidade);
            $("#preco").val(msg.preco);
        },
        error: function(xhr, msg, e) {
            alert(JSON.stringify(xhr));
        }
    });
}

/*  INICIO SCRIPTS DO CLIENTE */

function salvarCliente(id, nome, data_nascimento, cpf, rg, orgao_emissor, sexo, email, telefone, whats, logradouro, numero, bairro, cidade, estado, cep, acao) {
   var params = {
       "id": id,
       "nome": nome,
       "data_nascimento": data_nascimento,
       "cpf": cpf,
       "rg": rg,
       "orgao_emissor": orgao_emissor,
       "sexo": sexo,
       "email": email,
       "telefone": telefone,
       "whats": whats,
       "logradouro": logradouro,
       "numero": numero,
       "bairro": bairro,
       "cidade": cidade,
       "estado": estado,
       "cep": cep
   };

   $.ajax({
       type: "POST", 
       url: "http://localhost:8080/back-Webapp/webresources/backSeparado/" + acao.toLowerCase(),
       data: JSON.stringify(params),
       contentType: "application/json; charset=utf-8",
       dataType: "json",
       success: function(msg, status) {
           $("#msg").append('Sucesso!!!!');
       },
       error: function(xhr, msg, e) {
           $("#msg").append(JSON.stringify(xhr));
       }
   });
}

function excluirCliente() {
    var params = '{\"id\":'+$('input[name="id"]:checked').val()+'}';
    
   
    $.ajax({
        type: "POST",  
        url: "http://localhost:8080/back-Webapp/webresources/backSeparado/excluir",
        data: params,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(msg, status) {
            console.log("Resposta bem-sucedida: ", msg);
            alert('Sucesso!!!!');
            window.location.reload();
        },
        error: function(xhr, msg, e) {
            alert(JSON.stringify(xhr));
        }
    });
}

function buscarClientePorId(id) {
   var params = '';
   $.ajax({
       type: "GET",
       url: "http://localhost:8080/back-Webapp/webresources/backSeparado/"+id,
       data: params,
       contentType: "application/json; charset=utf-8",
       dataType: "json",
       success: function(msg, status) {
           $("#nome").val(msg.nome);
           $("#data_nascimento").val(msg.data_nascimento);
           $("#cpf").val(msg.cpf);
           $("#rg").val(msg.rg);
           $("#orgao_emissor").val(msg.orgao_emissor);
           $("#sexo").val(msg.sexo);
           $("#email").val(msg.email);
           $("#telefone").val(msg.telefone);
           $("#whats").val(msg.whats);
           $("#logradouro").val(msg.logradouro);
           $("#numero").val(msg.numero);
           $("#bairro").val(msg.bairro);
           $("#cidade").val(msg.cidade);
           $("#estado").val(msg.estado);
           $("#cep").val(msg.cep);
       },
       error: function(xhr, msg, e) {
           alert(JSON.stringify(xhr));
       }
   });
}

function buscarClientes() {
   var params = '';

   // Certifique-se de que a tabela existe antes de adicionar linhas
   var tabelaClientes = $("#tblClientes");
   if (!tabelaClientes.length) {
       console.error("A tabela #tblClientes não foi encontrada no DOM.");
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
               linha += "<td>" + msg[i].nome + "</td>";
               linha += "<td>" + msg[i].data_nascimento + "</td>";
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

/*  FIM SCRIPTS DO CLIENTE */

