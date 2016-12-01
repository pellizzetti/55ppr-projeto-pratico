package br.udesc.ceavi.designpatterns.projetopratico.dao.concrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.udesc.ceavi.designpatterns.projetopratico.dao.DaoFactory;
import br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces.GenericDao;
import br.udesc.ceavi.designpatterns.projetopratico.models.BluRayGame;
import br.udesc.ceavi.designpatterns.projetopratico.models.DvdGame;
import br.udesc.ceavi.designpatterns.projetopratico.models.Game;

public class GamePostgresDao implements GenericDao<Game> {

	private static final String INSERT = "INSERT INTO games (game_title, game_number_players, game_format) VALUES (?, ?, ?)";
	private static final String DELETE = "DELETE FROM games where game_id = ?";
	private static final String FIND_ALL = "SELECT * FROM games";
	private static final String FIND_BY_ID = "SELECT * FROM games WHERE game_id = ?";

	public Game insert(Game aGame) throws SQLException {
		Connection c = DaoFactory.getDatabase("Postgres").openConnection();

		PreparedStatement pstmt = c.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

		pstmt.setString(1, aGame.getTitle());
		pstmt.setInt(2, aGame.getNumberOfPlayers());
		pstmt.setString(3, aGame.getFormat());

		pstmt.executeUpdate();

		ResultSet rset = pstmt.getGeneratedKeys();

		rset.next();
		Long idGenerated = rset.getLong(1);
		aGame.setId(idGenerated);

		pstmt.close();
		c.close();

		return aGame;
	}

	public List<Game> findAll() throws SQLException {
		ArrayList<Game> games = new ArrayList<Game>();

		Connection c = DaoFactory.getDatabase("Postgres").openConnection();
		PreparedStatement pstmt = c.prepareStatement(FIND_ALL);

		Game aGame = null;
		ResultSet rset = pstmt.executeQuery();

		while (rset.next()) {

			Long id = rset.getLong("game_id");
			String title = rset.getString("game_title");
			int numberOfPlayers = rset.getInt("game_number_players");
			String format = rset.getString("game_format");
			
			if (format.equals("Blu-ray")) {
				aGame = new BluRayGame(id, title, numberOfPlayers);
			} else if (format.equals("DVD")) {
				aGame = new DvdGame(id, title, numberOfPlayers);
			}

			games.add(aGame);
		}

		pstmt.close();
		c.close();

		return games;
	}

	public int delete(Game aGame) throws SQLException {

		Connection c = DaoFactory.getDatabase("Postgres").openConnection();
		PreparedStatement pstmt = c.prepareStatement(DELETE);

		pstmt.setLong(1, aGame.getId());

		int rowsAffected = pstmt.executeUpdate();

		pstmt.close();
		c.close();

		return rowsAffected;
	}

	public Game findById(Long id) throws SQLException {

		Connection c = DaoFactory.getDatabase("Postgres").openConnection();
		PreparedStatement pstmt = c.prepareStatement(FIND_BY_ID);

		pstmt.setLong(1, id);

		Game aGame = null;
		ResultSet rset = pstmt.executeQuery();

		while (rset.next()) {

			String title = rset.getString("game_title");
			int numberOfPlayers = rset.getInt("game_number_players");
			String format = rset.getString("game_format");
			
			if (format.equals("Blu-ray")) {
				aGame = new BluRayGame(id, title, numberOfPlayers);
			} else if (format.equals("DVD")) {
				aGame = new DvdGame(id, title, numberOfPlayers);
			}
			
		}

		pstmt.close();
		c.close();

		return aGame;
	}

}
