package br.udesc.ceavi.designpatterns.projetopratico.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.udesc.ceavi.designpatterns.projetopratico.dao.concrete.CustomerPostgresDao;
import br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces.GenericDao;

public class Postgres extends DaoFactory {

	private static final String DRIVER   = "org.postgresql.Driver";
	private static final String DATABASE = "55ppr";
	private static final String URL      = "localhost:4000/";
	private static final String LINK     = "jdbc:postgresql://" + URL + DATABASE;
	private static final String USER     = "postgres";
	private static final String PASSWORD = "";

	public Connection openConnection() {
		try {
			Class.forName(DRIVER).newInstance();
			Connection conn = DriverManager.getConnection(LINK, USER, PASSWORD);

			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			System.err.println("N�o foi poss�vel criar a conex�o com o banco de dados, verifique as configura��es de conex�o e se o driver foi instalado!");
		}
		return null;
	}

	@Override
	public GenericDao getCustomerDao() {
		return new CustomerPostgresDao();
	}
}
