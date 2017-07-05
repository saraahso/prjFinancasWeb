package br.org.pti.prjfinancasweb.model.service;

import br.org.pti.prjfinancasweb.model.resource.ClienteResource;
import br.org.pti.prjfinancasweb.model.resource.ContaBancariaResource;
import br.org.pti.prjfinancasweb.model.vo.Cliente;
import br.org.pti.prjfinancasweb.model.vo.ContaBancaria;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author sara.so
 */

@ApplicationScoped
public class ContaBancariaService {
    
    @Inject
    private ContaBancariaResource contaBancariaResource;
    
    @Inject
    private ClienteResource clienteResource;
    
    public List<ContaBancaria> listarTodos(){
        return this.contaBancariaResource.listarTodos();
    }
    
    public List<ContaBancaria> listarContaClienteRemetente(String nome){
        if (nome != null && !nome.isEmpty()) {
            return this.contaBancariaResource.listarContaClienteRemetente(nome);
        } else {
            return this.listarTodos();
        }
    }
 
    public List<ContaBancaria> listarContaClienteDestinatario(String nome){
        if (nome != null && !nome.isEmpty()) {
            return this.contaBancariaResource.listarContaClienteDestinatario(nome);
        } else {
            return this.listarTodos();
        }
    }
    
    public List<Cliente> listarTodosClientes(){
        return this.clienteResource.listarTodos();
    }
    
    public ContaBancaria buscarPorId(int id){
        return this.contaBancariaResource.buscarPorId(id);
    }
    
    public void salvar(ContaBancaria contaBancaria){
        this.contaBancariaResource.salvar(contaBancaria);
    }
    
    public void alterar(ContaBancaria contaBancaria){
        this.contaBancariaResource.alterar(contaBancaria);
    }
    
    public void remover(int idConta){
        this.contaBancariaResource.remover(idConta);
    }
    
    
}
