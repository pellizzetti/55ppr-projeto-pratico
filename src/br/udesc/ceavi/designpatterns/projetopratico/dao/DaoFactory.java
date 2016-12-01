package br.udesc.ceavi.designpatterns.projetopratico.dao;

import java.sql.Connection;

import br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces.GenericDao;
import br.udesc.ceavi.designpatterns.projetopratico.models.customer.Customer;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.Game;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.Movie;

public abstract class DaoFactory {

	public abstract Connection openConnection();

	public abstract GenericDao<Customer> getCustomerDao();
	
	public abstract GenericDao<Game> getGameDao();

	public abstract GenericDao<Movie> getMovieDao();

	public static DaoFactory getDatabase(String database) {
		
		if (database == "Postgres") {
			return new PostgresFactory();
		}
		
		return null;
	}
	
}
