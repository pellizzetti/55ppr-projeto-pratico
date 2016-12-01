package br.udesc.ceavi.designpatterns.projetopratico.test;

import java.sql.SQLException;

import br.udesc.ceavi.designpatterns.projetopratico.models.BluRayFactory;
import br.udesc.ceavi.designpatterns.projetopratico.models.Customer;
import br.udesc.ceavi.designpatterns.projetopratico.models.DvdFactory;
import br.udesc.ceavi.designpatterns.projetopratico.models.FormatFactory;
import br.udesc.ceavi.designpatterns.projetopratico.models.Game;
import br.udesc.ceavi.designpatterns.projetopratico.models.Movie;

public class Test {

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
		System.out.println("Fábrica de Blu-ray...");
		FormatFactory factory = new BluRayFactory();

		System.out.println("Criando jogos...");
		Game aBluRayGame = factory.createGame("Blu-ray Game 1", 4);
		aBluRayGame.insert();

		System.out.println("Criando filmes...");
		Movie aBluRayMovie = factory.createMovie("Blu-ray Movie 1", "Synopsis of the Blu-ray Movie 1");
		aBluRayMovie.insert();

		System.out.println("Fábrica de DVD...");
		factory = new DvdFactory();

		System.out.println("Criando games...");
		Game aDvdGame = factory.createGame("DVD Game 1", 12);
		aDvdGame.insert();

		System.out.println("Criando filmes...");
		Movie aDvdMovie = factory.createMovie("DVD Movie 1", "Synopsis of the DVD Movie 1");
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
