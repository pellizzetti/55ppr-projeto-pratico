package br.udesc.ceavi.designpatterns.projetopratico.test;

import java.sql.SQLException;

import br.udesc.ceavi.designpatterns.projetopratico.models.Customer;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		//customerModelTest();
		
		productModelTest();
	}

	private static void customerModelTest() throws SQLException {
		System.out.println("Criando clientes...");
		Customer customerA = new Customer("Camila", "Odorizzi");
		customerA.insert();

		Customer customerB = new Customer("Esley", "Bueno");
		customerB.insert();

		Customer customerC = new Customer("Guilherme", "Pellizzetti");
		customerC.insert();

		System.out.println("====================================");
		System.out.println("Listando clientes:");

		for (Customer aCustomer : Customer.findAll()) {
			System.out.println(aCustomer);
		}
	}
	
	private static void productModelTest() throws SQLException {
		System.out.println("Criando clientes...");
		Customer customerA = new Customer("Camila", "Odorizzi");
		customerA.insert();

		Customer customerB = new Customer("Esley", "Bueno");
		customerB.insert();

		Customer customerC = new Customer("Guilherme", "Pellizzetti");
		customerC.insert();

		System.out.println("====================================");
		System.out.println("Listando clientes:");

		for (Customer aCustomer : Customer.findAll()) {
			System.out.println(aCustomer);
		}
	}
}
