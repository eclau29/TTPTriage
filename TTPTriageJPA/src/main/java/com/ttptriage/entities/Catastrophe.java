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

	@Column(name = "cat_location")
	private String catLocaton;
	
	@OneToMany(mappedBy = "catastrophe", cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	private List<Person> victims;
	
	public Catastrophe() {
		super();
	}

	public Catastrophe(Integer catId, String catName, String catLocaton) {
		super();
		this.catId = catId;
		this.catName = catName;
		this.catLocaton = catLocaton;
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

	public String getCatLocaton() {
		return catLocaton;
	}

	public void setCatLocaton(String catLocaton) {
		this.catLocaton = catLocaton;
	}

	public List<Person> getVictims() {
		return victims;
	}

	public void setVictims(List<Person> victims) {
		this.victims = victims;
	}
	
	
}
