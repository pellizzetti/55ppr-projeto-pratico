package br.udesc.ceavi.designpatterns.projetopratico.controllers;

import java.sql.SQLException;
import java.util.List;

import br.udesc.ceavi.designpatterns.projetopratico.models.Customer;

public class CustomerController {

	protected static CustomerController instance;

	private CustomerController() {
	}

	public static synchronized CustomerController getInstance() {
		if (instance == null) {
			instance = new CustomerController();
		}

		return instance;
	}

	public Customer insert(Customer aCustomer) throws SQLException {
		if (aCustomer != null) {
			aCustomer.insert();
		}
		
		return aCustomer;
	}

	public void delete(Long CustomerId) throws SQLException {
		Customer aCustomer = Customer.findById(CustomerId);
		
		aCustomer.delete();
	}

	public List<Customer> allCustomers() throws SQLException {
		return Customer.findAll();
	}
}