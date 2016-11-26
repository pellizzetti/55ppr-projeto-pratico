package br.udesc.ceavi.designpatterns.projetopratico.dao.concrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.udesc.ceavi.designpatterns.projetopratico.dao.DaoFactory;
import br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces.CustomerDao;
import br.udesc.ceavi.designpatterns.projetopratico.models.Customer;

public class CustomerPostgresDao implements CustomerDao {

	private static final String INSERT     = "INSERT INTO customers (customer_firstname, customer_lastname) VALUES (?, ?)";
	private static final String DELETE     = "DELETE FROM customers where id = ?";
	private static final String FIND_ALL   = "SELECT * FROM customers";
	private static final String FIND_BY_ID = "SELECT * FROM customers WHERE id = ?";

	public Customer insert(Customer aCustomer) throws SQLException {
		Connection c = DaoFactory.getDatabase("Postgres").openConnection();

		PreparedStatement pstmt = c.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

		pstmt.setString(1, aCustomer.getFirstName());
		pstmt.setString(2, aCustomer.getLastName());

		pstmt.executeUpdate();

		ResultSet rset = pstmt.getGeneratedKeys();

		rset.next();
		Long idGenerated = rset.getLong(1);
		aCustomer.setId(idGenerated);

		pstmt.close();
		c.close();

		return aCustomer;
	}

	public List<Customer> findAll() throws SQLException {
		ArrayList<Customer> customers = new ArrayList<Customer>();

		Connection c = DaoFactory.getDatabase("Postgres").openConnection();
		PreparedStatement pstmt = c.prepareStatement(FIND_ALL);

		Customer aCustomer = null;
		ResultSet rset = pstmt.executeQuery();

		while (rset.next()) {

			Long id = rset.getLong("customer_id");
			String firstName = rset.getString("customer_firstname");
			String lastName = rset.getString("customer_lastname");

			aCustomer = new Customer(id, firstName, lastName);

			customers.add(aCustomer);
		}

		pstmt.close();
		c.close();

		return customers;
	}

	public int delete(Customer aCustomer) throws SQLException {

		Connection c = DaoFactory.getDatabase("Postgres").openConnection();
		PreparedStatement pstmt = c.prepareStatement(DELETE);

		pstmt.setLong(1, aCustomer.getId());

		int rowsAffected = pstmt.executeUpdate();

		pstmt.close();
		c.close();

		return rowsAffected;
	}

	public Customer findById(Long id) throws SQLException {

		Connection c = DaoFactory.getDatabase("Postgres").openConnection();
		PreparedStatement pstmt = c.prepareStatement(FIND_BY_ID);

		pstmt.setLong(1, id);

		Customer aCustomer = null;
		ResultSet rset = pstmt.executeQuery();

		while (rset.next()) {

			String firstName = rset.getString("customer_first_name");
			String lastName = rset.getString("customer_last_name");

			aCustomer = new Customer(id, firstName, lastName);
		}

		pstmt.close();
		c.close();

		return aCustomer;
	}
}
