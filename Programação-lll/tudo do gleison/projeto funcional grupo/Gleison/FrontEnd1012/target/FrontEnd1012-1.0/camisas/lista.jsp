<%-- 
    Document   : lista
    Created on : 12 de dez. de 2023, 11:29:44
    Author     : SAMSUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lojão Oba Oba</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script language="javascript" src="scripts.js"></script>
    </head>
    <body onload="buscarCamisas()">
        <h1>Cadastro de Camisas</h1>
        <hr>
        <form action="formulario.jsp" method="post">
            <input type="submit" name="acao" value="Inserir">
            <input type="submit" name="acao" value="Atualizar">
            <input type="button" value="Excluir" onclick="excluir()">
            
            <table border="1" id="tblcamisas">
                    <tr>
                        <th>Seleção</th>
                        <th>Modelo</th>
                        <th>Tamanho</th>
                        <th>Preço</th>
                        <th>Quantidade em Estoque</th>
                    </tr>
            </table>
        </form>
    </body>
</html>
