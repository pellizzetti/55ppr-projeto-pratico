package br.udesc.ceavi.designpatterns.projetopratico.models;

public class BluRayFactory implements FormatFactory {

	public Game createGame() {
		return new BluRayGame();
	}

	public Movie createMovie() {
		return new BluRayMovie();
	}
	
}
