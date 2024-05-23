package com.templates.bean;

import com.templates.dto.LoginDTO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named(value = "loginMB")
@ViewScoped
public class LoginBean {

    @Getter @Setter
    private LoginDTO loginDTO;

    @PostConstruct
    public void init() {
        loginDTO = new LoginDTO();
    }

    public void logar() throws IOException {
        if(loginDTO.getUsername().isEmpty() && loginDTO.getPassword().isEmpty()) return;

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest req = (HttpServletRequest) context.getRequest();
        HttpSession session = req.getSession(true);

        if (loginDTO.getUsername().equals("admin") && loginDTO.getPassword().equals("admin")) {
            session.setAttribute("SESSION_KEY", loginDTO);
            context.redirect(context.getRequestContextPath() + "index.xhtml");
        }
    }
}
