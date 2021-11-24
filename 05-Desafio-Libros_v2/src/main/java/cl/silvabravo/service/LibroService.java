package cl.silvabravo.service;

import cl.silvabravo.model.Libro;
import cl.silvabravo.vo.LibroVO;

public interface LibroService {
	
	public LibroVO getAllLibros();
	public LibroVO findByTituloAndAutor(String titulo, String autor);
	public LibroVO add(Libro libro);
	public LibroVO update(Libro libro);
	public LibroVO delete(Libro libro);
	public LibroVO findById(int id);

}
