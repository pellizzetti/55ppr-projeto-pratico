package br.udesc.ceavi.designpatterns.projetopratico.dao;

import java.sql.Connection;

import br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces.GenericDao;
import br.udesc.ceavi.designpatterns.projetopratico.models.Customer;

public abstract class DaoFactory {

	public abstract Connection openConnection();

	public abstract GenericDao<Customer> getCustomerDao();

	public static DaoFactory getDatabase(String database) {
		
		if (database == "Postgres") {
			return new Postgres();
		}
		
		return null;
	}
}
