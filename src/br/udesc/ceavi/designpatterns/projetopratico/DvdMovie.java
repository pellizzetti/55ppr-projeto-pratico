package br.udesc.ceavi.designpatterns.projetopratico;

public class DvdMovie implements Movie {

  static final String TITLE = "This is a DVD movie!";

  @Override
  public String getTitle() {
    return TITLE;
  }
}
