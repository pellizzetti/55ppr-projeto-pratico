package br.udesc.ceavi.designpatterns.projetopratico.models;

public class BluRayGame extends Game {
	
	public BluRayGame(String title, int numberOfPlayers) {
		super(title, numberOfPlayers, "Blu-ray");
	}

	public BluRayGame(Long id, String title, int numberOfPlayers) {
		super(id, title, numberOfPlayers, "Blu-ray");
	}

}
