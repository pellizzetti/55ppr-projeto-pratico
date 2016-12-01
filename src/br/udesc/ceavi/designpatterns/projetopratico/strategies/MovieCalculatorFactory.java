package br.udesc.ceavi.designpatterns.projetopratico.strategies;

import java.util.ArrayList;

import br.udesc.ceavi.designpatterns.projetopratico.models.product.Movie;

public class MovieCalculatorFactory {
	
	protected ArrayList<CalculateRentalValue<Movie>> flyweights;
    
    public MovieCalculatorFactory() {
        flyweights = new ArrayList<CalculateRentalValue<Movie>>();
        
        flyweights.add(new CalculateMovieValueByReleaseDate());
    }
 
    public CalculateMovieValueByReleaseDate getFlyweight(Movie aMovie) {
    	return (CalculateMovieValueByReleaseDate) flyweights.get(0);
    }

}
