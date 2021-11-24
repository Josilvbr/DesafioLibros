package cl.silvabravo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class LibroMapper  implements RowMapper<Libro>{

	@Override
	public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Libro libro = new Libro();
		libro.setIdLibro(rs.getInt("idLibro"));
		libro.setTitulo(rs.getString("titulo"));
		libro.setAnio(rs.getInt("anio"));
		libro.setAutor(rs.getString("autor"));
		libro.setImprenta(rs.getString("imprenta"));
		libro.setDisponible(rs.getInt("disponible"));
		
		return libro;
	}

}
