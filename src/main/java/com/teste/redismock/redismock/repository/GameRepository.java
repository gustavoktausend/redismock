package com.teste.redismock.redismock.repository;

import com.teste.redismock.redismock.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, String> {
}
