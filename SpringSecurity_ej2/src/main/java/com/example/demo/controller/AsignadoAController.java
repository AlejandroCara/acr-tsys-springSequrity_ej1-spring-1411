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

import com.example.demo.dto.AsignadoA;
import com.example.demo.service.AsignadoAService;

@RestController
@RequestMapping("/asignadoa")
public class AsignadoAController {

	@Autowired(required = true)
	AsignadoAService asignadoAService;
	
	@GetMapping("/all")
	public List<AsignadoA> listarAsignaciones(){
		return asignadoAService.listAll();
	}
	
	@PostMapping("/add")
	public AsignadoA guardarAsignacion(@RequestBody AsignadoA asgignadoA) {
		return asignadoAService.add(asgignadoA);
	}
	
	@GetMapping("/{id}")
	public AsignadoA listarUnaAsignacion(@PathVariable(name="id") int id) {
		return asignadoAService.getOne(id);
	}
	
	@PutMapping("/update/{id}")
	public AsignadoA actualizarAsignacion(@PathVariable(name="id")int id,@RequestBody AsignadoA asignadoA) {
		
		AsignadoA prevAsignacion = new AsignadoA();
		AsignadoA newProyecto = new AsignadoA();
		
		prevAsignacion = asignadoAService.getOne(id);
		
		prevAsignacion.setCientifico(asignadoA.getCientifico());
		prevAsignacion.setProyecto(asignadoA.getProyecto());
		
		newProyecto = asignadoAService.update(prevAsignacion);
		
		return newProyecto;
	}
	
	@DeleteMapping("/delete/{id}")
	public void aliminarAsignacion(@PathVariable(name="id")int id) {
		asignadoAService.eliminar(id);
	}
}
