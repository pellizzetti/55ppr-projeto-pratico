package br.udesc.ceavi.designpatterns.projetopratico.dao;

import java.sql.Connection;

import br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces.CustomerDao;

public abstract class DaoFactory {

	public abstract Connection openConnection();

	public abstract CustomerDao getCustomerDao();

	public static DaoFactory getDatabase(String database) {
		
		if (database == "Postgres") {
			return new Postgres();
		}
		
		return null;
	}
}
