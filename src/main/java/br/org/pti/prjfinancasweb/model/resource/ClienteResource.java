package br.org.pti.prjfinancasweb.model.resource;

import br.org.pti.prjfinancasweb.model.vo.Cliente;
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
public class ClienteResource {

    private WebTarget target;

    /**
     *
     */
    @PostConstruct
    protected void initialize() {
        final Client client = ClientBuilder.newClient();
        this.target = client.target(UriBuilder.fromUri(
                "http://localhost:8080/financasrest/rest/clientes"));

    }

    /**
     *
     * @return
     */
    public List<Cliente> listarTodos() {
        return this.target
                .path("listar")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Cliente>>() {
                });
    }
    
    public List<Cliente> listarCliente(String nome){
        return this.target
                .path("listarCliente")
                .path("{nome}")
                .resolveTemplate("nome", nome)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Cliente>>() {});
    }

    /**
     *
     * @param id
     * @return
     */
    public Cliente buscarPorId(int id) {
        return this.target
                .path("listar")
                .path("{id}")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get(Cliente.class);
    }

    public Response salvar(Cliente cliente) {

        return this.target
                .path("incluir")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(cliente, MediaType.APPLICATION_JSON));

    }

    public void alterar(Cliente cliente) {

        this.target
                .path("alterar")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(cliente, MediaType.APPLICATION_JSON));
    }
    
    public void remover(int idCliente){
        this.target
                .path("remover")
                .path("{id}")
                .resolveTemplate("id", idCliente)
                .request(MediaType.APPLICATION_JSON)
                .delete();
    }

}
