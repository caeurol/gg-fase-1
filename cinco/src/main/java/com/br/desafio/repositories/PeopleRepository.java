package com.br.desafio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.desafio.models.People;

@Repository
public interface PeopleRepository extends CrudRepository<People, Integer> {

}
