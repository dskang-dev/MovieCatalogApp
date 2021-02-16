package com.danielk.moviecatalogservice.model;

public class Movie {

	String movieId;
	String description;
	String title;
	
	public Movie() {}

	public Movie(String movieId, String desc, String title) {
		this.movieId = movieId;
		this.description = desc;
		this.title = title;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}
}
