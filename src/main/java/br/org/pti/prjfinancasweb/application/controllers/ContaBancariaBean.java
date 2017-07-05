package br.org.pti.prjfinancasweb.application.controllers;

import br.org.pti.prjfinancasweb.model.service.ContaBancariaService;
import br.org.pti.prjfinancasweb.model.vo.Cliente;
import br.org.pti.prjfinancasweb.model.vo.ContaBancaria;
import java.util.List;
import javax.faces.application.FacesMessage;
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
public class ContaBancariaBean extends AbstractBean {

    @Getter
    @Setter
    private String filtro;
    
    @Getter
    private ContaBancaria contaBancaria;
    
    @Getter
    private List<Cliente> clientes;
    @Getter
    private List<ContaBancaria> contasBancarias;
    
    @Inject
    private ContaBancariaService contaBancariaService;
    
    public void iniciarLista() {
        this.viewState = ViewState.LISTAR;
        this.contasBancarias = this.contaBancariaService.listarTodos();
        
    }
    
    public void iniciarFormulario(int id, String viewState) {
        this.viewState = ViewState.valueOf(viewState);
        this.clientes = this.contaBancariaService.listarTodosClientes();
        
        if (id != 0) {
            this.contaBancaria = this.contaBancariaService.buscarPorId(id);
        } else {
            this.contaBancaria = new ContaBancaria();
        }
    }
    
    public void buscar() {
        this.viewState = ViewState.BUSCAR;
        this.contasBancarias = this.contaBancariaService.listarContaClienteRemetente(this.filtro);
    }
    
    public void salvar() {
        this.viewState = ViewState.ADICIONAR;
        this.contaBancariaService.salvar(contaBancaria);
        this.facesContext.addMessage(null, new FacesMessage("Conta Bancaria Salva!", null));
    }
    
    public void alterar() {
        this.viewState = ViewState.EDITAR;
        this.contaBancariaService.alterar(contaBancaria);
        this.facesContext.addMessage(null, new FacesMessage("Conta Bancaria Alterada!", null));
    }
    
    public void remover(int idConta) {
        this.viewState = ViewState.DELETAR;
        this.contaBancariaService.remover(idConta);
        this.contasBancarias = this.contaBancariaService.listarContaClienteRemetente(this.filtro);
        this.facesContext.addMessage(null, new FacesMessage("Conta Bancaria Removida!", null));
    }
}
