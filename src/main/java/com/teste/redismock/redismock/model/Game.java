package com.teste.redismock.redismock.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Builder
@Getter
@Setter
@JsonDeserialize(builder = Game.GameBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {

    @Id
    private String id;
    private String introduction_text;
    private String extraInfo_text;
    private String introduction_title;
    private String description_title;
    private String extraInfo_title;
    private String description_text;
    private String game_type;
    private String about_title;
    private AboutTextDto main_game_about;
    private String rules_title;
    private String description_meta;

    @JsonPOJOBuilder(withPrefix = "")
    public static class GameBuilder {}

}
