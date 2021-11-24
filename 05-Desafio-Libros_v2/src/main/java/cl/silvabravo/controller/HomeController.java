package cl.silvabravo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.silvabravo.model.Libro;
import cl.silvabravo.service.LibroService;
import cl.silvabravo.vo.LibroVO;

@Controller
public class HomeController {
	
	@Autowired
	LibroService libroService;
	
	@GetMapping({"/", "/home"})
	public String home(ModelMap modelMap) {
		
		LibroVO libroVO = libroService.getAllLibros();
		modelMap.addAttribute("librosVO", libroVO);
		return "index";
	}
	
	@PostMapping("/addLibro")
	public ModelAndView addLibro(ModelMap modelMap, @ModelAttribute("libro") Libro libro) {
		
		LibroVO libroVO = libroService.add(libro);
		modelMap.addAttribute("librosVO", libroVO);
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/deleteLibro")
	public ModelAndView deleteLibro(ModelMap modelMap, @RequestParam String idLibro) {
		
		Libro libroEliminado = new Libro();
		libroEliminado.setIdLibro(Integer.parseInt(idLibro));
		libroService.delete(libroEliminado);
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/findByTituloAndAutor")
	public String findByTituloAndAutor(ModelMap modelMap, @RequestParam String titulo, String autor) {
		
		LibroVO libroVO = libroService.findByTituloAndAutor(titulo, autor);
		modelMap.addAttribute("librosVO", libroVO);
		return "index";
	}
	
	@RequestMapping("/findByIdLibro")
	public String findByIdLibro(ModelMap modelMap, @RequestParam String idLibro) {
		
		LibroVO libroVO = libroService.findById(Integer.parseInt(idLibro));
		modelMap.addAttribute("libroVO", libroVO.getLibros().get(0));
		return "edit";
	}
	
	@PostMapping("/editLibro")
	public ModelAndView editLibro(ModelMap modelMap, @ModelAttribute("libro") Libro libro) {
		//System.out.println(libro); // Prueba para saber si esta llegando el objeto
		LibroVO libroVO = libroService.update(libro);
		modelMap.addAttribute("libroVO", libroVO);
		return new ModelAndView("redirect:/");
	}
	
	

}
