package com.teste.redismock.redismock.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fontec.games.GameCategory;
import com.fontec.games.GameType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
@JsonDeserialize(builder = GameConfig.GameConfigBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameConfig {

    String gameName;
    GameType gameType;
    String gameColor;
    GameCategory gameCategory;
    String url;
    List<String> images;


    @JsonPOJOBuilder(withPrefix = "")
    public static class GameConfigBuilder {}

}
