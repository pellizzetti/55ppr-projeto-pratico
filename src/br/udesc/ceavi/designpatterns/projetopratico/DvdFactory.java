package br.udesc.ceavi.designpatterns.projetopratico;

public class DvdFactory implements FormatFactory {

  public Game createGame() {
    return new DvdGame();
  }

  public Movie createMovie() {
    return new DvdMovie();
  }

}
