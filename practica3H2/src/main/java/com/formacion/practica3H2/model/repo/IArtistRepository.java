package com.formacion.practica3H2.model.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.practica3H2.model.entity.Artist;

@Repository
public interface IArtistRepository extends CrudRepository<Artist, Integer> {

}
