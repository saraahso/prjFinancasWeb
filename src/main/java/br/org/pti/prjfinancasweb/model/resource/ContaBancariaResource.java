package br.org.pti.prjfinancasweb.model.resource;

import br.org.pti.prjfinancasweb.model.vo.ContaBancaria;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author sara.so
 */
@Dependent
public class ContaBancariaResource {

    private WebTarget target;

    /**
     *
     */
    @PostConstruct
    protected void initialize() {
        final Client client = ClientBuilder.newClient();
        this.target = client.target(UriBuilder.fromUri(
                "http://localhost:8080/financasrest/rest/contas"));
    }

    public List<ContaBancaria> listarTodos() {
        return this.target
                .path("listar")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<ContaBancaria>>() {
                });
    }

    public ContaBancaria buscarPorId(int id) {
        return this.target
                .path("listar")
                .path("{id}")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get(ContaBancaria.class);
    }
    
    public List<ContaBancaria> buscarContaClientePorId(int idCliente){
        return this.target
                .path("listarContaClientePorId")
                .path("{id}")
                .resolveTemplate("id", idCliente)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<ContaBancaria>>() {});
    }

    public List<ContaBancaria> listarContaClienteRemetente(String nome) {
        return this.target
                .path("listarContaClienteRemetente")
                .path("{nome}")
                .resolveTemplate("nome", nome)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<ContaBancaria>>() {});
    }
 
    public List<ContaBancaria> listarContaClienteDestinatario(String nome) {
        return this.target
                .path("listarContaClienteDestinatario")
                .path("{nome}")
                .resolveTemplate("nome", nome)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<ContaBancaria>>() {});
    }
    

    public void salvar(ContaBancaria contaBancaria) {

        this.target
                .path("incluir")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(contaBancaria, MediaType.APPLICATION_JSON));
    }

    public void alterar(ContaBancaria contaBancaria) {
        this.target
                .path("alterar")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(contaBancaria, MediaType.APPLICATION_JSON));
    }

    public void remover(int idConta) {
        this.target
                .path("remover")
                .path("{id}")
                .resolveTemplate("id", idConta)
                .request(MediaType.APPLICATION_JSON)
                .delete();
    }
}
