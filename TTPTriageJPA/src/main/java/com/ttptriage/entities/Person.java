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
	
	@OneToOne(mappedBy = "person", cascade = CascadeType.PERSIST)
	private PersonalInfo personalInfo;
	
	@CreationTimestamp //Creation of the Person is at the time of initial evaluation
	@Column(name = "initial_eval_time")
	private Timestamp initialEvalTime;
	
	private String gender;
	

	

	@Column(name = "barcode_num")
	private String barcodeNum;
	
	@Column(name = "eval_latitude")
	private Double evalLatitude;
	
	@Column(name = "eval_longitude")
	private Double evalLongitude;
	
	@OneToMany(mappedBy = "person", cascade = { CascadeType.PERSIST})

	private List<Vitals> vitalsList;
	
	@OneToMany(mappedBy = "person", cascade = { CascadeType.PERSIST })
	private List<Symptoms> symptomsList;
	
	@JsonIgnore
	@ManyToOne( cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "cat_id")
	private Catastrophe catastrophe;

	@Override
	public String toString() {
		return "Person [id=" + id + ", location=" + location + ", personalInfo=" + personalInfo + ", initialEvalTime="
				+ initialEvalTime + ", gender=" + gender + ", barcodeNum=" + barcodeNum + ", evalLatitude="
				+ evalLatitude + ", evalLongitude=" + evalLongitude + ", catastrophe=" + catastrophe + "]";
	}

	public Person() {
	}

	public Person(int id, String location, PersonalInfo personalInfo, Timestamp initialEvalTime, String gender,
			String barcodeNum, Double evalLatitude, Double evalLongitude, Catastrophe catastrophe) {
		super();
		this.id = id;
		this.location = location;
		this.personalInfo = personalInfo;
		this.initialEvalTime = initialEvalTime;
		this.gender = gender;
		this.barcodeNum = barcodeNum;
		this.evalLatitude = evalLatitude;
		this.evalLongitude = evalLongitude;
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

	public String getBarcodeNum() {
		return barcodeNum;
	}

	public void setBarcodeNum(String barcodeNum) {
		this.barcodeNum = barcodeNum;
	}

	public Double getEvalLatitude() {
		return evalLatitude;
	}

	public void setEvalLatitude(Double evalLatitude) {
		this.evalLatitude = evalLatitude;
	}

	public Double getEvalLongitude() {
		return evalLongitude;
	}

	public void setEvalLongitude(Double evalLongitude) {
		this.evalLongitude = evalLongitude;
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
