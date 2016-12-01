package br.udesc.ceavi.designpatterns.projetopratico.test;

import java.sql.SQLException;
import java.time.LocalDate;

import br.udesc.ceavi.designpatterns.projetopratico.controllers.CustomerController;
import br.udesc.ceavi.designpatterns.projetopratico.controllers.GameController;
import br.udesc.ceavi.designpatterns.projetopratico.controllers.MovieController;
import br.udesc.ceavi.designpatterns.projetopratico.models.customer.Customer;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.BluRayFactory;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.DvdFactory;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.FormatFactory;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.Game;
import br.udesc.ceavi.designpatterns.projetopratico.models.product.Movie;

public class ControllerTest {

	private static CustomerController customerController;
	private static GameController gameController;
	private static MovieController movieController;

	public static void main(String[] args) throws SQLException {
		
		customerController = CustomerController.getInstance();
		gameController = GameController.getInstance();
		movieController = MovieController.getInstance();

		customerControllerTest();

		productControllerTest();

	}

	private static void customerControllerTest() throws SQLException {
		System.out.println("Criando clientes...");

		Customer customerA = new Customer("Camila", "Odorizzi");
		customerController.insert(customerA);

		Customer customerB = new Customer("Esley", "Bueno");
		customerController.insert(customerB);

		Customer customerC = new Customer("Guilherme", "Pellizzetti");
		customerController.insert(customerC);

		System.out.println("====================================");
		System.out.println("Listando clientes:");

		for (Customer aCustomer : Customer.findAll()) {
			System.out.println(aCustomer);
		}

		System.out.println("====================================");
	}

	private static void productControllerTest() throws SQLException {
		System.out.println("Fábrica de Blu-ray...");
		FormatFactory factory = new BluRayFactory();

		System.out.println("Criando jogos...");
		Game aBluRayGame = factory.createGame("Blu-ray Game 1", 4, LocalDate.of(2016, 10, 11));
		gameController.insert(aBluRayGame);

		System.out.println("Criando filmes...");
		Movie aBluRayMovie = factory.createMovie("Blu-ray Movie 1", "Synopsis of the Blu-ray Movie 1", LocalDate.of(1961, 5, 12));
		movieController.insert(aBluRayMovie);

		System.out.println("Fábrica de DVD...");
		factory = new DvdFactory();

		System.out.println("Criando games...");
		Game aDvdGame = factory.createGame("DVD Game 1", 12, LocalDate.of(2007, 7, 24));
		gameController.insert(aDvdGame);

		System.out.println("Criando filmes...");
		Movie aDvdMovie = factory.createMovie("DVD Movie 1", "Synopsis of the DVD Movie 1", LocalDate.of(2001, 3, 5));
		movieController.insert(aDvdMovie);

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
