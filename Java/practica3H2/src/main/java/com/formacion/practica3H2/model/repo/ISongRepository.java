package com.formacion.practica3H2.model.repo;

import org.springframework.data.repository.CrudRepository;

import com.formacion.practica3H2.model.entity.Song;

public interface ISongRepository extends CrudRepository<Song, Integer> {

}
