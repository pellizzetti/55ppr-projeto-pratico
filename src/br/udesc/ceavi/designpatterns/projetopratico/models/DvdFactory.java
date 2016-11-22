package br.udesc.ceavi.designpatterns.projetopratico.models;

public class DvdFactory implements FormatFactory {

  public Game createGame() {
    return new DvdGame();
  }

  public Movie createMovie() {
    return new DvdMovie();
  }

}
