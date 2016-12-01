package br.udesc.ceavi.designpatterns.projetopratico.models;

public class DvdFactory implements FormatFactory {

  public Game createGame(String title, int numberOfPlayers) {
    return new DvdGame(title, numberOfPlayers);
  }

  public Movie createMovie(String title, String synopsis) {
    return new DvdMovie(title, synopsis);
  }

}
