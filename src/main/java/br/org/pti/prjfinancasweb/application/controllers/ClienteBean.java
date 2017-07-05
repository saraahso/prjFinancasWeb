package br.org.pti.prjfinancasweb.application.controllers;

import br.org.pti.prjfinancasweb.model.vo.Cliente;
import br.org.pti.prjfinancasweb.model.service.ClienteService;
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
public class ClienteBean extends AbstractBean {

    @Getter
    @Setter
    private String filtro;
    
    @Getter
    private Cliente cliente;

    @Getter
    private List<Cliente> clientes;

    @Inject
    private ClienteService clienteService;

    public void iniciarLista() {
        this.viewState = ViewState.LISTAR;
        this.clientes = this.clienteService.listarTodos();

    }

    public void iniciarFormulario(int id, String viewState) {
        this.viewState = ViewState.valueOf(viewState);

        if (id != 0) {
            this.cliente = this.clienteService.buscarPorId(id);
        } else {
            this.cliente = new Cliente();
        }
    }
    
    public void buscar() {
        this.viewState = ViewState.BUSCAR;
        this.clientes = this.clienteService.listarCliente(this.filtro);
    }

    public void salvar() {
        this.viewState = ViewState.ADICIONAR;
        this.clienteService.salvar(cliente);
        this.facesContext.addMessage(null, new FacesMessage("Cliente Salvo!", null));
    }

    public void alterar() {
        this.viewState = ViewState.EDITAR;
        this.clienteService.alterar(cliente);
        this.facesContext.addMessage(null, new FacesMessage("Cliente Alterado!", null));
    }

    public void remover(int idCliente) {
        this.viewState = ViewState.DELETAR;
        this.clienteService.remover(idCliente);
        this.clientes = this.clienteService.listarCliente(this.filtro);
        this.facesContext.addMessage(null, new FacesMessage("Cliente Removido!", null));
    }

}
