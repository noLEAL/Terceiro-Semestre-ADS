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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author noLEAL
 */
public class Clientes {
    
    //[PARAMETROS]
    
    private int id;
    private String nome;
    private int dataNascimento;
    private String cpf;
    private String rg;
    private String orgaoEmissor;
    private String sexo;
    private String email;
    private String telefone;
    private boolean whats;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    
    //[METODOS]
       
    
    public void inserir(){
        try {    
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho" , "root", "");
            
            PreparedStatement pstmt = con.prepareStatement("insert into clientes (nome,data_nascimento, cpf, rg, orgao_emissor, sexo, email, telefone, whats, logradouro, numero, bairro, cidade, estado, cep) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, this.nome);
            pstmt.setInt(2, this.dataNascimento);
            pstmt.setString(3, this.cpf);
            pstmt.setString(4, this.rg);
            pstmt.setString(5, this.orgaoEmissor);
            pstmt.setString(6, this.sexo);
            pstmt.setString(7, this.email);
            pstmt.setString(8, this.telefone);
            pstmt.setBoolean(9, this.whats);
            pstmt.setString(10, this.logradouro);
            pstmt.setString(11, this.numero);
            pstmt.setString(12, this.bairro);
            pstmt.setString(13, this.cidade);
            pstmt.setString(14, this.estado);
            pstmt.setString(15, this.cep);
                
            pstmt.execute();
            pstmt.close();
            
            
        } catch (Exception ex) {
           
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public Clientes[] selecionar() throws Exception{
        List<Clientes> lista = new ArrayList(); 
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho" , "root", "");
                       
            PreparedStatement pstmt = con.prepareStatement("select * from clientes");
            
            ResultSet ResultadoSelect = pstmt.executeQuery();
            
            while(ResultadoSelect.next()){
               Clientes novoCliente = new Clientes();
               novoCliente.setCpf(ResultadoSelect.getString("cpf"));
               novoCliente.setDataNascimento(Integer.parseInt(ResultadoSelect.getString("data_nascimento")));
               novoCliente.setRg(ResultadoSelect.getString("rg"));
               novoCliente.setOrgaoEmissor(ResultadoSelect.getString("orgao_emissor"));
               novoCliente.setSexo(ResultadoSelect.getString("sexo"));
               novoCliente.setEmail(ResultadoSelect.getString("email"));
               novoCliente.setTelefone(ResultadoSelect.getString("telefone"));
               novoCliente.setWhats(ResultadoSelect.getBoolean("whats"));
               novoCliente.setLogradouro(ResultadoSelect.getString("logradouro"));
               novoCliente.setNumero(ResultadoSelect.getString("numero"));
               novoCliente.setBairro(ResultadoSelect.getString("bairro"));
               novoCliente.setCidade(ResultadoSelect.getString("cidade"));
               novoCliente.setEstado(ResultadoSelect.getString("estado"));
               novoCliente.setCep(ResultadoSelect.getString("cep"));

               lista.add(novoCliente);
            }
            ResultadoSelect.close();
            pstmt.close();
                        
        } catch (Exception ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista.toArray(new Clientes [0]); 
    }
    
    
    
    //[GET E SET]
    
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
     * @return the dataNascimento
     */
    public int getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

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
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the orgaoEmissor
     */
    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    /**
     * @param orgaoEmissor the orgaoEmissor to set
     */
    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
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
    public boolean isWhats() {
        return whats;
    }

    /**
     * @param whats the whats to set
     */
    public void setWhats(boolean whats) {
        this.whats = whats;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
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
        
}
