package br.udesc.ceavi.designpatterns.projetopratico;

public class BluRayMovie implements Movie {

  static final String TITLE = "This is a Blu-Ray movie!";

  @Override
  public String getTitle() {
    return TITLE;
  }
}
