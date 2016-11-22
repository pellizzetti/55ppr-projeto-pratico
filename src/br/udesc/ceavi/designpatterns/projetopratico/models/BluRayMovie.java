package br.udesc.ceavi.designpatterns.projetopratico.models;

public class BluRayMovie implements Movie {

  static final String TITLE = "This is a Blu-Ray movie!";

  @Override
  public String getTitle() {
    return TITLE;
  }
}
