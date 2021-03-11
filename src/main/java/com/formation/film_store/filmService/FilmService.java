package com.formation.film_store.filmService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.formation.film_store.filmRepository.FilmRepository;
import com.formation.film_store.model.Film;

@Service
public class FilmService  {
	
	@Autowired 
	FilmRepository filmRepository ;
	
	// Creation film 
	public Film createFilm(Film film) {
		return filmRepository.insert(film); 
		
	}
	
	// Consultation list films database
	public List<Film> getListFilm() {
			 return filmRepository.findAll();
		}
	
	
	// Consultation film by ID 
	public Film getFilmById(String id){
			 Film film =  filmRepository.findById(id).get(); 
			return film ; 
		}
		
		
	
	
	// Consultation film by Title
	public List<Film> getFilmByTitle(String title) {
		return filmRepository.findByTitre(title);
	}
	
	// Consultation film by Type
		public List<Film> getFilmByType(String type) {
			return filmRepository.findByType(type);
		}
	
	//Suppression film by ID
	public void deleteFilmById(String id) {
		 filmRepository.deleteById(id);
	}
	
	public void update(Film film ) {
		filmRepository.save(film);
	}
	
	public List<Film> regex(String c ,String typeFilm){
		 return filmRepository.findByRegex(c,typeFilm);
			
	}
	
	public List<Film> findFilmWithTitleOrType(String titre , String type){
		return filmRepository.findFilmWithTitleOrType(titre, type); 
	}
	
	
	
	

}
