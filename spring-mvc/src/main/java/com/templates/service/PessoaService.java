package com.templates.service;

import com.templates.entity.Pessoa;
import com.templates.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void save(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }
}
