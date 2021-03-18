package com.formacion.practica3H2.model.service;

import java.util.List;

import com.formacion.practica3H2.model.entity.Artist;

public interface IArtistService {

	public List<Artist> getArtists();

	public int create(Artist artist);

	public Artist read(int id);

	public void delete(int id);

	public Artist update(Artist artist);
}
