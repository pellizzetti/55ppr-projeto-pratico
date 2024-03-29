package br.udesc.ceavi.designpatterns.projetopratico.controllers;

import java.sql.SQLException;
import java.util.List;

import br.udesc.ceavi.designpatterns.projetopratico.models.customer.Customer;

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

	public void delete(Long id) throws SQLException {
		Customer aCustomer = Customer.findById(id);
		
		aCustomer.delete();
	}

	public List<Customer> allCustomers() throws SQLException {
		return Customer.findAll();
	}
}