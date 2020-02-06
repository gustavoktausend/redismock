package com.teste.redismock.redismock.service;

import com.teste.redismock.redismock.model.Navegation;
import com.teste.redismock.redismock.repository.NavegationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NavegationService {

    @Autowired
    private NavegationRepository repository;

    public Navegation findById(String id) throws Exception {
        return repository.findById(id).orElseThrow(Exception::new);
    }

    public void insertNavegation(Navegation newNavegation) {
        repository.save(
            Navegation.builder()
                .id(newNavegation.getId())
                .home(newNavegation.getHome())
                .about(newNavegation.getAbout())
                .blog(newNavegation.getBlog())
                .help(newNavegation.getHelp())
                .rules(newNavegation.getRules())
                .build()
        );
    }
}
