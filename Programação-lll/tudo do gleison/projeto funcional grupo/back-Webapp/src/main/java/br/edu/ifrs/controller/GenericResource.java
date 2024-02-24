/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package br.edu.ifrs.controller;
import com.google.gson.Gson;
import br.edu.ifrs.modelo.Produto;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import static java.lang.Float.parseFloat;


/**
 * REST Web Service
 *
 * @author mauri
 */
@Path("generic")
@RequestScoped
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of br.edu.ifrs.controller.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/busca")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String buscaProduto() {
        //TODO return proper representation object
        /*throw new UnsupportedOperationException();*/
          Gson g = new Gson();
        
        Produto produtos[];
        
        try {
            Produto c = new Produto();
            produtos = c.selecionar();
        } catch (Exception e) {
            produtos = new Produto[0];
        }
        
        return g.toJson(produtos);
        
    }
    
    @GET
    @Path("{id}")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getCamisaById(@PathParam("id")int id) {
        Gson g = new Gson();
        
        Produto c = new Produto();
        c.setId(id);
                
        try {
            c.selecionarId();
        } catch (Exception e) {
            c = new Produto();
        }
        
        return g.toJson(c);
    }

    /**
     * POST method for updating or creating an instance of GenericResource
     * @param nome
     * @param descricao
     * @param unidade
     * @param preco
     * @param content representation for the resource
     * @return 
     */
    @POST
    @Path("/cadastro")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String cadastraProduto(
        @FormParam("nome") String nome,
        @FormParam("descricao") String descricao,
        @FormParam("unidade") String unidade,
        @FormParam("preco") String preco){
        
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setUnidade(unidade);
        produto.setPreco(parseFloat(preco)); 
        
        
        produto.inserir();
        Gson g = new Gson();
        
        return g.toJson(produto);
    }
    
    @PUT
    @Path("/atualizar")
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void atualizar(String content) {
        Gson g = new Gson();
        
        Produto c = g.fromJson(content, Produto.class);
        try {
            c.atualizar();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
