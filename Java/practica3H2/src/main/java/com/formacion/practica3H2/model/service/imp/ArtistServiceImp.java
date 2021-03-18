package com.formacion.practica3H2.model.service.imp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.practica3H2.model.entity.Artist;
import com.formacion.practica3H2.model.repo.IArtistRepository;
import com.formacion.practica3H2.model.service.IArtistService;

@Service
public class ArtistServiceImp implements IArtistService{

	@Autowired
	private IArtistRepository repoArtist;
	
	@Override
	public List<Artist> getArtists() {
	
		return (List<Artist>) repoArtist.findAll();
	}

	// This method is tagged with @Transactional, 
	//meaning that any failure causes the entire operation to roll back to its previous state 
	//and to re-throw the original exception.
	@Override
	@Transactional 
	public int create(Artist artist) {
		Artist res = repoArtist.save(artist);
		if(res.getId()>0) {
			return res.getId();
		}
		return -1;
	}

	@Override
	public Artist read(int id) {
		Optional<Artist> res = repoArtist.findById(id);
		if(res.isPresent())
			return res.get();
		return null; 
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repoArtist.deleteById(id);
	}

	@Override
	@Transactional 
	public Artist update(Artist artist) {
		Optional<Artist> res = repoArtist.findById(artist.getId());
		if(res.isPresent()) {
			res.get().setFullName(artist.getFullName());
			res.get().setRealName(artist.getRealName());
			
			repoArtist.save(res.get());
			return res.get();
		}
		
		return null;
	}

}
