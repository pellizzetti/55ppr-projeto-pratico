package br.udesc.ceavi.designpatterns.projetopratico.models.product;

import java.time.LocalDate;

public class DvdGame extends Game {

	public DvdGame(String title, int numberOfPlayers, LocalDate releaseDate) {
		super(title, numberOfPlayers, releaseDate, "DVD");
	}
	
	public DvdGame(Long id, String title, int numberOfPlayers, LocalDate releaseDate) {
		super(id, title, numberOfPlayers, releaseDate, "DVD");
	}
	
}
