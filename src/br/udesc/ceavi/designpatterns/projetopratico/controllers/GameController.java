package br.udesc.ceavi.designpatterns.projetopratico.controllers;

import java.sql.SQLException;
import java.util.List;

import br.udesc.ceavi.designpatterns.projetopratico.models.product.Game;

public class GameController {

	protected static GameController instance;

	private GameController() {
	}

	public static synchronized GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}

		return instance;
	}

	public Game insert(Game aGame) throws SQLException {
		if (aGame != null) {
			aGame.insert();
		}
		
		return aGame;
	}

	public void delete(Long id) throws SQLException {
		Game aGame = Game.findById(id);
		
		aGame.delete();
	}

	public List<Game> allGames() throws SQLException {
		return Game.findAll();
	}
}