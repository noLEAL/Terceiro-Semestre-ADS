/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package br.edu.ifrs.controller;



import br.edu.ifrs.modelo.CadastroUsuario;
import com.google.gson.Gson;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.PathParam;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;


/**
 * REST Web Service
 *
 * @author Morisko
 */
@Path("usuarios")
@RequestScoped
public class UsuariosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuariosResource
     */
    public UsuariosResource() {
    }

    /**
     * Retrieves representation of an instance of br.edu.ifrs.aula0612.UsuariosResource
     * @return an instance of java.lang.String
     */
    
    
    @GET
    @Path("/listar")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getAll() {
        Gson g = new Gson();
        
        CadastroUsuario arrayUsuarios[];
        
        try {
            CadastroUsuario c = new CadastroUsuario();
            arrayUsuarios = c.selecionar();
        } catch (Exception e) {
            arrayUsuarios = new CadastroUsuario[0];
        }
        
        return g.toJson(arrayUsuarios);
    }
    
    @GET
    @Path("{cpf}")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getUsuarioPorCpf(@PathParam("cpf")String cpf) {
        Gson g = new Gson();
        
        CadastroUsuario c = new CadastroUsuario();
        c.setCpf(cpf);
                
        try {
            c.selecionarPorCpf();
        } catch (Exception e) {
            c = new CadastroUsuario();
        }
        
        return g.toJson(c);
    }
    
    
        

    /**
     * PUT method for updating or creating an instance of UsuariosResource
     * @param content representation for the resource
     */
    
    
    @PUT
    @Path("atualizar")
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void atualizar(String content) {
        Gson g = new Gson();
        
        CadastroUsuario c = g.fromJson(content, CadastroUsuario.class);
        try {
            c.atualizar();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @PUT
    @Path("excluir")
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void excluir(String content) {
        Gson g = new Gson();
        
        CadastroUsuario c = g.fromJson(content, CadastroUsuario.class);
        try {
            c.excluir();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    @POST
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("/cadastro")
    public String processarCadastro(
        @FormParam("cpf") String cpf,
        @FormParam("nome") String nome,
        @FormParam("data_nascimento") String dataNascimento,
        @FormParam("email") String email,
        @FormParam("telefone") String telefone,
        @FormParam("whats") String whats,
        @FormParam("username") String username,
        @FormParam("senha") String senha) 
    {
        
        // Crie um objeto usuario e configure seus atributos com os dados recebidos
        CadastroUsuario usuario = new CadastroUsuario();
        
        usuario.setCpf(cpf);
        usuario.setNome(nome);
        usuario.setData_nascimento(dataNascimento);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);
        usuario.setWhats(Integer. parseInt(whats));
        usuario.setUsername(username);
        usuario.setSenha(senha);
        
        
        // Realize a inserção ou processamento necessário
        usuario.inserir();

        // Converta o objeto para JSON e retorne        
        Gson g = new Gson();
                
        return g.toJson(usuario);
    }
}