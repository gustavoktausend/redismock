package com.teste.redismock.redismock.controller;

import com.teste.redismock.redismock.model.Jogo;
import com.teste.redismock.redismock.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/jogo")
public class JogoController {

    @Autowired
    private JogoService service;

    @GetMapping("/{id}")
    public Jogo get(@PathVariable String id ) throws Exception {
        return service.getById(id);
    }

    @PostMapping
    public void insert(@RequestBody Jogo newJogo) {
        service.insertJogo(newJogo);
    }

}
