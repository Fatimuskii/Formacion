package com.formacion.backAngularRest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.backAngularRest.entity.Hero;

@Repository
public interface IHeroesRepository extends CrudRepository<Hero, Integer> {

}
