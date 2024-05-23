package com.templates.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RedirectController {

    @GetMapping(value = "") // Redirect to entry point of the application
    public String baseUrlRedirect(HttpServletRequest request) {
        return "redirect:" + request.getRequestURL().append("index.xhtml").toString();
    }
}