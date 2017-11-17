package app.utils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class DefaultController {
    protected void setMessage(FacesMessage.Severity type, String title, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(type, title, message));
    }
}
