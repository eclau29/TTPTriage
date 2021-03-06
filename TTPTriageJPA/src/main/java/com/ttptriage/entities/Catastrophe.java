package com.ttptriage.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Catastrophe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cat_id")
	private int catId;

	@Column(name = "cat_name")
	private String catName;
	
	@Column(name = "cat_latitude")
	private Double catLatitude;
	
	@Column(name = "cat_longitude")
	private Double catLongitude;
	
	@OneToMany(mappedBy = "catastrophe", cascade = { CascadeType.PERSIST}, fetch = FetchType.EAGER)
	private List<Person> victims;
	
	public Catastrophe() {
		super();
	}

	public Catastrophe(int catId, String catName, Double catLatitude, Double catLongitude) {
		super();
		this.catId = catId;
		this.catName = catName;
		this.catLatitude = catLatitude;
		this.catLongitude = catLongitude;
	}

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Double getCatLatitude() {
		return catLatitude;
	}

	public void setCatLatitude(Double catLatitude) {
		this.catLatitude = catLatitude;
	}

	public Double getCatLongitude() {
		return catLongitude;
	}

	public void setCatLongitude(Double catLongitude) {
		this.catLongitude = catLongitude;
	}

	public List<Person> getVictims() {
		return victims;
	}

	public void setVictims(List<Person> victims) {
		this.victims = victims;
	}
	
	
}
