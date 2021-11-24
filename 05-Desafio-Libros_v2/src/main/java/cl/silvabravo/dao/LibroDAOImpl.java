package cl.silvabravo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.silvabravo.model.Libro;
import cl.silvabravo.model.LibroMapper;

@Repository
public class LibroDAOImpl implements LibroDAO {

	JdbcTemplate jdbcTemplate;
	DataSource dataSource;

	@Autowired
	public LibroDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Libro> getAllLibros() {
		return jdbcTemplate.query("SELECT * FROM libros", new LibroMapper());
	}

	@Override
	public Libro findByTituloAndAutor(String titulo, String autor) {
		return jdbcTemplate.queryForObject("SELECT * FROM libros WHERE TITULO=? AND AUTOR=?", new LibroMapper(),
				new Object[] { titulo, autor });
	}

	@Override
	public int add(Libro libro) {// INSERT INTO LIBROS VALUES (SQ_LIBROS.NEXTVAL, ?, ?, ?, ?, ?)
		return jdbcTemplate.update("INSERT INTO libros VALUES (NULL, ?, ?, ?, ?, ?)", libro.getTitulo(),
				libro.getAnio(), libro.getAutor(), libro.getImprenta(), libro.getDisponible());
	}

	@Override
	public int update(Libro libro) {
		return jdbcTemplate.update(
				"UPDATE libros SET TITULO=?, ANIO=?, AUTOR=?, IMPRENTA=?, DISPONIBLE=? WHERE idLibro=?",
				libro.getTitulo(), libro.getAnio(), libro.getAutor(), libro.getImprenta(), libro.getDisponible(), libro.getIdLibro());
	}

	@Override
	public int delete(Libro libro) {
		return jdbcTemplate.update("DELETE FROM LIBROS WHERE idLibro=?", libro.getIdLibro());
	}

	@Override
	public Libro findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM LIBROS WHERE idLibro=?", new LibroMapper(), new Object[] {id});
	}

}
