package br.udesc.ceavi.designpatterns.projetopratico.models;

import java.sql.SQLException;
import java.util.List;

import br.udesc.ceavi.designpatterns.projetopratico.dao.DaoFactory;
import br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces.GenericDao;

public abstract class Movie {

	protected Long id;
	protected String title;
	protected String synopsis;
	protected String format;

	public Movie(String title, String synopsis, String format) {
		this.title = title;
		this.synopsis = synopsis;
		this.format = format;
	}

	public Movie(Long id, String title, String synopsis, String format) {
		this.id = id;
		this.title = title;
		this.synopsis = synopsis;
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

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getFormat() {
		return format;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", synopsis=" + synopsis + ", format=" + format + "]";
	}

	public void insert() throws SQLException {
		dao().insert(this);
	}

	public void delete() throws SQLException {
		dao().delete(this);
	}

	public static List<Movie> findAll() throws SQLException {
		return dao().findAll();
	}

	public static Movie findById(Long id) throws SQLException {
		return dao().findById(id);
	}

	private static GenericDao<Movie> dao() {
		DaoFactory dao = DaoFactory.getDatabase("Postgres");
		return dao.getMovieDao();
	}

}
