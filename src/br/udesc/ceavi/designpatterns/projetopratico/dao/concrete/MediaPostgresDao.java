package br.udesc.ceavi.designpatterns.projetopratico.dao.concrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.udesc.ceavi.designpatterns.projetopratico.dao.DaoFactory;
import br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces.GenericDao;
import br.udesc.ceavi.designpatterns.projetopratico.models.Game;
import br.udesc.ceavi.designpatterns.projetopratico.models.Media;

public class MediaPostgresDao implements GenericDao<Media> {

	private static final String INSERT = "INSERT INTO product (customer_firstname, customer_lastname) VALUES (?, ?)";
	private static final String DELETE = "DELETE FROM customers where id = ?";
	private static final String FIND_ALL = "SELECT * FROM customers";
	private static final String FIND_BY_ID = "SELECT * FROM customers WHERE id = ?";

	public Media insert(Media aMedia) throws SQLException {
		Connection c = DaoFactory.getDatabase("Postgres").openConnection();

		PreparedStatement pstmt = c.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

		pstmt.setString(1, aMedia.getTitle());
		//pstmt.setString(2, aMedia.getLastName());

		pstmt.executeUpdate();

		ResultSet rset = pstmt.getGeneratedKeys();

		rset.next();
		Long idGenerated = rset.getLong(1);
		aMedia.setId(idGenerated);

		pstmt.close();
		c.close();

		return aMedia;
	}

	public List<Media> findAll() throws SQLException {
		ArrayList<Media> customers = new ArrayList<Media>();

		Connection c = DaoFactory.getDatabase("Postgres").openConnection();
		PreparedStatement pstmt = c.prepareStatement(FIND_ALL);

		Media aMedia = null;
		ResultSet rset = pstmt.executeQuery();

		while (rset.next()) {

			Long id = rset.getLong("customer_id");
			String firstName = rset.getString("customer_firstname");
			String lastName = rset.getString("customer_lastname");

			aMedia = new Game(id, firstName, lastName);

			customers.add(aMedia);
		}

		pstmt.close();
		c.close();

		return customers;
	}

	public int delete(Media aMedia) throws SQLException {

		Connection c = DaoFactory.getDatabase("Postgres").openConnection();
		PreparedStatement pstmt = c.prepareStatement(DELETE);

		pstmt.setLong(1, aMedia.getId());

		int rowsAffected = pstmt.executeUpdate();

		pstmt.close();
		c.close();

		return rowsAffected;
	}

	public Media findById(Long id) throws SQLException {

		Connection c = DaoFactory.getDatabase("Postgres").openConnection();
		PreparedStatement pstmt = c.prepareStatement(FIND_BY_ID);

		pstmt.setLong(1, id);

		Media aMedia = null;
		ResultSet rset = pstmt.executeQuery();

		while (rset.next()) {

			String firstName = rset.getString("customer_first_name");
			String lastName = rset.getString("customer_last_name");

			aMedia = new Media(id, firstName, lastName);
		}

		pstmt.close();
		c.close();

		return aMedia;
	}
}
