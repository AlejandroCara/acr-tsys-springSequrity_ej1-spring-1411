package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AsignadoA;

public interface IAsignadoAService {
	
	// Metodos del CRUD
	public List<AsignadoA> listAll();

	public AsignadoA add(AsignadoA asignadoA);

	public AsignadoA getOne(int id);

	public AsignadoA update(AsignadoA asignadoA);

	public void eliminar(int id);
}
