package br.udesc.ceavi.designpatterns.projetopratico.models.product;

import java.time.LocalDate;

public class DvdMovie extends Movie {

	public DvdMovie(String title, String synopsis, LocalDate releaseDate) {
		super(title, synopsis, releaseDate, "DVD");
	}

	public DvdMovie(Long id, String title, String synopsis, LocalDate releaseDate) {
		super(id, title, synopsis, releaseDate, "DVD");
	}
	
}
