package br.udesc.ceavi.designpatterns.projetopratico.models;

public class DvdMovie extends Movie {

	public DvdMovie(String title, String synopsis) {
		super(title, synopsis, "DVD");
	}

	public DvdMovie(Long id, String title, String synopsis) {
		super(id, title, synopsis, "DVD");
	}
	
}
