package com.danielk.movieinfoservice.models;

public class Movie {

	String movieId;
	String title;
	
	public Movie() {}

	public Movie(String movieId, String title) {
		this.movieId = movieId;
		this.title = title;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	};
	
	
}
