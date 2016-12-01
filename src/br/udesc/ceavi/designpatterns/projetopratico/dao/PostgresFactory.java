package br.udesc.ceavi.designpatterns.projetopratico.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.udesc.ceavi.designpatterns.projetopratico.dao.concrete.CustomerPostgresDao;
import br.udesc.ceavi.designpatterns.projetopratico.dao.concrete.GamePostgresDao;
import br.udesc.ceavi.designpatterns.projetopratico.dao.concrete.MoviePostgresDao;
import br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces.GenericDao;
import br.udesc.ceavi.designpatterns.projetopratico.models.customer.Customer;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.Game;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.Movie;

public class PostgresFactory extends DaoFactory {

	private static final String DRIVER   = "org.postgresql.Driver";
	private static final String DATABASE = "55ppr";
	private static final String URL      = "localhost:4000/";
	private static final String LINK     = "jdbc:postgresql://" + URL + DATABASE;
	private static final String USER     = "postgres";
	private static final String PASSWORD = "12345";

	public Connection openConnection() {
		try {
			Class.forName(DRIVER).newInstance();
			Connection conn = DriverManager.getConnection(LINK, USER, PASSWORD);

			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			System.err.println(
					"Não foi possível conectar com o banco de dados, verifique as configurações de conexão e se o driver foi instalado!");
		}
		return null;
	}

	@Override
	public GenericDao<Customer> getCustomerDao() {
		return new CustomerPostgresDao();
	}
	
	@Override
	public GenericDao<Game> getGameDao() {
		return new GamePostgresDao();
	}
	
	@Override
	public GenericDao<Movie> getMovieDao() {
		return new MoviePostgresDao();
	}
}
