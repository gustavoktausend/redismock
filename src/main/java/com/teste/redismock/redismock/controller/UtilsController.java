package com.teste.redismock.redismock.controller;


import com.teste.redismock.redismock.model.Util;
import com.teste.redismock.redismock.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/util")
public class UtilsController {

    @Autowired
    private UtilService service;


    @GetMapping("/{id}")
    public Util getUtil(@PathVariable String id) throws Exception {
        return service.getById(id);
    }

    @PostMapping
    public void insert(@RequestBody Util newUtil) {
        service.insert(newUtil);
    }



}
