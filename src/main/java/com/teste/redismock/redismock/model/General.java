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
@JsonDeserialize(builder = General.GeneralBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@RedisHash("General")
public class General {

    @Id
    private String id;
    private String title;
    private String ranking;
    private String play;
    private String rules;

    @JsonPOJOBuilder(withPrefix = "")
    public static class GeneralBuilder {}

}
