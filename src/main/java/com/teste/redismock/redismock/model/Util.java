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
@JsonDeserialize(builder = Util.UtilBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@RedisHash("Util")
public class Util {

    @Id
    private String id;
    private String page_title;
    private String ranking_title;
    private String play_button;
    private String rules_button;
    private String logo_top;
    private String meta_description;

    @JsonPOJOBuilder(withPrefix = "")
    public static class UtilBuilder {}

}
