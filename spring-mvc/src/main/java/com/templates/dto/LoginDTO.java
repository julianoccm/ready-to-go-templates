package com.templates.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.servlet.http.HttpSessionBindingListener;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class LoginDTO implements HttpSessionBindingListener {
    private String username;
    private String password;
}
