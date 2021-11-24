package cl.silvabravo.dao;

import java.util.List;

import cl.silvabravo.model.Libro;

public interface LibroDAO {
	
	public List<Libro> getAllLibros();
	public Libro findByTituloAndAutor(String titulo, String autor);
	public int add(Libro libro);
	public int update(Libro libro);
	public int delete(Libro libro);
	public Libro findById(int id);

}
