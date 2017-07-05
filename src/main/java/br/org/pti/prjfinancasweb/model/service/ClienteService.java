package br.org.pti.prjfinancasweb.model.service;

import br.org.pti.prjfinancasweb.model.vo.Cliente;
import br.org.pti.prjfinancasweb.model.resource.ClienteResource;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author sara.so
 */
@ApplicationScoped
public class ClienteService {

    @Inject
    private ClienteResource clienteResource;

    public List<Cliente> listarTodos() {
        return this.clienteResource.listarTodos();
    }
    
    public List<Cliente> listarCliente(String nome){
        if(nome != null && !nome.isEmpty()){
            return this.clienteResource.listarCliente(nome);
        } else {
            return this.listarTodos();
        }
    }
    
    public Cliente buscarPorId(int id) {
        return this.clienteResource.buscarPorId(id);
    }
    
    public void  salvar(Cliente cliente){
         this.clienteResource.salvar(cliente);
    }
    
    public void alterar(Cliente cliente){
        this.clienteResource.alterar(cliente);
    }
    
    public void remover(int idCliente){
        this.clienteResource.remover(idCliente);
    }
}
