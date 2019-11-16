package com.ttptriage.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String location;
	
	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	private PersonalInfo personalInfo;
	
	@Column(name = "gps_location")
	private String gpsLocation;
	
	@CreationTimestamp //Creation of the Person is at the time of initial evaluation
	@Column(name = "initial_eval_time")
	private Timestamp initialEvalTime;
	
	private String gender;
	
	@OneToMany(mappedBy = "person", cascade = { CascadeType.PERSIST})
	private List<Vitals> vitalsList;
	
	@OneToMany(mappedBy = "person", cascade = { CascadeType.PERSIST })
	private List<Symptoms> symptomsList;
	
	@JsonIgnore
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "cat_id")
	private Catastrophe catastrophe;

	@Override
	public String toString() {
		return "Person [id=" + id + ", location=" + location + ", personalInfo=" + personalInfo + ", gpsLocation="
				+ gpsLocation + ", initialEvalTime=" + initialEvalTime + ", gender=" + gender + ", catastrophe="
				+ catastrophe + "]";
	}

	public Person() {
	}

	public Person(Integer id, String location, 
			String gpsLocation, Timestamp initialEvalTime,
			String gender, PersonalInfo personalInfo, Catastrophe catastrophe) {
		this.id = id;
		this.location = location;
		this.gpsLocation = gpsLocation;
		this.initialEvalTime = initialEvalTime;
		this.gender = gender;
		this.personalInfo = personalInfo;
		this.catastrophe = catastrophe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public String getGpsLocation() {
		return gpsLocation;
	}

	public void setGpsLocation(String gpsLocation) {
		this.gpsLocation = gpsLocation;
	}

	public Timestamp getInitialEvalTime() {
		return initialEvalTime;
	}

	public void setInitialEvalTime(Timestamp initialEvalTime) {
		this.initialEvalTime = initialEvalTime;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Vitals> getVitalsList() {
		return vitalsList;
	}

	public void setVitalsList(List<Vitals> vitalsList) {
		this.vitalsList = vitalsList;
	}

	public List<Symptoms> getSymptomsList() {
		return symptomsList;
	}

	public void setSymptomsList(List<Symptoms> symptomsList) {
		this.symptomsList = symptomsList;
	}

	public Catastrophe getCatastrophe() {
		return catastrophe;
	}

	public void setCatastrophe(Catastrophe catastrophe) {
		this.catastrophe = catastrophe;
	}
}
