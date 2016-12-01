package br.udesc.ceavi.designpatterns.projetopratico.strategies;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.udesc.ceavi.designpatterns.projetopratico.models.product.Game;

public class CalculateGameValueByReleaseDate implements CalculateRentalValue<Game> {

	@Override
	public double calculateValue(Game aGame) {
		
		LocalDate todayDate = LocalDate.now();
		Long daysBetween = ChronoUnit.DAYS.between(aGame.getReleaseDate(), todayDate);
		
		if (daysBetween <= 60) {
			return 10;
		} else if ((daysBetween < 60) && (daysBetween <= 180)) {
			return 9;
		} else if ((daysBetween < 180) && (daysBetween <= 360)) {
			return 7;
		}
		
		return 4;
	}

}
