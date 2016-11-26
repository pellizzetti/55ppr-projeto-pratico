package br.udesc.ceavi.designpatterns.projetopratico.views.customer;

import java.util.List;

import javax.swing.JTable;

import br.udesc.ceavi.designpatterns.projetopratico.models.Customer;

public class CustomerTable extends JTable {

	private static final long serialVersionUID = 1L;

	private CustomerTableModel tableModel;

	public CustomerTable() {
		tableModel = new CustomerTableModel();

		setModel(tableModel);
	}

	public Customer getSelectedCustomer() {
		int i = getSelectedRow();

		if (i < 0) {
			return null;
		}

		return tableModel.getCustomerAt(i);
	}

	public void reload(List<Customer> customers) {
		tableModel.reload(customers);
	}
}
