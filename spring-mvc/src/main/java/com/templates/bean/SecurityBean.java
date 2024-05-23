package com.templates.bean;

import com.templates.dto.LoginDTO;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named(value = "securityMB")
public class SecurityBean {

    public void isSecurityOk() throws IOException {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession(true);

        LoginDTO loginDTO = (LoginDTO) session.getAttribute("SESSION_KEY");

        if (loginDTO == null) {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "login.xhtml");
        }
    }
}
