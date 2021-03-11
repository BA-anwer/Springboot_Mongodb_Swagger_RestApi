package com.formation.film_store.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;


@Document(collection="Film")
public class Film {
    @Id
    @ApiModelProperty(notes ="ID GENERETED AUTOMATICLY",required = true)
	private String id ; 
	private String titre , type , histoire ; 
	
	public Film() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHistoire() {
		return histoire;
	}

	public void setHistoire(String histoire) {
		this.histoire = histoire;
	}

	public Film orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
