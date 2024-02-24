/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package br.edu.ifrs.controller;

import br.edu.ifrs.modelo.Clientes;
import com.google.gson.Gson;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author noLEAL
 */
@Path("backSeparado")
@RequestScoped
public class webServiceSP {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of webServiceSP
     */
    public webServiceSP() {
    }

    /**
     * Retrieves representation of an instance of br.com.notebruno.burgerback.controle.webServiceSP
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("busca")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String buscaClientes() {
        //TODO return proper representation object
        /*throw new UnsupportedOperationException();*/
          Gson g = new Gson();
        
        Clientes clientes[];
        
        try {
            Clientes c = new Clientes();
            clientes = c.selecionar();
        } catch (Exception e) {
            clientes = new Clientes[0];
        }
        
        return g.toJson(clientes);          
    }
    
    @GET
    @Path("{id}")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getClienteId(@PathParam("id")int id) {
        Gson g = new Gson();
        
        System.out.println("selecionar id =======================================================");
        System.out.println(id); 
        
        Clientes c = new Clientes();
        c.setId(id);
                
        try {
            c.selecionarId();
        } catch (Exception e) {
            c = new Clientes();
        }
        
        return g.toJson(c);
    }
    
    @POST
    @Path("atualizar")
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void atualizar(String content) {
        Gson g = new Gson();
        
        Clientes c = g.fromJson(content, Clientes.class);
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
        
        Clientes c = g.fromJson(content, Clientes.class);
        try {
            c.excluir();
        } catch (Exception e){
        }
    }
    
    @POST
    @Path("cadastro")
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void cadastro(String content) {

        Gson g = new Gson();
        
        System.out.println("Antes");
        System.out.println(content);

        Clientes c = g.fromJson(content, Clientes.class);
        
        System.out.println("Depois");
        System.out.println(c); 

        try {
            c.inserir();
        } catch (Exception e){
        }
    }

//    /**
//     * Método para processar dados enviados pelo formulário via POST
//     * @param nome Nome do cliente
//     * @param dataNascimento Data de nascimento do cliente
//     * @param cpf CPF do cliente
//     * @param rg RG do cliente
//     * @param orgaoEmissor Órgão emissor do RG do cliente
//     * @param sexo Sexo do cliente
//     * @param email Email do cliente
//     * @param telefone Telefone do cliente
//     * @param whats Indica se o cliente possui WhatsApp
//     * @param logradouro Logradouro do cliente
//     * @param numero Número do endereço do cliente
//     * @param bairro Bairro do cliente
//     * @param cidade Cidade do cliente
//     * @param estado Estado do cliente (sigla)
//     * @param cep CEP do cliente
//     * @return JSON representando os dados do cliente após inserção
//     */   
//    @POST
//    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
//    @Path("/cadastro")
//    public String processarCadastro(
//        @FormParam("nome") String nome,
//        @FormParam("dataNascimento") String dataNascimento,
//        @FormParam("cpf") String cpf,
//        @FormParam("rg") String rg,
//        @FormParam("orgaoEmissor") String orgaoEmissor,
//        @FormParam("sexo") String sexo,
//        @FormParam("email") String email,
//        @FormParam("telefone") String telefone,
//        @FormParam("whats") boolean whats,
//        @FormParam("logradouro") String logradouro,
//        @FormParam("numero") String numero,
//        @FormParam("bairro") String bairro,
//        @FormParam("cidade") String cidade,
//        @FormParam("estado") String estado,
//        @FormParam("cep") String cep) {
//        
//        // Crie um objeto Clientes e configure seus atributos com os dados recebidos
//        Clientes x = new Clientes();
//        x.setNome(nome);
//        x.setDataNascimento(Integer.parseInt(dataNascimento));            
//        x.setCpf(cpf);
//        x.setRg(rg);
//        x.setOrgaoEmissor(orgaoEmissor);
//        x.setSexo(sexo);
//        x.setEmail(email);
//        x.setTelefone(telefone);
//        x.setWhats(whats);
//        x.setLogradouro(logradouro);
//        x.setNumero(numero);
//        x.setBairro(bairro);
//        x.setCidade(cidade);
//        x.setEstado(estado);
//        x.setCep(cep);
//        
//        // Realize a inserção ou processamento necessário
//        x.inserir();
//
//        // Converta o objeto para JSON e retorne        
//        Gson g = new Gson();
//                
//        return g.toJson(x);
//    }
}
