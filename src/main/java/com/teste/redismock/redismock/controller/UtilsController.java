package com.teste.redismock.redismock.controller;


import com.fontec.games.GameType;
import com.fontec.megajoker.util.MJI18N;
import com.fontec.megasite.SiteI18n;
import com.google.gdata.client.appsforyourdomain.UserService;
import com.teste.redismock.redismock.model.Jogo;
import com.teste.redismock.redismock.model.Util;
import com.teste.redismock.redismock.service.JogoService;
import com.teste.redismock.redismock.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Locale;

@Validated
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/util")
public class UtilsController {

    @Autowired
    private UtilService service;

    @Autowired
    private JogoService jogoService;


    @GetMapping("/{id}")
    public Util getUtil(@PathVariable String id) throws Exception {
        return service.getById(id);
    }

    @PostMapping
    public void insert(@RequestBody Util newUtil) {
        service.insert(newUtil);
    }

    @GetMapping("/potato")
    public String getPotatoTest() {

        Locale locale = Locale.US;

        Arrays.stream(GameType.values())
                .forEach(gameType -> {
                    jogoService.insertJogo(
                            Jogo.builder()
                                    .id(gameType.getGameNameKey() + "_en-US")
                                    .introduction_text(SiteI18n.getRuleGames(gameType, "1_introduction_text", locale))
                                    .introduction_title(SiteI18n.getRuleGames(gameType, "1_introduction_title", locale))
                                    .description_text(SiteI18n.getRuleGames(gameType, "2_description_text", locale))
                                    .description_title(SiteI18n.getRuleGames(gameType, "2_description_title", locale))
                                    .extraInfo_text(SiteI18n.getRuleGames(gameType, "3_extraInfo_text", locale))
                                    .about_title(SiteI18n.getMain("main_game_about", locale) + gameType.getGameName(locale) + " Online")
                                    .rules_title(SiteI18n.getMain("gameRules", locale) + " " + gameType.getGameName(locale))
                                    .extraInfo_title("<h2>The Game</h2>")
                                    .about_text(
                                            new StringBuilder("<li>" + MJI18N.format(SiteI18n.getMain("main_game_about_item1", locale), gameType.getGameName()) + "</li>")
                                                    .append("<li>")
                                                    .append(MJI18N.format(SiteI18n.getMain("main_game_about_item2", locale), gameType.getGameName()))
                                                    .append("</li>")
                                                    .append("<li>")
                                                    .append(MJI18N.format(SiteI18n.getMain("main_game_about_item3", locale), gameType.getGameName()))
                                                    .append("</li>")
                                                    .append("<li>")
                                                    .append(MJI18N.format(SiteI18n.getMain("main_game_about_item4", locale), gameType.getGameName()))
                                                    .append("</li>")
                                                    .append("<li>")
                                                    .append(MJI18N.format(SiteI18n.getMain("main_game_about_item5", locale), gameType.getGameName()))
                                                    .append("</li>")
                                                    .append("<li>")
                                                    .append(MJI18N.format(SiteI18n.getMain("main_game_about_item6", locale), gameType.getGameName()))
                                                    .append("</li>")
                                                    .append("<li>")
                                                    .append(MJI18N.format(SiteI18n.getMain("main_game_about_item7", locale), gameType.getGameName()))
                                                    .append("</li>")
                                                    .append("<li>")
                                                    .append(MJI18N.format(SiteI18n.getMain("main_game_about_item8", locale), gameType.getGameName()))
                                                    .append("</li>")
                                                    .append("<li>")
                                                    .append(MJI18N.format(SiteI18n.getMain("main_game_about_item9", locale), gameType.getGameName()))
                                                    .append("</li>")
                                                    .toString()
                                    ).build()
                    );
                });

        return "ok";
    }



}
