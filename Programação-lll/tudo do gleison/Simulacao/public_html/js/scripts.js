/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

function validar() {
    var retorno = true;
    var patternCPF = /^[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$/;
    
    $("#erros li").remove();
    
    if ($("#cpf").val() == '') {
        $("#erros").append("<li>CPF é obrigatório!!!</li>");
        
        retorno = false;
    }
    
    if (!patternCPF.test($("#cpf").val())) {
        $("#erros").append("<li>CPF deve estar no formato 000.000.000-00!!!</li>");
        
        retorno = false;
    }
    
    if ($("#endereco").val().length > 200) {
        $("#erros").append("<li>Endereço tem mais de 200 caracteres</li>");
        
        retorno = false;
    }
    
    if (!$('#femino').is(':checked') && !$('#masculino').is(':checked')) {
        $("#erros").append("<li>Sexo é obrigatório</li>");
        
        retorno = false;
    }
    
    return retorno;
}



function popularEstados() {
    var params = '{}';
    $.ajax({
        type: "GET",  /* método de envio dos parâmetros para o web service */
        url: "https://servicodados.ibge.gov.br/api/v1/localidades/estados",
        data: params,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(msg, status) {
            
            msg.sort(function(a, b) {
                if(a.nome < b.nome) {
                    return -1;
                } else {
                    return true;
                }
            });
            
            msg.forEach((obj) => {
                $("#estado").append('<option value="'+ obj.sigla +'">'+ obj.nome +'</option>');
                    
            });
        },
        error: function(xhr, msg, e) {
            alert(xhr.responseJSON.message);
        }
    });
}

function popularCidades() {
    var params = '{}';
    $.ajax({
        type: "GET",  /* método de envio dos parâmetros para o web service */
        url: "https://servicodados.ibge.gov.br/api/v1/localidades/estados/"+ $("#estado").val() +"/municipios",
        data: params,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(msg, status) {
            
            $("#cidade option.cid").remove();
            msg.forEach((obj) => {
                $("#cidade").append('<option class="cid" value="'+ obj.id +'">'+ obj.nome +'</option>');
                    
            });
        },
        error: function(xhr, msg, e) {
            alert(xhr.responseJSON.message);
        }
    });
}