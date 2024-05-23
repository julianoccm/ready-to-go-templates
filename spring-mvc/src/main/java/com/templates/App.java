package com.templates;

import com.sun.faces.config.ConfigureListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.faces.webapp.FacesServlet;

@SpringBootApplication
public class App 
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean // Registring the FacesServlet for xhtml files
    public ServletRegistrationBean facesServletRegistration() {
        ServletRegistrationBean<FacesServlet> registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean // Define Sun Faces Context Initializer as True
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
    }

    @Bean // Adding the Servelet Listener to the application
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<>(new ConfigureListener());
    }

    @Bean // Defining a new Rest Template for the application
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
