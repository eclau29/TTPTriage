package com.ttptriage.entities;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ttptriage.enums.Severity;

@Entity
public class Vitals {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "diastolic_bp")
	private Integer diastolicBloodPressure;
	
	@Column(name = "systolic_bp")
	private Integer systolicBloodPressure;
	
	private Integer pulse;
	
	@Column(name = "resp_rate")
	private Integer respirationRate;
	
	@Column(name = "pulse_ox")
	private Integer pulseOx;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	@Enumerated(EnumType.STRING)
	private Severity severity;
	
	@ManyToOne( cascade = { CascadeType.PERSIST})
	@JsonIgnore
	@JoinColumn(name = "person_id")
	private Person person;
	
	private double latitude;
	
	private double longitude;
	

	
	public Vitals() {
	}
	

	public Vitals(int id, Integer diastolicBloodPressure, Integer systolicBloodPressure, Integer pulse,
			Integer respirationRate, Integer pulseOx, Date timestamp, Severity severity, Person person) {
		this.id = id;
		this.diastolicBloodPressure = diastolicBloodPressure;
		this.systolicBloodPressure = systolicBloodPressure;
		this.pulse = pulse;
		this.respirationRate = respirationRate;
		this.pulseOx = pulseOx;
		this.timestamp = timestamp;
		this.severity = severity;
		this.person = person;
	}

	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getDiastolicBloodPressure() {
		return diastolicBloodPressure;
	}

	public void setDiastolicBloodPressure(Integer diastolicBloodPressure) {
		this.diastolicBloodPressure = diastolicBloodPressure;
	}

	public Integer getSystolicBloodPressure() {
		return systolicBloodPressure;
	}

	public void setSystolicBloodPressure(Integer systolicBloodPressure) {
		this.systolicBloodPressure = systolicBloodPressure;
	}

	public Integer getPulse() {
		return pulse;
	}

	public void setPulse(Integer pulse) {
		this.pulse = pulse;
	}

	public Integer getRespirationRate() {
		return respirationRate;
	}

	public void setRespirationRate(Integer respirationRate) {
		this.respirationRate = respirationRate;
	}

	public Integer getPulseOx() {
		return pulseOx;
	}

	public void setPulseOx(Integer pulseOx) {
		this.pulseOx = pulseOx;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
