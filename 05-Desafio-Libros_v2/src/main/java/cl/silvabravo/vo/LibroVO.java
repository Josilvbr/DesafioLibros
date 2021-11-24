package cl.silvabravo.vo;

import java.util.List;

import cl.silvabravo.model.Libro;

public class LibroVO {
	
	List<Libro> libros;
	String mensaje;
	String codigo;
	
	//Constructor
	public LibroVO(List<Libro> libros, String mensaje, String codigo) {
		super();
		this.libros = libros;
		this.mensaje = mensaje;
		this.codigo = codigo;
	}
	
	//G&S
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	//toString
	@Override
	public String toString() {
		return "LibroVO [libros=" + libros + ", mensaje=" + mensaje + ", codigo=" + codigo + "]";
	}

}
