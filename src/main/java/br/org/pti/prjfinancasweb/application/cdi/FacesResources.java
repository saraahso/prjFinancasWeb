package br.org.pti.prjfinancasweb.application.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 *
 * @author sara.so
 */
@ApplicationScoped
public class FacesResources {
    
    @Produces
    @RequestScoped
    FacesContext produceFacesContext() {
        return FacesContext.getCurrentInstance();
    }
}
