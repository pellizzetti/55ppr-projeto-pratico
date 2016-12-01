package br.udesc.ceavi.designpatterns.projetopratico.models.product;

import java.time.LocalDate;

public class BluRayMovie extends Movie {

	public BluRayMovie(String title, String synopsis, LocalDate releaseDate) {
		super(title, synopsis, releaseDate, "Blu-ray");
	}

	public BluRayMovie(Long id, String title, String synopsis, LocalDate releaseDate) {
		super(id, title, synopsis, releaseDate, "Blu-ray");
	}

}
