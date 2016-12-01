package br.udesc.ceavi.designpatterns.projetopratico.dao.concrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.udesc.ceavi.designpatterns.projetopratico.dao.DaoFactory;
import br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces.GenericDao;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.BluRayMovie;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.DvdMovie;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.Movie;

public class MoviePostgresDao implements GenericDao<Movie> {

	private static final String INSERT = "INSERT INTO movies (movie_title, movie_synopsis, movie_release_date, movie_format) VALUES (?, ?, ?, ?)";
	private static final String DELETE = "DELETE FROM movies where movie_id = ?";
	private static final String FIND_ALL = "SELECT * FROM movies";
	private static final String FIND_BY_ID = "SELECT * FROM movies WHERE movie_id = ?";

	public Movie insert(Movie aMovie) throws SQLException {
		Connection c = DaoFactory.getDatabase("Postgres").openConnection();

		PreparedStatement pstmt = c.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

		pstmt.setString(1, aMovie.getTitle());
		pstmt.setString(2, aMovie.getSynopsis());
		pstmt.setDate(3, java.sql.Date.valueOf(aMovie.getReleaseDate()));
		pstmt.setString(4, aMovie.getFormat());

		pstmt.executeUpdate();

		ResultSet rset = pstmt.getGeneratedKeys();

		rset.next();
		Long idGenerated = rset.getLong(1);
		aMovie.setId(idGenerated);

		pstmt.close();
		c.close();

		return aMovie;
	}

	public List<Movie> findAll() throws SQLException {
		ArrayList<Movie> movies = new ArrayList<Movie>();

		Connection c = DaoFactory.getDatabase("Postgres").openConnection();
		PreparedStatement pstmt = c.prepareStatement(FIND_ALL);

		Movie aMovie = null;
		ResultSet rset = pstmt.executeQuery();

		while (rset.next()) {

			Long id = rset.getLong("movie_id");
			String title = rset.getString("movie_title");
			String synopsis = rset.getString("movie_synopsis");
			LocalDate releaseDate = rset.getDate("movie_release_date").toLocalDate();
			String format = rset.getString("movie_format");
			
			if (format.equals("Blu-ray")) {
				aMovie = new BluRayMovie(id, title, synopsis, releaseDate);
			} else if (format.equals("DVD")) {
				aMovie = new DvdMovie(id, title, synopsis, releaseDate);
			}

			movies.add(aMovie);
		}

		pstmt.close();
		c.close();

		return movies;
	}

	public int delete(Movie aMovie) throws SQLException {

		Connection c = DaoFactory.getDatabase("Postgres").openConnection();
		PreparedStatement pstmt = c.prepareStatement(DELETE);

		pstmt.setLong(1, aMovie.getId());

		int rowsAffected = pstmt.executeUpdate();

		pstmt.close();
		c.close();

		return rowsAffected;
	}

	public Movie findById(Long id) throws SQLException {

		Connection c = DaoFactory.getDatabase("Postgres").openConnection();
		PreparedStatement pstmt = c.prepareStatement(FIND_BY_ID);

		pstmt.setLong(1, id);

		Movie aMovie = null;
		ResultSet rset = pstmt.executeQuery();

		while (rset.next()) {

			String title = rset.getString("movie_title");
			String synopsis = rset.getString("movie_synopsis");
			LocalDate releaseDate = rset.getDate("movie_release_date").toLocalDate();
			String format = rset.getString("movie_format");
			
			if (format.equals("Blu-ray")) {
				aMovie = new BluRayMovie(id, title, synopsis, releaseDate);
			} else if (format.equals("DVD")) {
				aMovie = new DvdMovie(id, title, synopsis, releaseDate);
			}
			
		}

		pstmt.close();
		c.close();

		return aMovie;
	}

}
