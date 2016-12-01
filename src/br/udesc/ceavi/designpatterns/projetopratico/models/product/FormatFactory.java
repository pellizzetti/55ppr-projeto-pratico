package br.udesc.ceavi.designpatterns.projetopratico.models.product;

import java.time.LocalDate;

public interface FormatFactory {

  Game createGame(String title, int numberOfPlayers, LocalDate releaseDate);
  Movie createMovie(String title, String synopsis, LocalDate releaseDate);
  
}
