/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo;

import br.edu.ifrs.util.Conexao;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAMSUNG
 */
public class Camisas {
    private int id;
    private String modelo;
    private String tamanho;
    private float preco;
    private int quantidade_estoque;
    
    public Camisas() {
        this.id = -1;
        this.modelo = "";
        this.tamanho = "";
        this.preco = (float)0.0;
        this.quantidade_estoque = 0;
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
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the tamanho
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
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
    public void setPreco(float preco) throws Exception {
        if (preco < 10 || preco > 100) {
            throw new Exception("O valor de preço deve estar entre 10 e 100!!!");
        }
        
        this.preco = preco;
    }

    /**
     * @return the quantidade_estoque
     */
    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    /**
     * @param quantidade_estoque the quantidade_estoque to set
     */
    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }
    
    public void inserir() throws Exception {
        Connection con = null;
        PreparedStatement p = null;
        
        try {
            // Informar qual o driver JDBC a ser utilizado
            /*Class.forName("com.mysql.jdbc.Driver");*/
            
            // Abrir uma Conexão com o Banco de Dados
            /*con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojao", "root", "12345678");*/
            
            /* Abertura de Conexão com Classe Utilitária */
            con = Conexao.pegarConexao();
            
            // Definir a sentença SQL
            p = con.prepareStatement("insert into camisas (modelo, tamanho, preco, quantidade_estoque) values (?, ?, ?, ?)");
            
            // Parametrizar a sentença SQL
            p.setString(1, this.modelo);
            p.setString(2, this.tamanho);
            p.setFloat(3, this.preco);
            p.setInt(4, this.quantidade_estoque);
            
            // Executar a operação
            p.execute();
        } catch (MysqlDataTruncation m) {
            throw new Exception("[Camisas.inserir] - Informação muito longa ");
        } catch (Exception e) {
            throw new Exception("[Camisas.inserir] - Falha ao executar a operação de inserção no banco de dados: "+e.getMessage());
        } finally {
            // Fechar a conexão
            if (p != null) p.close();
            if (con != null) con.close();            
        }
    }
    
    public void atualizar() throws Exception {
        Connection con = null;
        PreparedStatement p = null;

        try {
            // Informar qual o driver JDBC a ser utilizado
            /*Class.forName("com.mysql.jdbc.Driver");*/
            
            // Abrir uma Conexão com o Banco de Dados
            /*con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojao", "root", "12345678");*/
            
            /* Abertura de Conexão com Classe Utilitária */
            con = Conexao.pegarConexao();
            
            // Definir a sentença SQL
            p = con.prepareStatement("update camisas set modelo = ?, tamanho = ?, preco = ?, quantidade_estoque = ? where id = ?");
            
            // Parametrizar a sentença SQL
            p.setString(1, this.modelo);
            p.setString(2, this.tamanho);
            p.setFloat(3, this.preco);
            p.setInt(4, this.quantidade_estoque);
            p.setInt(5, this.id);
            
            // Executar a operação
            p.execute();            
        } catch (Exception e) {
            throw new Exception("[Camisas.atualizar] - Falha ao executar a operação de atualização no banco de dados: "+e.getMessage());
        } finally {
            // Fechar a conexão
            if (p != null) p.close();
            if (con != null) con.close();            
        }
    }
    
    public void excluir() throws Exception {
        Connection con = null;
        PreparedStatement p = null;

        try {
            // Informar qual o driver JDBC a ser utilizado
            /*Class.forName("com.mysql.jdbc.Driver");*/
            
            // Abrir uma Conexão com o Banco de Dados
            /*con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojao", "root", "12345678");*/
            
            /* Abertura de Conexão com Classe Utilitária */
            con = Conexao.pegarConexao();
            
            // Definir a sentença SQL
            p = con.prepareStatement("delete from camisas where id = ?");
            
            // Parametrizar a sentença SQL
            p.setInt(1, this.id);
            
            // Executar a operação
            p.execute();            
        } catch (Exception e) {
            throw new Exception("[Camisas.excluir] - Falha ao executar a operação de exclusão no banco de dados: "+e.getMessage());
        } finally {
            // Fechar a conexão
            if (p != null) p.close();
            if (con != null) con.close();            
        }
    }
    
    public Camisas[] selecionar() throws Exception {
        List<Camisas> lista = new ArrayList();
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;

        try {
            // Informar qual o driver JDBC a ser utilizado
            /*Class.forName("com.mysql.jdbc.Driver");*/
            
            // Abrir uma Conexão com o Banco de Dados
            /*con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojao", "root", "12345678");*/
            
            /* Abertura de Conexão com Classe Utilitária */
            con = Conexao.pegarConexao();
            
            // Definir a sentença SQL
            p = con.prepareStatement("select * from camisas");
                        
            // Executar a operação
            rs = p.executeQuery();
            
            while (rs.next()) {
                Camisas c = new Camisas();
                c.setId(rs.getInt("id"));
                c.setModelo(rs.getString("modelo"));
                c.setTamanho(rs.getString("tamanho"));
                //c.setPreco(rs.getFloat("preco"));
                c.preco = rs.getFloat("preco");
                c.setQuantidade_estoque(rs.getInt("quantidade_estoque"));

                lista.add(c);
            }            
        } catch (Exception e) {
            throw new Exception("[Camisas.selecionar] - Falha ao executar a operação de seleção no banco de dados: "+e.getMessage());
        } finally {
            // Fechar a conexão
            if (rs != null) rs.close();
            if (p != null) p.close();
            if (con != null) con.close();            
        }
        
        return lista.toArray(new Camisas[0]);
    }
    
    public void selecionarId() throws Exception {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;

        try {
            // Informar qual o driver JDBC a ser utilizado
            /*Class.forName("com.mysql.jdbc.Driver");*/
            
            // Abrir uma Conexão com o Banco de Dados
            /*con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojao", "root", "12345678");*/
            
            /* Abertura de Conexão com Classe Utilitária */
            con = Conexao.pegarConexao();
            
            // Definir a sentença SQL
            p = con.prepareStatement("select * from camisas where id = ?");
            
            // Parametrizar a sentença SQL
            p.setInt(1, this.id);
                        
            // Executar a operação
            rs = p.executeQuery();
            
            if (rs.next()) {
                this.setModelo(rs.getString("modelo"));
                this.setTamanho(rs.getString("tamanho"));
                this.setPreco(rs.getFloat("preco"));
                this.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
            }
            
            // Fechar a conexão
            p.close();
            con.close();
        } catch (Exception e) {
            throw new Exception("[Camisas.selecionarId] - Falha ao executar a operação de seleção pela chave primária no banco de dados: "+e.getMessage());
        } finally {
            // Fechar a conexão
            if (rs != null) rs.close();
            if (p != null) p.close();
            if (con != null) con.close();            
        }
    }
}
