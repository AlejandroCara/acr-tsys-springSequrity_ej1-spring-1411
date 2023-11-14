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

import com.example.demo.dto.Cientifico;
import com.example.demo.service.CientificoService;

@RestController
@RequestMapping("/cientifico")
public class CientificoController {
	
	@Autowired(required = true)
	CientificoService cientificoService;
	
	@GetMapping("/all")
	public List<Cientifico> listarCientificos(){
		return cientificoService.listAll();
	}
	
	@PostMapping("/add")
	public Cientifico guardarCientifico(@RequestBody Cientifico cientifico) {
		return cientificoService.add(cientifico);
	}
	
	@GetMapping("/{dni}")
	public Cientifico listarUnCientifico(@PathVariable(name="dni") String dni) {
		return cientificoService.getOne(dni);
	}
	
	@PutMapping("/update/{dni}")
	public Cientifico actualizarCientifico(@PathVariable(name="dni")String dni,@RequestBody Cientifico cientifico) {
		
		Cientifico prevCientifico = new Cientifico();
		Cientifico newCientifico = new Cientifico();
		
		prevCientifico = cientificoService.getOne(dni);
		
		prevCientifico.setNomapels(cientifico.getNomapels());
		
		newCientifico = cientificoService.update(prevCientifico);
		
		return newCientifico;
	}
	
	@DeleteMapping("/delete/{dni}")
	public void eliminarCientifico(@PathVariable(name="dni")String dni) {
		cientificoService.eliminar(dni);
	}
}
