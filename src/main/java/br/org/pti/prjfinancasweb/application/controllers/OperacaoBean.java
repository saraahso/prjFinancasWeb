package br.org.pti.prjfinancasweb.application.controllers;

import br.org.pti.prjfinancasweb.model.service.OperacaoService;
import br.org.pti.prjfinancasweb.model.vo.Cliente;
import br.org.pti.prjfinancasweb.model.vo.ContaBancaria;
import br.org.pti.prjfinancasweb.model.vo.Operacao;
import br.org.pti.prjfinancasweb.model.vo.TipoOperacao;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sara.so
 */
@Named
@ViewScoped
public class OperacaoBean extends AbstractBean {
    
    @Getter
    @Setter
    private String filtro;
    @Getter
    private Operacao operacao;
    @Getter
    private Cliente clienteRemetente;
    @Getter
    private Cliente clienteDestinatario;
    @Getter
    private ContaBancaria contaBancaria;
    @Getter
    private List<Cliente> clientes;
    @Getter
    private List<ContaBancaria> contasRemetente;
    @Getter
    private List<ContaBancaria> contasDestinatario;
    @Getter
    private List<Operacao> operacoes;
    @Inject
    private OperacaoService operacaoService;
    
    public void iniciarLista(){
        this.viewState = ViewState.LISTAR;
        this.operacoes = this.operacaoService.listarTodos();
        
    }
    
    public void iniciarFormulario(String viewState){
        this.viewState = ViewState.valueOf(viewState);
       
        this.contasRemetente = this.operacaoService.listarContas();
        this.contasDestinatario = this.operacaoService.listarContas();
        this.clientes = this.operacaoService.listarTodosClientes();
        this.operacao = new Operacao();
        this.operacao.setTipoOperacao(TipoOperacao.valueOf(viewState));
    }
    
    public void listaOpContaClienteRemetente(){
        this.contasRemetente = this.operacaoService.listarOpContaClienteRemetente(this.operacao
               .getClienteRemetente().getNome());       
    }
    
     public void listaOpContaClienteDestinatario(){
        this.contasDestinatario = this.operacaoService.listarOpContaClienteDestinatario(this.operacao
                .getClienteDestinatario().getNome());
    }  
    
    public void buscar() {
        this.viewState = ViewState.BUSCAR;
        //this.operacoes = this.operacaoService.listarOpClienteRemetente(this.filtro);
    }
    
    public void salvar(){
        this.operacaoService.salvar(operacao);
 
    }
    
}
