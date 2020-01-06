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
@JsonDeserialize(builder = Navegation.NavegationBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@RedisHash("Navegation")
public class Navegation {

    @Id
    private String id;
    private String home;
    private String about;
    private String blog;
    private String help;

    @JsonPOJOBuilder(withPrefix = "")
    public static class NavegationBuilder {}

}
