/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author SAMSUNG
 */
public class Conexao {
    private static String url_jdbc = "jdbc:mysql://localhost:3306/lojao";
    private static String usuario = "root";
    private static String senha = "12345678";
    
    public static Connection pegarConexao() throws Exception {
        // Informar qual o driver JDBC a ser utilizado
        Class.forName("com.mysql.jdbc.Driver");
            
        // Abrir uma Conexão com o Banco de Dados
        Connection con = DriverManager.getConnection(url_jdbc, usuario, senha);
        
        return con;
    }
}
