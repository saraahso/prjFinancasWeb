package br.org.pti.prjfinancasweb.model.service;

import br.org.pti.prjfinancasweb.application.controllers.AbstractBean;
import br.org.pti.prjfinancasweb.model.resource.ClienteResource;
import br.org.pti.prjfinancasweb.model.resource.ContaBancariaResource;
import br.org.pti.prjfinancasweb.model.resource.OperacaoResource;
import br.org.pti.prjfinancasweb.model.vo.Cliente;
import br.org.pti.prjfinancasweb.model.vo.ContaBancaria;
import br.org.pti.prjfinancasweb.model.vo.Operacao;
import java.math.BigDecimal;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author sara.so
 */
@ApplicationScoped
public class OperacaoService {
    
    @Inject
    private OperacaoResource operacaoResource;
    
    @Inject
    private ClienteResource clienteResource;
    
    @Inject
    private ContaBancariaResource contaBancariaResource;
        
    public List<Operacao> listarTodos(){
        return this.operacaoResource.listarTodos();
    }
    
    public List<Operacao> listarOpClienteRemetente(String nome, int contaBancaria){
        if (nome != null && !nome.isEmpty()) {
            return this.operacaoResource.listarOpClienteRemetente(nome);
        //} else if (contaBancaria != null && !contaBancaria.isEmpty()){
         //   return this.operacaoResource.listarOpClienteRemetente(String.valueOf(contaBancaria));
        } else {
            return this.listarTodos();
        }
    }
        
    public List<ContaBancaria> listarOpContaClienteRemetente(String nome ){
            return this.contaBancariaResource.listarContaClienteRemetente(nome);
    }
    
    public List<ContaBancaria> listarOpContaClienteDestinatario(String nome ){
            return this.contaBancariaResource.listarContaClienteDestinatario(nome);
    }
    
    public List<ContaBancaria> listarContas(){
        return this.contaBancariaResource.listarTodos();
    }
    
    public List<Cliente> listarTodosClientes(){
        return this.clienteResource.listarTodos();
    }
  
    public void salvar(Operacao operacao){
        this.operacaoResource.salvar(operacao);    
    }
    
}
