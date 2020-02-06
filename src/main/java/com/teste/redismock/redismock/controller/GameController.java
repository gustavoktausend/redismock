package com.teste.redismock.redismock.controller;

import com.fontec.games.GameType;
import com.teste.redismock.redismock.model.Game;
import com.teste.redismock.redismock.model.GameConfig;
import com.teste.redismock.redismock.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/game")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping
    public List<Game> getAll() {
        return service.getAllGames();
    }

    @GetMapping("/types")
    public List<GameType> getGameTypes() {
        return Arrays.asList(GameType.values());
    }

    @GetMapping("/config")
    public List<GameConfig> getAllGameConfigs(@RequestParam(required = false) String gameCategory) {
        return service.getGameConfigs(gameCategory);
    }

}
