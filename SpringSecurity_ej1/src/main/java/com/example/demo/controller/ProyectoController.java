package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Proyecto;
import com.example.demo.service.ProyectoService;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

	@Autowired(required = true)
	ProyectoService proyectoService;
	
	@GetMapping("/all")
	public List<Proyecto> listarProyectos(){
		return proyectoService.listAll();
	}
	
	@PostMapping("/add")
	public Proyecto guardarProyecto(@RequestBody Proyecto proyecto) {
		return proyectoService.add(proyecto);
	}
	
	@GetMapping("/{id}")
	public Proyecto listarUnProyecto(@PathVariable(name="id") String id) {
		return proyectoService.getOne(id);
	}
	
	@PutMapping("/update/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name="id")String id,@RequestBody Proyecto proyecto) {
		
		Proyecto prevProyecto = new Proyecto();
		Proyecto newProyecto = new Proyecto();
		
		prevProyecto = proyectoService.getOne(id);
		
		prevProyecto.setNombre(proyecto.getNombre());
		prevProyecto.setHoras(proyecto.getHoras());
		
		newProyecto = proyectoService.update(prevProyecto);
		
		return newProyecto;
	}
	
	@DeleteMapping("/delete/{id}")
	public void eliminarProyecto(@PathVariable(name="id")String id) {
		proyectoService.eliminar(id);
	}
}
