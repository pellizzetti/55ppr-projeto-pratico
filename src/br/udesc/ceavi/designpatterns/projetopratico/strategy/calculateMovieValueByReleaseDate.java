package br.udesc.ceavi.designpatterns.projetopratico.strategy;

import br.udesc.ceavi.designpatterns.projetopratico.models.product.Movie;

public class calculateMovieValueByReleaseDate implements calculateRentalValue<Movie> {

	@Override
	public double calculate(Movie object) {
		return 0;
	}

}
