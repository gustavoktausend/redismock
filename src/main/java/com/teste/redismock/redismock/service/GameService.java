package com.teste.redismock.redismock.service;

import com.fontec.games.GameCategory;
import com.fontec.games.GameType;
import com.fontec.megajoker.util.MJI18N;
import com.fontec.megasite.SiteI18n;
import com.fontec.megasite.util.StringUtils;
import com.teste.redismock.redismock.model.AboutTextDto;
import com.teste.redismock.redismock.model.Game;
import com.teste.redismock.redismock.model.GameConfig;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class GameService {


    public List<Game> getAllGames() {

        List<String> locales = new ArrayList<>();
        List<Game> allGames = new ArrayList<>();

        locales.add("pt-BR");
        locales.add("en-US");
        locales.add("it-IT");
        locales.add("es-ES");
        locales.add("fr-FR");

        MJI18N.getLocales().forEach(
                locale -> {
                    Arrays.stream(
                            GameType.values()
                    ).forEach(
                            gameType ->
                                allGames.add(
                                        Game.builder()
                                                .id(gameType.getGameNameKey() + "_" + locale.toString().replace("_","-"))
                                                .introduction_text(SiteI18n.getRuleGames(gameType, "1_introduction_text", locale))
                                                .introduction_title(SiteI18n.getRuleGames(gameType, "1_introduction_title", locale))
                                                .description_text(SiteI18n.getRuleGames(gameType, "2_description_text", locale))
                                                .description_title(SiteI18n.getRuleGames(gameType, "2_description_title", locale))
                                                .extraInfo_text(SiteI18n.getRuleGames(gameType, "3_extraInfo_text", locale))
                                                .about_title(SiteI18n.getMain("main_game_about", locale) + gameType.getGameName(locale) + " Online")
                                                .rules_title(SiteI18n.getMain("gameRules", locale) + " " + gameType.getGameName(locale))
                                                .extraInfo_title("The Game")
                                                .main_game_about(
                                                        AboutTextDto.builder()
                                                                .main_game_about_item1(MJI18N.format(SiteI18n.getMain("main_game_about_item1", locale), gameType.getGameName()))
                                                                .main_game_about_item2(MJI18N.format(SiteI18n.getMain("main_game_about_item2", locale), gameType.getGameName()))
                                                                .main_game_about_item3(MJI18N.format(SiteI18n.getMain("main_game_about_item3", locale), gameType.getGameName()))
                                                                .main_game_about_item4(MJI18N.format(SiteI18n.getMain("main_game_about_item4", locale), gameType.getGameName()))
                                                                .main_game_about_item5(MJI18N.format(SiteI18n.getMain("main_game_about_item5", locale), gameType.getGameName()))
                                                                .main_game_about_item6(MJI18N.format(SiteI18n.getMain("main_game_about_item6", locale), gameType.getGameName()))
                                                                .main_game_about_item7(MJI18N.format(SiteI18n.getMain("main_game_about_item7", locale), gameType.getGameName()))
                                                                .main_game_about_item8(MJI18N.format(SiteI18n.getMain("main_game_about_item8", locale), gameType.getGameName()))
                                                                .main_game_about_item9(MJI18N.format(SiteI18n.getMain("main_game_about_item9", locale), gameType.getGameName()))
                                                                .build()
                                                )
                                                .build()
                                )

                    );
                }
        );

        return allGames;
    }

    public List<GameConfig> getGameConfigs(String gameCategory) {

        return StringUtils.isNullOrEmpty(gameCategory) ?
                Arrays.stream(GameType.values())
                        .map(gameType ->
                                GameConfig.builder()
                                        .gameType(gameType)
                                        .gameCategory(gameType.getCategory())
                                        .gameName(gameType.getGameName())
                                        .gameColor(gameType.getGameColor())
                                        .images(MJI18N.getLocales()
                                                .stream()
                                                .map(locale -> gameType.getGameNameKey()
                                                        .toLowerCase()
                                                        .concat("-m_")
                                                        .concat(locale.toString())
                                                        .concat(".png"))
                                                .collect(Collectors.toList()))
                                        .url(gameType.getGameNameKey())
                                        .build()
                        ).collect(Collectors.toList()):
                GameCategory.valueOf(gameCategory).getGames().stream()
                        .map(gameType ->
                                GameConfig.builder()
                                        .gameType(gameType)
                                        .gameCategory(gameType.getCategory())
                                        .gameName(gameType.getGameName())
                                        .gameColor(gameType.getGameColor())
                                        .images(MJI18N.getLocales()
                                                .stream()
                                                .map(locale -> gameType.getGameNameKey()
                                                        .toLowerCase()
                                                        .concat("-m_")
                                                        .concat(locale.toString())
                                                        .concat(".png"))
                                                .collect(Collectors.toList()))
                                        .url(gameType.getGameNameKey())
                                        .build()
                        ).collect(Collectors.toList());
    }

    public List<Game> getAllBundlesByGameType(String gameType) {

        GameType gameTypeValue = GameType.valueOf(gameType);
        return MJI18N.getLocales()
                .stream()
                .map(locale ->
                        Game.builder()
                            .id(gameTypeValue.getGameNameKey() + "_" + locale.toString().replace("_","-"))
                            .introduction_text(SiteI18n.getRuleGames(gameTypeValue, "1_introduction_text", locale))
                            .introduction_title(SiteI18n.getRuleGames(gameTypeValue, "1_introduction_title", locale))
                            .description_text(SiteI18n.getRuleGames(gameTypeValue, "2_description_text", locale))
                            .description_title(SiteI18n.getRuleGames(gameTypeValue, "2_description_title", locale))
                            .extraInfo_text(SiteI18n.getRuleGames(gameTypeValue, "3_extraInfo_text", locale))
                            .about_title(SiteI18n.getMain("main_game_about", locale) + gameTypeValue.getGameName(locale) + " Online")
                            .rules_title(SiteI18n.getMain("gameRules", locale) + " " + gameTypeValue.getGameName(locale))
                            .extraInfo_title("The Game")
                            .main_game_about(
                                    AboutTextDto.builder()
                                            .main_game_about_item1(MJI18N.format(SiteI18n.getMain("main_game_about_item1", locale), gameTypeValue.getGameName()))
                                            .main_game_about_item2(MJI18N.format(SiteI18n.getMain("main_game_about_item2", locale), gameTypeValue.getGameName()))
                                            .main_game_about_item3(MJI18N.format(SiteI18n.getMain("main_game_about_item3", locale), gameTypeValue.getGameName()))
                                            .main_game_about_item4(MJI18N.format(SiteI18n.getMain("main_game_about_item4", locale), gameTypeValue.getGameName()))
                                            .main_game_about_item5(MJI18N.format(SiteI18n.getMain("main_game_about_item5", locale), gameTypeValue.getGameName()))
                                            .main_game_about_item6(MJI18N.format(SiteI18n.getMain("main_game_about_item6", locale), gameTypeValue.getGameName()))
                                            .main_game_about_item7(MJI18N.format(SiteI18n.getMain("main_game_about_item7", locale), gameTypeValue.getGameName()))
                                            .main_game_about_item8(MJI18N.format(SiteI18n.getMain("main_game_about_item8", locale), gameTypeValue.getGameName()))
                                            .main_game_about_item9(MJI18N.format(SiteI18n.getMain("main_game_about_item9", locale), gameTypeValue.getGameName()))
                                            .build()
                            )
                            .build()
                ).collect(Collectors.toList());
    }

}
