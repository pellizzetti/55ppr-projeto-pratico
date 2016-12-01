package br.udesc.ceavi.designpatterns.projetopratico.models;

public class BluRayFactory implements FormatFactory {

	public Game createGame(String title, int numberOfPlayers) {
		return new BluRayGame(title, numberOfPlayers);
	}

	public Movie createMovie(String title, String synopsis) {
		return new BluRayMovie(title, synopsis);
	}
	
}
