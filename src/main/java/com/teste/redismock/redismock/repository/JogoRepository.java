package com.teste.redismock.redismock.repository;

import com.teste.redismock.redismock.model.Jogo;
import org.springframework.data.repository.CrudRepository;

public interface JogoRepository extends CrudRepository<Jogo, String> {
}
