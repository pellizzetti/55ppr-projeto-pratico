package br.udesc.ceavi.designpatterns.projetopratico.models;

public abstract class Movie extends Media {
	
	private String synopsis;
	private String rated;

	public Movie(String title, String format) {
		super(title, format, "Movie");
	}
	
	public Movie(Long id, String title, String format) {
		super(title, format, "Movie");
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

}
