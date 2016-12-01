package br.udesc.ceavi.designpatterns.projetopratico.models.product;

import java.time.LocalDate;

public class DvdFactory implements FormatFactory {

  public Game createGame(String title, int numberOfPlayers, LocalDate releaseDate) {
    return new DvdGame(title, numberOfPlayers, releaseDate);
  }

  public Movie createMovie(String title, String synopsis, LocalDate releaseDate) {
    return new DvdMovie(title, synopsis, releaseDate);
  }

}
