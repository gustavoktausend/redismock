package com.teste.redismock.redismock.repository;

import com.teste.redismock.redismock.model.General;
import org.springframework.data.repository.CrudRepository;

public interface GeneralRepository extends CrudRepository<General, String> {
}
