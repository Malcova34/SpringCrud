package com.crudgabriela.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crudgabriela.app.entidades.Agenda;
import com.crudgabriela.app.repositorio.AgendaRepositorio;

@Controller
public class AgendaController {
	
	@Autowired
	private AgendaRepositorio agendarepositorio;
	
	@GetMapping({"/", "/veragenda", "/mostraragenda", "/listaragenda"})
	public String listarAgenda(Model model) {
		List<Agenda> listaAgenda = agendarepositorio.findAll();
		model.addAttribute("listaAgenda", listaAgenda);
		model.addAttribute("agenda", new Agenda());
		return "veragenda";
	}
	
	@GetMapping("/formagenda")
	public String mostrarFormulario(Model model) {
		model.addAttribute("agenda", new Agenda());
		List<Agenda> listaAgenda = agendarepositorio.findAll();
		model.addAttribute("listaAgenda", listaAgenda);
		return "formagenda";
	}
	
	@PostMapping("/agenda/guardar")
	public String guardarAgenda(Agenda agenda) {
		agendarepositorio.save(agenda);
		return "redirect:/formagenda";
	}
	
	@GetMapping("/agenda/editar/{id}")
	public String modificarAgenda(@PathVariable("id") Long id, Model model) {
		Agenda agenda = agendarepositorio.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("ID de equipo inválido:" + id));
		model.addAttribute("agenda", agenda);
		List<Agenda> listaAgenda = agendarepositorio.findAll();
		model.addAttribute("listaAgenda", listaAgenda);
		return "veragenda";
	}
	
	@GetMapping("/agenda/eliminar/{id}")
	public String eliminaragenda(@PathVariable("id") Long id) {
		agendarepositorio.deleteById(id);
		return "redirect:/formagenda";
	}
} 