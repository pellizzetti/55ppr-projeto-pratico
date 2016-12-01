package br.udesc.ceavi.designpatterns.projetopratico.models;

public class DvdGame extends Game {

	public DvdGame(String title, int numberOfPlayers) {
		super(title, numberOfPlayers, "DVD");
	}
	
	public DvdGame(Long id, String title, int numberOfPlayers) {
		super(id, title, numberOfPlayers, "DVD");
	}
	
}
