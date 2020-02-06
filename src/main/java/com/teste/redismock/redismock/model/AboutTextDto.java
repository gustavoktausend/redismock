package com.teste.redismock.redismock.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

@JsonIgnoreProperties(ignoreUnknown = true)
public class AboutTextDto {

    String main_game_about_item1;
    String main_game_about_item2;
    String main_game_about_item3;
    String main_game_about_item4;
    String main_game_about_item5;
    String main_game_about_item6;
    String main_game_about_item7;
    String main_game_about_item8;
    String main_game_about_item9;



    @JsonPOJOBuilder(withPrefix = "")
    public static class AboutTextDtoBuilder {}
}
