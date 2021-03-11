package com.formation.film_store.filmRepository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.formation.film_store.model.Film;


@Repository
public interface FilmRepository extends MongoRepository<Film, String> {
	
 public List<Film> findByTitre(String titre);
 public List<Film> findByType(String type); 
 
 @Query("{ 'titre' : { $regex: ?0 } , 'type': ?1 }")
 public List<Film> findByRegex(String c ,String typeFilm); 
 
 @Query(value="{$or :[{'titre':?0},{'type':?1}]}",fields ="{'id':1,'titre':1,'type':1}",sort ="{'titre':1}")
 public List<Film> findFilmWithTitleOrType (String titre , String type) ; 
 
}
