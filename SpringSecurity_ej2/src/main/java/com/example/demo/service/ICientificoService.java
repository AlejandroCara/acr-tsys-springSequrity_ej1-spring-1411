package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cientifico;

public interface ICientificoService {
	
	// Metodos del CRUD
	public List<Cientifico> listAll();

	public Cientifico add(Cientifico cientifico);

	public Cientifico getOne(String dni);

	public Cientifico update(Cientifico cientifico);

	public void eliminar(String dni);
}
