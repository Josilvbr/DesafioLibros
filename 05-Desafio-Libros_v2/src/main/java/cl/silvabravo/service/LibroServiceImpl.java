package cl.silvabravo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.silvabravo.dao.LibroDAO;
import cl.silvabravo.model.Libro;
import cl.silvabravo.vo.LibroVO;

@Service
public class LibroServiceImpl implements LibroService {
	
	@Autowired
	LibroDAO dao;
	
	LibroVO respuestaVo;

	@Override
	public LibroVO getAllLibros() {
		
		respuestaVo = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "101");
		try {
			
			respuestaVo.setLibros(new ArrayList<>(dao.getAllLibros()));
			respuestaVo.setMensaje(String.format("Se ha/n encontrado %d libro/s", respuestaVo.getLibros().size()));
			respuestaVo.setCodigo("0");
			
		} catch (Exception e) {
			System.err.print(e);
		}
		
		return respuestaVo;
	}

	@Override
	public LibroVO findByTituloAndAutor(String titulo, String autor) {
		
		respuestaVo = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "102");
		try {
			Libro libro = dao.findByTituloAndAutor(titulo, autor);
			respuestaVo.getLibros().add(libro);
			respuestaVo.setMensaje(String.format("Se ha/n encontrado %d libro/s", null != libro ? 1 : 0)); //Operador ternario
			respuestaVo.setCodigo("0");

		} catch (Exception e) {
			System.err.print(e);
		}
		
		return respuestaVo;
	}

	@Override
	public LibroVO add(Libro libro) {
		
		respuestaVo = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "103");
		try {
			int registrosActualizados = dao.add(libro); // Retorna la cantidad de libros add/update/delete
			respuestaVo.setMensaje(registrosActualizados == 1 ? "Se ha creado el libro correctamente" : "No se ha podido crear el usuario");
			respuestaVo.setCodigo("0");

		} catch (Exception e) {
			System.err.print(e);
		}
		return respuestaVo;
	}

	@Override
	public LibroVO update(Libro libro) {
		
		respuestaVo = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "104");
		try {
			int registrosActualizados = dao.update(libro);
			respuestaVo.setMensaje(String.format("Se ha/n actualizado correctamente %d libro/s", registrosActualizados));
			respuestaVo.setCodigo("0");

		} catch (Exception e) {
			System.err.print(e);
		}
		return respuestaVo;
	}

	@Override
	public LibroVO delete(Libro libro) {
		
		respuestaVo = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "105");
		try {
			int registrosActualizados = dao.delete(libro);
			respuestaVo.setMensaje(String.format("Se ha/n eliminado correctamente %d libro/s", registrosActualizados));
			respuestaVo.setCodigo("0");

		} catch (Exception e) {
			System.err.print(e);
		}
		return respuestaVo;
	}

	@Override
	public LibroVO findById(int id) {
		
		respuestaVo = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "102");
		try {
			Libro libro = dao.findById(id);
			respuestaVo.getLibros().add(libro);
			respuestaVo.setMensaje(String.format("Se ha/n encontrado %d libro/s", null != libro ? 1 : 0));
			respuestaVo.setCodigo("0");

		} catch (Exception e) {
			System.err.print(e);
		}
		return respuestaVo;
	}

}
