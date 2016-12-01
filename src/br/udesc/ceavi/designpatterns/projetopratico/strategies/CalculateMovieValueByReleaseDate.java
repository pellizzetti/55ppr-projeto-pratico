package br.udesc.ceavi.designpatterns.projetopratico.strategies;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.udesc.ceavi.designpatterns.projetopratico.models.product.Movie;

public class CalculateMovieValueByReleaseDate implements CalculateRentalValue<Movie> {

	@Override
	public double calculateValue(Movie aMovie) {
		
		LocalDate todayDate = LocalDate.now();
		Long daysBetween = ChronoUnit.DAYS.between(aMovie.getReleaseDate(), todayDate);
		
		if (daysBetween <= 60) {
			return 12;
		} else if ((daysBetween < 60) && (daysBetween <= 180)) {
			return 8;
		} else if ((daysBetween < 180) && (daysBetween <= 360)) {
			return 6;
		}
		
		return 3;
	}

}
