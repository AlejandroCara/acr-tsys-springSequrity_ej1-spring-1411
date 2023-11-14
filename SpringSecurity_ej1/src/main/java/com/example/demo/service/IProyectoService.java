package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proyecto;

public interface IProyectoService {
	
	// Metodos del CRUD
	public List<Proyecto> listAll();

	public Proyecto add(Proyecto proyecto);

	public Proyecto getOne(String id);

	public Proyecto update(Proyecto proyecto);

	public void eliminar(String id);
}
