package br.udesc.ceavi.designpatterns.projetopratico.test;

import java.sql.SQLException;
import java.time.LocalDate;

import br.udesc.ceavi.designpatterns.projetopratico.models.customer.Customer;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.BluRayFactory;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.DvdFactory;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.FormatFactory;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.Game;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.Movie;

public class ModelTest {

	public static void main(String[] args) throws SQLException {

		customerModelTest();

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

		System.out.println("====================================");
	}

	private static void productModelTest() throws SQLException {
		System.out.println("F�brica de Blu-ray...");
		FormatFactory factory = new BluRayFactory();

		System.out.println("Criando jogos...");
		Game aBluRayGame = factory.createGame("Blu-ray Game 1", 4, LocalDate.of(2013, 2, 10));
		aBluRayGame.insert();

		System.out.println("Criando filmes...");
		Movie aBluRayMovie = factory.createMovie("Blu-ray Movie 1", "Synopsis of the Blu-ray Movie 1", LocalDate.of(1961, 5, 12));
		aBluRayMovie.insert();

		System.out.println("F�brica de DVD...");
		factory = new DvdFactory();

		System.out.println("Criando games...");
		Game aDvdGame = factory.createGame("DVD Game 1", 12, LocalDate.of(2007, 7, 24));
		aDvdGame.insert();

		System.out.println("Criando filmes...");
		Movie aDvdMovie = factory.createMovie("DVD Movie 1", "Synopsis of the DVD Movie 1", LocalDate.of(2001, 3, 5));
		aDvdMovie.insert();

		System.out.println("====================================");
		System.out.println("Listando jogos:");

		for (Game aGame : Game.findAll()) {
			System.out.println(aGame);
		}

		System.out.println("====================================");
		System.out.println("Listando filmes:");

		for (Movie aMovie : Movie.findAll()) {
			System.out.println(aMovie);
		}

		System.out.println("====================================");
	}

}
