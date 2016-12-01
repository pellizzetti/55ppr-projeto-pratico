package br.udesc.ceavi.designpatterns.projetopratico.strategies;

import java.util.ArrayList;

import br.udesc.ceavi.designpatterns.projetopratico.models.product.Game;

public class GameCalculatorFactory {
	
	protected ArrayList<CalculateRentalValue<Game>> flyweights;
    
    public GameCalculatorFactory() {
        flyweights = new ArrayList<CalculateRentalValue<Game>>();
        
        flyweights.add(new CalculateGameValueByReleaseDate());
    }
 
    public CalculateGameValueByReleaseDate getFlyweight(Game aGame) {
    	return (CalculateGameValueByReleaseDate) flyweights.get(0);
    }

}
