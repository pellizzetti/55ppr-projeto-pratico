package br.udesc.ceavi.designpatterns.projetopratico.models;

public abstract class Game extends Media {

	private int numberOfPlayers;
	private String platform;

	public Game(String title, String format) {
		super(title, format, "Game");
	}

	public Game(Long id, String title, String format) {
		super(id, title, format, "Game");
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

}
