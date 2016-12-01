package br.udesc.ceavi.designpatterns.projetopratico.models.product;

import java.time.LocalDate;

public class BluRayFactory implements FormatFactory {

	public Game createGame(String title, int numberOfPlayers, LocalDate releaseDate) {
		return new BluRayGame(title, numberOfPlayers, releaseDate);
	}

	public Movie createMovie(String title, String synopsis, LocalDate releaseDate) {
		return new BluRayMovie(title, synopsis, releaseDate);
	}
	
}
