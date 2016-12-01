package br.udesc.ceavi.designpatterns.projetopratico.controllers;

import java.sql.SQLException;
import java.util.List;

import br.udesc.ceavi.designpatterns.projetopratico.models.product.Movie;

public class MovieController {

	protected static MovieController instance;

	private MovieController() {
	}

	public static synchronized MovieController getInstance() {
		if (instance == null) {
			instance = new MovieController();
		}

		return instance;
	}

	public Movie insert(Movie aMovie) throws SQLException {
		if (aMovie != null) {
			aMovie.insert();
		}
		
		return aMovie;
	}

	public void delete(Long id) throws SQLException {
		Movie aMovie = Movie.findById(id);
		
		aMovie.delete();
	}

	public List<Movie> allMovies() throws SQLException {
		return Movie.findAll();
	}
}