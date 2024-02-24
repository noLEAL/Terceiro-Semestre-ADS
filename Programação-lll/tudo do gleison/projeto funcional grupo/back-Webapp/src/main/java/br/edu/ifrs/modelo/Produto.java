/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrs.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private String unidade ;
    private float preco;
    
    public void inserir(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho", "root", "junker90"); PreparedStatement pstmt = conexao.prepareStatement("insert into produtos (nome, descricao, unidade, preco_unitario) values (?, ?, ?, ?)")) {
                pstmt.setString(1, this.nome);
                pstmt.setString(2, this.descricao);
                pstmt.setString(3, this.unidade);
                pstmt.setFloat(4, this.preco);
                pstmt.execute();
            }
            
        } catch (SQLException ex) {
        // Trate exceções específicas do banco de dados
        Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, "Erro durante a execução da query SQL", ex);
        ex.printStackTrace(); // Adicione esta linha para imprimir o stack trace no console

        // Se necessário, relance a exceção ou faça algo mais significativo

    } catch (Exception ex) {
        // Trate outras exceções
        Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, "Erro desconhecido durante a inserção", ex);
        ex.printStackTrace(); // Adicione esta linha para imprimir o stack trace no console

        // Se necessário, relance a exceção ou faça algo mais significativo

    }
        
    }
    
    public void atualizar(){
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho", "root", "junker90");
            
            PreparedStatement pstmt = conexao.prepareStatement("update produtos set nome = ?, descricao = ?, unidade = ?, preco_unitario = ?) where id = ?");
            pstmt.setString(1, this.nome);
            pstmt.setString(2, this.descricao);
            pstmt.setString(3, this.unidade);
            pstmt.setFloat(4, preco);
            pstmt.setInt(5, this.id);
            pstmt.execute();
            pstmt.close();
            
            conexao.close();
            
        } catch (Exception ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void excluir(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho", "root", "junker90");
            
            PreparedStatement pstmt = conexao.prepareStatement("delete from produtos where id = ?");
            pstmt.setInt(1, this.id);
            pstmt.execute();
            pstmt.close();
            
            conexao.close();
            
        } catch (Exception ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Produto[] selecionar() throws Exception{
        List<Produto> lista = new ArrayList(); 
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho", "root", "junker90");
            
            PreparedStatement pstmt = conexao.prepareStatement("select * from produtos");
            ResultSet ResultadoSelect = pstmt.executeQuery();
            while(ResultadoSelect.next()){
                Produto novoProduto = new Produto();
                novoProduto.setId(ResultadoSelect.getInt("id"));
                novoProduto.setNome(ResultadoSelect.getString("nome"));
                novoProduto.setDescricao(ResultadoSelect.getString("descricao"));
                novoProduto.setUnidade(ResultadoSelect.getString("unidade"));
                novoProduto.setPreco(ResultadoSelect.getFloat("preco_unitario"));
                
                lista.add(novoProduto);
            }
            ResultadoSelect.close();
            pstmt.close();
            
            conexao.close();
            
        } catch (Exception ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista.toArray(new Produto [0]);
        
      
    }
    
    public void selecionarId() throws Exception{
       
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho", "root", "junker90");
            
            PreparedStatement pstmt = conexao.prepareStatement("select * from produtos where id = ?");
            ResultSet ResultadoSelect = pstmt.executeQuery();
            
            pstmt.setInt(1, this.id);
            
            if(ResultadoSelect.next()){
                Produto novoProduto = new Produto();
                novoProduto.setId(ResultadoSelect.getInt("id"));
                novoProduto.setNome(ResultadoSelect.getString("nome"));
                novoProduto.setDescricao(ResultadoSelect.getString("descricao"));
                novoProduto.setUnidade(ResultadoSelect.getString("unidade"));
                novoProduto.setPreco(ResultadoSelect.getFloat("preco_unitario"));
                
                
            }
            ResultadoSelect.close();
            pstmt.close();
            
            conexao.close();
            
        } catch (Exception ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    private void header(String accessControlAllowOrigin, String httpseufrontend) {
        header("Access-Control-Allow-Origin", "http://localhost:8080/Produtos.html");
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void parseFloat(String preco) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
