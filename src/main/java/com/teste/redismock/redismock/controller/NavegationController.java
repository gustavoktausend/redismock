package com.teste.redismock.redismock.controller;

import com.teste.redismock.redismock.model.Navegation;
import com.teste.redismock.redismock.service.NavegationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/navegation")
public class NavegationController {

    @Autowired
    private NavegationService service;

    @GetMapping("/{id}")
    public Navegation getById(@PathVariable String id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public void insert(@RequestBody Navegation newNavegation) {
        service.insertNavegation(newNavegation);
    }


}
