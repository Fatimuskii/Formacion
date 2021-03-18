package com.formacion.practica3H2.model.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.formacion.practica3H2.model.entity.Song;
import com.formacion.practica3H2.model.repo.ISongRepository;
import com.formacion.practica3H2.model.service.ISongService;

@Service
public class SongServiceImp implements ISongService {

	@Autowired
	private ISongRepository repoSong;

	@Override
	public List<Song> getSongs() {

		return (List<Song>) repoSong.findAll();
	}

	@Override
	public int create(Song song) {

		Song res = repoSong.save(song);
		if (res.getId() > 0) {
			return res.getId();
		}
		return -1;

	}

	@Override
	public Song read(int id) {
		
		Optional<Song> res = repoSong.findById(id);
		if(res.isPresent())
			return res.get();
		return null; 
	}

	@Override
	public void delete(int id) {	
		repoSong.deleteById(id);
	}

	@Override
	public Song update(Song song) {
		Optional<Song> res = repoSong.findById(song.getId());
		if(res.isPresent()) {
			res.get().setName(song.getName());
			res.get().setYear(song.getYear());
			
			repoSong.save(res.get());
			return res.get();
		}
		
		return null;
	}

}
