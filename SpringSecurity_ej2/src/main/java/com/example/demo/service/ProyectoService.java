package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProyectoDAO;
import com.example.demo.dto.Proyecto;

@Service
public class ProyectoService implements IProyectoService{
	
	@Autowired(required = true)
	IProyectoDAO iProyectoDAO;
	
	@Override
	public List<Proyecto> listAll() {
		return iProyectoDAO.findAll();
	}

	@Override
	public Proyecto add(Proyecto proyecto) {
		return iProyectoDAO.save(proyecto);
	}

	@Override
	public Proyecto getOne(String id) {
		return iProyectoDAO.findById(id).get();
	}

	@Override
	public Proyecto update(Proyecto proyecto) {
		return iProyectoDAO.save(proyecto);
	}

	@Override
	public void eliminar(String id) {
		iProyectoDAO.deleteById(id);
	}

}
