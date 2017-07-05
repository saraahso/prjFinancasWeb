package br.org.pti.prjfinancasweb.model.resource;

import br.org.pti.prjfinancasweb.model.vo.Operacao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author sara.so
 */

@Dependent
public class OperacaoResource {
    
    private WebTarget target;
    
    @PostConstruct
     protected void initialize(){
         final Client client = ClientBuilder.newClient();
        this.target = client.target(UriBuilder.fromUri(
                "http://localhost:8080/financasrest/rest/operacoes"));
     }
     
     /**
     *
     * @return
     */
    public List<Operacao> listarTodos() {
        return this.target
                .path("listar")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Operacao>>() {
                });
    }
   
     
    public List<Operacao> listarOpClienteRemetente(String nome) {
        return this.target
                .path("listarOpClienteRemetente")
                .path("{nome}")
                .resolveTemplate("nome", nome)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Operacao>>() {});
    }
    
    public List<Operacao> listarOpContaBancaria(int contaBancaria) {
        return this.target
                .path("listarOpContaBancaria")
                .path("{contaBancaria}")
                .resolveTemplate("contaBancaria", contaBancaria)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Operacao>>() {});
    }
    
    
    public Response salvar(Operacao operacao){
        return this.target
                .path("incluir")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(operacao, MediaType.APPLICATION_JSON));
                
    }
    
    
    
}
