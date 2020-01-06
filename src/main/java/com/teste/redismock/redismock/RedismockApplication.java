package com.teste.redismock.redismock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;


@SpringBootApplication
public class RedismockApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedismockApplication.class, args);
	}

}
