package br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.udesc.ceavi.designpatterns.projetopratico.models.Customer;

public interface CustomerDao {
	
	Customer insert(Customer object) throws SQLException;
	int delete(Customer user) throws SQLException;
	List<Customer> findAll() throws SQLException;
	Customer findById(Long id) throws SQLException;
}
