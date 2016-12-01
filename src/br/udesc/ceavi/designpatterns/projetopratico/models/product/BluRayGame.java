package br.udesc.ceavi.designpatterns.projetopratico.models.product;

import java.time.LocalDate;

public class BluRayGame extends Game {
	
	public BluRayGame(String title, int numberOfPlayers, LocalDate releaseDate) {
		super(title, numberOfPlayers, releaseDate, "Blu-ray");
	}

	public BluRayGame(Long id, String title, int numberOfPlayers, LocalDate releaseDate) {
		super(id, title, numberOfPlayers, releaseDate, "Blu-ray");
	}

}
