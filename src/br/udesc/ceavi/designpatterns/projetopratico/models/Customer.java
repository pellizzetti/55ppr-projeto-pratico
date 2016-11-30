package br.udesc.ceavi.designpatterns.projetopratico.models;

import java.sql.SQLException;
import java.util.List;

import br.udesc.ceavi.designpatterns.projetopratico.dao.DaoFactory;
import br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces.GenericDao;

public class Customer {

	private Long id = null;
	private String firstName;
	private String lastName;
	
	public Customer(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Customer(final Long id, final String firstName, final String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Customer{" + "id=" + getId() + ", firstName='" + getFirstName() + '\'' + ", lastName='" + getLastName()
				+ '\'' + '}';
	}

	public void insert() throws SQLException {
		dao().insert(this);
	}

	public void delete() throws SQLException {
		dao().delete(this);
	}

	public static List<Customer> findAll() throws SQLException {
		return dao().findAll();
	}

	public static Customer findById(Long id) throws SQLException {
		return dao().findById(id);
	}

	private static GenericDao<Customer> dao() {
		DaoFactory dao = DaoFactory.getDatabase("Postgres");
		return dao.getCustomerDao();
	}
}