package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICientificoDAO;
import com.example.demo.dto.Cientifico;

@Service
public class CientificoService implements ICientificoService{
	
	@Autowired(required = true)
	ICientificoDAO iCientificoDAO;
	
	@Override
	public List<Cientifico> listAll() {
		return iCientificoDAO.findAll();
	}

	@Override
	public Cientifico add(Cientifico cientifico) {
		return iCientificoDAO.save(cientifico);
	}

	@Override
	public Cientifico getOne(String dni) {
		return iCientificoDAO.findById(dni).get();
	}

	@Override
	public Cientifico update(Cientifico cientifico) {
		return iCientificoDAO.save(cientifico);
	}

	@Override
	public void eliminar(String dni) {
		iCientificoDAO.deleteById(dni);
	}

}
