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
@Table(name="proyecto")
public class Proyecto {
	
	@Id
	private String id;
	private String nombre;
	private int horas;
	
	@OneToMany
    @JoinColumn(name = "id_proyecto")
	@JsonIgnore
	private List<AsignadoA> asignado_a;
	
	public Proyecto() {
		
	}

	public Proyecto(String id, String nombre, int horas, List<AsignadoA> asignado_a) {
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
		this.asignado_a = asignado_a;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_proyecto")
	public List<AsignadoA> getAsignadoA() {
		return asignado_a;
	}

	public void setAsignadoA(List<AsignadoA> asignado_a) {
		this.asignado_a = asignado_a;
	}
	
}
