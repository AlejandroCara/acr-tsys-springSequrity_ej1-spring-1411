package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cientifico")
public class Cientifico {
	
	@Id
	private String dni;
	private String nomapels;
	
	@OneToMany
    @JoinColumn(name = "dni_cientifico")
	private List<AsignadoA> asignado_a;
	
	public Cientifico() {
		
	}

	public Cientifico(String dni, String nomapels, List<AsignadoA> asignado_a) {
		super();
		this.dni = dni;
		this.nomapels = nomapels;
		this.asignado_a = asignado_a;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomapels() {
		return nomapels;
	}

	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dni_cientifico")
	public List<AsignadoA> getAsignadoA() {
		return asignado_a;
	}

	public void setAsignadoA(List<AsignadoA> asignado_a) {
		this.asignado_a = asignado_a;
	}
	
	
}
