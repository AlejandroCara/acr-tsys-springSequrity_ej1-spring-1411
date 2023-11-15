package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAsignadoADAO;
import com.example.demo.dto.AsignadoA;

@Service
public class AsignadoAService implements IAsignadoAService{
	
	@Autowired(required = true)
	IAsignadoADAO iAsignadoADAO;
	
	@Override
	public List<AsignadoA> listAll() {
		return iAsignadoADAO.findAll();
	}

	@Override
	public AsignadoA add(AsignadoA asignadoA) {
		return iAsignadoADAO.save(asignadoA);
	}

	@Override
	public AsignadoA getOne(int id) {
		return iAsignadoADAO.findById(id).get();
	}

	@Override
	public AsignadoA update(AsignadoA asignadoA) {
		return iAsignadoADAO.save(asignadoA);
	}

	@Override
	public void eliminar(int id) {
		iAsignadoADAO.deleteById(id);
	}

}
