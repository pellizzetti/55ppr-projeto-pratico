package br.udesc.ceavi.designpatterns.projetopratico;

public class BluRayFactory implements FormatFactory {

  public Game createGame() {
    return new BluRayGame();
  }

  public Movie createMovie() {
    return new BluRayMovie();
  }

}
