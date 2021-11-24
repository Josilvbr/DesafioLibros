package cl.silvabravo.model;

import org.springframework.stereotype.Component;

@Component("libro")
public class Libro {
	
	private Integer idLibro;
	private String titulo;
	private Integer anio;
	private String autor;
	private String imprenta;
	private Integer disponible;
	
	//Constructor
	public Libro() {
		super();
	}

	public Libro(Integer idLibro, String titulo, Integer anio, String autor, String imprenta, Integer disponible) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.anio = anio;
		this.autor = autor;
		this.imprenta = imprenta;
		this.disponible = disponible;
	}
	
	//G&S
	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getImprenta() {
		return imprenta;
	}

	public void setImprenta(String imprenta) {
		this.imprenta = imprenta;
	}

	public Integer getDisponible() {
		return disponible;
	}

	public void setDisponible(Integer disponible) {
		this.disponible = disponible;
	}
	
	//toStrign
	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", anio=" + anio + ", autor=" + autor
				+ ", imprenta=" + imprenta + ", disponible=" + disponible + "]";
	}
	
	

}
