package br.udesc.ceavi.designpatterns.projetopratico.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.udesc.ceavi.designpatterns.projetopratico.dao.concrete.CustomerPostgresDao;
import br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces.CustomerDao;

public class Postgres extends DaoFactory {

	private static final String DRIVER   = "org.postgresql.Driver";
    private static final String DATABASE = "lan_house";
    private static final String URL      = "localhost:5430/";
    private static final String LINK     = "jdbc:postgresql://" + URL + DATABASE;
    private static final String USER     = "postgres";
    private static final String PASSWORD = "databox99182599";

	public Connection openConnection() {
		try {
			Class.forName(DRIVER).newInstance();
			Connection conn = DriverManager.getConnection(LINK, USER, PASSWORD);
			
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			System.err.println("Não foi possível salvar os dados! O Banco de dados não estão respondendo!");
		}
		return null;
	}

	@Override
	public CustomerDao getCustomerDao() {
		return new CustomerPostgresDao();
	}
}
