package com.formation.film_store.filmController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.formation.film_store.filmService.FilmService;
import com.formation.film_store.model.Film;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;



@Api(description ="Gestion des films")
@RestController
@RequestMapping("/Film_Store_Api")


public class FilmController {
	
	

	
	@Autowired 
	FilmService filmService ; 
	
	
	@ApiOperation(value="ajouter un film ")
	@PostMapping("/addFilm")
	public ResponseEntity<Film> saveFilm(@RequestBody Film film) {
	 Film filmCreated =filmService.createFilm(film);
	  return new ResponseEntity<>(filmCreated,HttpStatus.CREATED); 
	}
	@ApiOperation(value="recuperer touts les films")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/listfilm")
	public ResponseEntity<List<Film>> listFilm(){
		List<Film> list = null;
		try {
			list = filmService.getListFilm();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			return new ResponseEntity<>(list,HttpStatus.OK); 	
	}
	
	@GetMapping("/listfilm/{id}")
	public  ResponseEntity<Object> filmById(
			@ApiParam(value = "Donner ID film", required = true)
			@PathVariable String id){
		Film film = filmService.getFilmById(id); 
			return new ResponseEntity<>(film,HttpStatus.OK); 
		
		
	}
	
	@GetMapping("/FilmTitle/{title}")
	public ResponseEntity<List<Film>> filmByTitle(@PathVariable String title) {
		List<Film> films = filmService.getFilmByTitle(title); 
		return new ResponseEntity<>(films,HttpStatus.OK); 
	}
	
	@GetMapping("/FilmType/{type}")
	public ResponseEntity<List<Film>> filmByType(@PathVariable String type) {
		List<Film> films = filmService.getFilmByType(type); 
		return new ResponseEntity<>(films,HttpStatus.OK); 
	}
	
	@DeleteMapping("/deleteFilm/{id}")
	public ResponseEntity<Void> deleteFilm(@PathVariable String id) {
		filmService.deleteFilmById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;
	}
	
	@PutMapping("/updateFilm/{id}")
	public ResponseEntity<Object> updateFilm(@PathVariable String id,@RequestBody Film filmUpdated){
		Film film = filmService.getFilmById(id);
		filmService.update(filmUpdated);
		return new ResponseEntity<>(film,HttpStatus.OK); 
	}
	
	@GetMapping("/Film/{c}/{type}")
	public ResponseEntity<List<Film>> filmByRegex(@PathVariable String c , @PathVariable String type) {
		List<Film> films = filmService.regex("^"+c.toUpperCase(),type); 
		return new ResponseEntity<>(films,HttpStatus.OK); 
	}
	
	@GetMapping("/Films/{titre}/{type}")
	public ResponseEntity<List<Film>> findFilms(@PathVariable String titre , @PathVariable String type) {
		List<Film> films = filmService.findFilmWithTitleOrType(titre, type) ; 
		return new ResponseEntity<>(films,HttpStatus.OK); 
	}
	
   
    
}
                                                             