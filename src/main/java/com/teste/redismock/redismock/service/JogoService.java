package com.teste.redismock.redismock.service;

import com.teste.redismock.redismock.model.Jogo;
import com.teste.redismock.redismock.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JogoService {

    @Autowired
    private JogoRepository repository;


    public void insertJogo(Jogo newJogo) {

        repository.save(
                Jogo.builder()
                        .id(newJogo.getId())
                        .introduction_text(newJogo.getIntroduction_text())
                        .extraInfo_text(newJogo.getExtraInfo_text())
                        .introduction_title(newJogo.getIntroduction_title())
                        .description_title(newJogo.getDescription_title())
                        .extraInfo_title(newJogo.getExtraInfo_title())
                        .description_text(newJogo.getDescription_text())
                        .about_title(newJogo.getAbout_title())
                        .about_text(newJogo.getAbout_text())
                        .build()
        );
    }

    public Jogo getById(String id) throws Exception {
        return repository.findById(id).orElseThrow(Exception::new);
    }

}
