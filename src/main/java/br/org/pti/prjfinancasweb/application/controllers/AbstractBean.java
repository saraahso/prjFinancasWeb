package br.org.pti.prjfinancasweb.application.controllers;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import lombok.Getter;

/**
 *
 * @author sara.so
 */
public abstract class AbstractBean implements Serializable {
    
    @Inject
    protected FacesContext facesContext;

    @Getter
    protected ViewState viewState;

    public enum ViewState {
        ADICIONAR, LISTAR, BUSCAR, EDITAR, DELETAR, SAQUE, TRANSFERENCIA, DEPOSITO;
    }
}

