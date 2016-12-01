package br.udesc.ceavi.designpatterns.projetopratico.models;

public class BluRayMovie extends Movie {

	public BluRayMovie(String title, String synopsis) {
		super(title, synopsis, "Blu-ray");
	}

	public BluRayMovie(Long id, String title, String synopsis) {
		super(id, title, synopsis, "Blu-ray");
	}

}
