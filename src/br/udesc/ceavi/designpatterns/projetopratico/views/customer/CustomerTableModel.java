package br.udesc.ceavi.designpatterns.projetopratico.views.customer;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.udesc.ceavi.designpatterns.projetopratico.controllers.CustomerController;
import br.udesc.ceavi.designpatterns.projetopratico.models.Customer;

public class CustomerTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Customer> customers;
	private String[] columnNames = { "Nome", "Sobrenome" };
	private Class<?>[] columnTypes = { String.class, String.class };
	private static CustomerController controller;

	public CustomerTableModel() {
		controller = CustomerController.getInstance();
	}

	public void reload() throws SQLException {
		
		this.customers = controller.allCustomers();
		
		fireTableDataChanged();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public int getRowCount() {
		
		if (customers == null) {
			return 0;
		}
		
		return customers.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Customer aCustomer = customers.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return aCustomer.getFirstName();
		case 1:
			return aCustomer.getLastName();
		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Customer getCustomerAt(int index) {
		return customers.get(index);
	}
}
