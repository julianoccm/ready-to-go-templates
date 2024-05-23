package com.templates.bean;

import com.templates.entity.Pessoa;
import com.templates.service.PessoaService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named(value = "pessoaMB")
@ViewScoped
public class PessoaBean {

    @Autowired
    private PessoaService pessoaService;

    @Getter @Setter
    private List<Pessoa> pessoaList = new ArrayList<>();

    @PostConstruct
    public List<Pessoa> listarPessoas() {
        pessoaList = pessoaService.findAll();
        return pessoaList;
    }
}
