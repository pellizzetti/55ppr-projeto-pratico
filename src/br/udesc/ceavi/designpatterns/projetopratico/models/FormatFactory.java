package br.udesc.ceavi.designpatterns.projetopratico.models;

public interface FormatFactory {

  Game createGame(String title, int numberOfPlayers);
  Movie createMovie(String title, String synopsis);
  
}
