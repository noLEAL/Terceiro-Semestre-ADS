/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package br.edu.ifrs.aula0612;

import br.edu.ifrs.modelo.Camisas;
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
import jakarta.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author SAMSUNG
 */
@Path("camisas")
@RequestScoped
public class CamisasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CamisasResource
     */
    public CamisasResource() {
    }

    /**
     * Retrieves representation of an instance of br.edu.ifrs.aula0612.CamisasResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("all")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getAll() {
        Gson g = new Gson();
        
        Camisas camisas[];
        
        try {
            Camisas c = new Camisas();
            camisas = c.selecionar();
        } catch (Exception e) {
            camisas = new Camisas[0];
        }
        
        return g.toJson(camisas);
    }
    
    /**
     * Retrieves representation of an instance of br.edu.ifrs.aula0612.CamisasResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getCamisaById(@PathParam("id")int id) {
        Gson g = new Gson();
        
        Camisas c = new Camisas();
        c.setId(id);
                
        try {
            c.selecionarId();
        } catch (Exception e) {
            c = new Camisas();
        }
        
        return g.toJson(c);
    }

    /**
     * PUT method for updating or creating an instance of CamisasResource
     * @param content representation for the resource
     */
    @PUT
    @Path("inserir")
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void inserir(String content) {
        Gson g = new Gson();
        
        Camisas c = g.fromJson(content, Camisas.class);
        try {
            c.inserir();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * PUT method for updating or creating an instance of CamisasResource
     * @param content representation for the resource
     */
    @PUT
    @Path("atualizar")
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void atualizar(String content) {
        Gson g = new Gson();
        
        Camisas c = g.fromJson(content, Camisas.class);
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
        
        Camisas c = g.fromJson(content, Camisas.class);
        try {
            c.excluir();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
