package br.udesc.ceavi.designpatterns.projetopratico.models;

public interface Game {

  String getTitle();
  Double getValue();
  int getNumberOfPlayers();
  
  void setTitle();
  void setValue();
  void setNumberOfPlayers();
}
