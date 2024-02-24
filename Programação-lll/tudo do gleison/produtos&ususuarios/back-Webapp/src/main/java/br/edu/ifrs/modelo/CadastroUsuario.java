/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrs.modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Morisko
 */
public class CadastroUsuario {
    
    private String cpf;
    private String nome;
    private String data_nascimento;
    private String email;
    private String telefone;
    private int whats;
    private String username;
    private String senha;

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
     * @return the data_nascimento
     */
    public String getData_nascimento() {
        return data_nascimento;
    }

    /**
     * @param data_nascimento the data_nascimento to set
     */
    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the whats
     */
    public int getWhats() {
        return whats;
    }

    /**
     * @param whats the whats to set
     */
    public void setWhats(int whats) {
        this.whats = whats;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void inserir(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho", "root", "junker90");
            
            PreparedStatement pstmt = con.prepareStatement("insert into usuarios (cpf, nome, data_nascimento, email, telefone, whats, username, senha) values (?, ?, ?, ?, ?, ?, ?, ?)");
            
            pstmt.setString(1, this.cpf);
            pstmt.setString(2, this.nome);
            pstmt.setString(3, this.data_nascimento);
            pstmt.setString(4, this.email);
            pstmt.setString(5, this.telefone);
            pstmt.setInt(6, this.whats);
            pstmt.setString(7, this.username);
            pstmt.setString(8, this.senha);
            
            pstmt.execute();
            pstmt.close();
            con.close();
            
        } catch (Exception ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public void atualizar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho", "root", "junker90");
            
            PreparedStatement pstmt = con.prepareStatement("UPDATE usuarios SET cpf=?,nome=?,data_nascimento=?,email=?,telefone=?, whats=?, username=?, senha=?  WHERE cpf=?");
            
            pstmt.setString(1, this.cpf);
            pstmt.setString(2, this.nome);
            pstmt.setString(3, this.data_nascimento);
            pstmt.setString(4, this.email);
            pstmt.setString(5, this.telefone);
            pstmt.setInt(6, this.whats);
            pstmt.setString(7, this.username);
            pstmt.setString(8, this.senha);
            pstmt.setString(9, this.cpf);
            
            pstmt.execute();
            pstmt.close();
            con.close();
            
        } catch (Exception ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
        public void excluir() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho", "root", "junker90");
            
            PreparedStatement pstmt = con.prepareStatement("delete from usuarios where cpf = ?");
            
            pstmt.setString(1, this.cpf);
            
            pstmt.execute();
            pstmt.close();
            con.close();   
            
        } catch (Exception ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        public CadastroUsuario[] selecionar() throws Exception {
            List<CadastroUsuario> lista = new ArrayList<>();
            ResultSet rs = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho", "root", "junker90");

                PreparedStatement pstmt = con.prepareStatement("select * from usuarios");
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    CadastroUsuario usuario = new CadastroUsuario();
                    usuario.setCpf(rs.getString("cpf"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setData_nascimento(rs.getString("data_nascimento"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setTelefone(rs.getString("telefone"));
                    usuario.setWhats(rs.getInt("whats"));
                     

                    lista.add(usuario);
                }
                
                rs.close();
                pstmt.close();
                con.close();
                
            } catch (Exception ex) {
                Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

            return lista.toArray(new CadastroUsuario[0]);
    }
        
        public void selecionarPorCpf() throws Exception {
            ResultSet rs = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho", "root", "junker90");

                PreparedStatement pstmt = con.prepareStatement("select * from usuarios where cpf = ?");
                
                pstmt.setString(1, this.cpf);
                
                rs = pstmt.executeQuery();

                if (rs.next()) {
                    this.setCpf(rs.getString("cpf"));
                    this.setNome(rs.getString("nome"));
                    this.setData_nascimento(rs.getString("data_nascimento"));
                    this.setEmail(rs.getString("email"));
                    this.setTelefone(rs.getString("telefone"));
                    this.setWhats(rs.getInt("whats"));
                    this.setUsername(rs.getString("username"));
                    this.setSenha(rs.getString("senha"));
                }
                
                rs.close();
                pstmt.close();
                con.close();
                
            } catch (Exception ex) {
                Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}