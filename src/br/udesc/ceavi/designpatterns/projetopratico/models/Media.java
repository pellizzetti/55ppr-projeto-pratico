package br.udesc.ceavi.designpatterns.projetopratico.models;

public abstract class Media {
	
	private Long id = null;
	private String title;
	private String format;
	private String category;
	
	public Media(String title, String format, String category) {
		this.title = title;
		this.format = format;
		this.category = category;
	}
	
	public Media(Long id, String title, String format, String category) {
		this.id = id;
		this.title = title;
		this.format = format;
		this.category = category;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
