package com.teste.redismock.redismock.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@Builder
@Getter
@Setter
@JsonDeserialize(builder = Jogo.JogoBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@RedisHash("Jogo")
public class Jogo {

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
    private String about_text;
    private String rules_title;
    private String description_meta;

    @JsonPOJOBuilder(withPrefix = "")
    public static class JogoBuilder {}

}
