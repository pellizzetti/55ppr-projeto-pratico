package br.udesc.ceavi.designpatterns.projetopratico.strategy;

import br.udesc.ceavi.designpatterns.projetopratico.models.product.Game;

public class calculateGameValueByReleaseDate implements calculateRentalValue<Game> {

	@Override
	public double calculate(Game object) {
		return 0;
	}

}
