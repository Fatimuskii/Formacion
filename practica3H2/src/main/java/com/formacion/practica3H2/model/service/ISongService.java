package com.formacion.practica3H2.model.service;

import java.util.List;

import com.formacion.practica3H2.model.entity.Song;

public interface ISongService {

	public List<Song> getSongs();

	public int create(Song song);

	public Song read(int id);

	public void delete(int id);

	public Song update(Song song);

}
