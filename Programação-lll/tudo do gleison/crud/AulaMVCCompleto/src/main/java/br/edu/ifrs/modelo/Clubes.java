/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAMSUNG
 */
public class Clubes {
    private int id;
    private String sigla;
    private String nome;
    
    public Clubes() {
        this.sigla = "";
        this.nome = "";
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
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
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
    
    public void inserir() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/brasileirao", "root", "12345678");
            
            PreparedStatement pstmt = con.prepareStatement("insert into clubes (sigla, nome) values (?, ?)");
            pstmt.setString(1, this.sigla);
            pstmt.setString(2, this.nome);
            
            pstmt.execute();
            
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Clubes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/brasileirao", "root", "12345678");
            
            PreparedStatement pstmt = con.prepareStatement("update clubes set sigla = ?, nome = ? where id = ?");
            pstmt.setString(1, this.sigla);
            pstmt.setString(2, this.nome);
            pstmt.setInt(3, this.id);
            
            pstmt.execute();
            
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Clubes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/brasileirao", "root", "12345678");
            
            PreparedStatement pstmt = con.prepareStatement("delete from clubes where id = ?");
            pstmt.setInt(1, this.id);
            
            pstmt.execute();
            
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Clubes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Clubes[] selecionar() {
        List<Clubes> lista = new ArrayList();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/brasileirao", "root", "12345678");
            
            PreparedStatement pstmt = con.prepareStatement("select * from clubes");
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Clubes c = new Clubes();
                c.setId(rs.getInt("id"));
                c.setSigla(rs.getString("sigla"));
                c.setNome(rs.getString("nome"));
                
                lista.add(c);
            }
            
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Clubes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista.toArray(new Clubes[0]);
    }
    
    public void selecionarId() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/brasileirao", "root", "12345678");
            
            PreparedStatement pstmt = con.prepareStatement("select * from clubes where id = ?");
            pstmt.setInt(1, this.id);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                this.setSigla(rs.getString("sigla"));
                this.setNome(rs.getString("nome"));
            }
            
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Clubes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
