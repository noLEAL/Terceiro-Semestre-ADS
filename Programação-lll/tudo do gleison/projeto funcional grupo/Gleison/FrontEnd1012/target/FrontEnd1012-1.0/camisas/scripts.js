/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


/* AJAX + Jquery */
function buscarCamisas() {
    var params = '';
    $.ajax({
        type: "GET",  /* método de envio dos parâmetros para o web service */
        url: "http://localhost/Aula0612/webresources/camisas/all",
        data: params,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(msg, status) {
            for (var i=0; i<msg.length; i++) {
                var linha = "";
                linha = "<tr>";
                linha += "<td><input type=\"radio\" name=\"id\" value=\""+msg[i].id+"\"></td>";
                linha += "<td>"+msg[i].modelo+"</td>";
                linha += "<td>"+msg[i].tamanho+"</td>";
                linha += "<td>"+msg[i].preco+"</td>";
                linha += "<td>"+msg[i].quantidade_estoque+"</td>";
                linha += "</tr>";
                
                $("#tblcamisas").append(linha);
            }
        },
        error: function(xhr, msg, e) {
            alert(JSON.stringify(xhr));
        }
    });
}

function buscarCamisaPorId(id) {
    var params = '';
    $.ajax({
        type: "GET",  /* método de envio dos parâmetros para o web service */
        url: "http://localhost/Aula0612/webresources/camisas/"+id,
        data: params,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(msg, status) {
            $("#modelo").val(msg.modelo);
            $("#tamanho").val(msg.tamanho);
            $("#preco").val(msg.preco);
            $("#qtde").val(msg.quantidade_estoque);
        },
        error: function(xhr, msg, e) {
            alert(JSON.stringify(xhr));
        }
    });
}

function salvar(id, modelo, tamanho, preco, qtde, acao) {
    var params = "{\"id\":"+id+",";
    params += "\"modelo\":\""+modelo+"\",";
    params += "\"tamanho\":"+tamanho+",";
    params += "\"preco\":"+preco+",";
    params += "\"quantidade_estoque\":"+qtde+"}";
    
    $.ajax({
        type: "PUT",  
        url: "http://localhost/Aula0612/webresources/camisas/"+acao.toLowerCase(),
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
}

function excluir() {
    var params = '{\"id\":'+$('input[name="id"]:checked').val()+'}';
    
    $.ajax({
        type: "PUT",  
        url: "http://localhost/Aula0612/webresources/camisas/excluir",
        data: params,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(msg, status) {
            alert('Sucesso!!!!');
            window.location.reload();
        },
        error: function(xhr, msg, e) {
            alert(JSON.stringify(xhr));
        }
    });
}