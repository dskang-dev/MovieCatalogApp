package com.danielk.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.danielk.moviecatalogservice.model.CatalogItem;
import com.danielk.moviecatalogservice.model.Movie;
import com.danielk.moviecatalogservice.model.UserRating;


@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId, UserRating.class);
		
		
		return ratings.getUserRating()
				.stream()
				.map(r -> {		
					Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + r.getMovieId(), Movie.class);
					return new CatalogItem(movie.getTitle(), movie.getDescription(), r.getRating());
				})
				.collect(Collectors.toList());
		

	}
}
