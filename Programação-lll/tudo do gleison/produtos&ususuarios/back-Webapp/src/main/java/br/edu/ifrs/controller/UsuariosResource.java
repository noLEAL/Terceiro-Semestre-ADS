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
    @Path("listar")
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
    
    
    @POST
    @Path("atualizar")
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void atualizar(String content) {
        Gson g = new Gson();
        
        CadastroUsuario c = g.fromJson(content, CadastroUsuario.class);
        try {
            c.atualizar();
        } catch (Exception e){
        }
    }
    
    @POST
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
    @Path("cadastro")
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void cadastro(String content) {
        Gson g = new Gson();
        
        CadastroUsuario c = g.fromJson(content, CadastroUsuario.class);
        try {
            c.inserir();
        } catch (Exception e){
        }
    }
}