package br.udesc.ceavi.designpatterns.projetopratico.models;

import java.sql.SQLException;
import java.util.List;

import br.udesc.ceavi.designpatterns.projetopratico.dao.DaoFactory;
import br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces.GenericDao;

public abstract class Game {

	protected Long id;
	protected String title;
	protected int numberOfPlayers;
	protected String format;
	
	public Game(String title, int numberOfPlayers, String format) {
		this.title = title;
		this.numberOfPlayers = numberOfPlayers;
		this.format = format;
	}
	
	public Game(Long id, String title, int numberOfPlayers, String format) {
		this.id = id;
		this.title = title;
		this.numberOfPlayers = numberOfPlayers;
		this.format = format;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public String getFormat() {
		return format;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", numberOfPlayers=" + numberOfPlayers + ", format=" + format
				+ "]";
	}
	
	public void insert() throws SQLException {
		dao().insert(this);
	}

	public void delete() throws SQLException {
		dao().delete(this);
	}

	public static List<Game> findAll() throws SQLException {
		return dao().findAll();
	}

	public static Game findById(Long id) throws SQLException {
		return dao().findById(id);
	}

	private static GenericDao<Game> dao() {
		DaoFactory dao = DaoFactory.getDatabase("Postgres");
		return dao.getGameDao();
	}

}
