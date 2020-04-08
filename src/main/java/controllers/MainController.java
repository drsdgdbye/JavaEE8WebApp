package controllers;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class MainController implements Serializable {
    private static final long serialVersionUID = 5280200934714729279L;

    public String showIndexPage() {
        return "/index.xhtml?faces-redirect=true";
    }
}
