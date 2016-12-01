package br.udesc.ceavi.designpatterns.projetopratico.models.product;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.udesc.ceavi.designpatterns.projetopratico.dao.DaoFactory;
import br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces.GenericDao;
import br.udesc.ceavi.designpatterns.projetopratico.strategies.GameCalculatorFactory;

public abstract class Game {

	protected Long id;
	protected String title;
	protected LocalDate releaseDate;
	protected int numberOfPlayers;
	//protected CalculateRentalValue<Game> valueStrategy;
	protected GameCalculatorFactory strategyFactory;
	
	protected String format;
	
	public Game(String title, int numberOfPlayers, LocalDate releaseDate, String format) {
		this.title = title;
		this.numberOfPlayers = numberOfPlayers;
		this.releaseDate = releaseDate;
		this.format = format;
		
		//this.valueStrategy = new CalculateGameValueByReleaseDate();
		this.strategyFactory = new GameCalculatorFactory();
	}
	
	public Game(Long id, String title, int numberOfPlayers, LocalDate releaseDate, String format) {
		this.id = id;
		this.title = title;
		this.numberOfPlayers = numberOfPlayers;
		this.releaseDate = releaseDate;
		this.format = format;
		
		//this.valueStrategy = new CalculateGameValueByReleaseDate();
		this.strategyFactory = new GameCalculatorFactory();
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

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
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
	
	public double getValue() {
		//return valueStrategy.calculateValue(this);
		return strategyFactory.getFlyweight(this).calculateValue(this);
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", releaseDate=" + releaseDate + ", numberOfPlayers="
				+ numberOfPlayers + ", format=" + format + ", value=" + getValue() + "]";
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
