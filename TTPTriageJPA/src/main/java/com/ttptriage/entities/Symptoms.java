package com.ttptriage.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Symptoms {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int symptomsId;

	@Column(name = "body_part")
	private String bodyPart;

	private String injury;
	
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "person_id")
	private Person person;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	public Symptoms() {
		
	}

	public Symptoms(Integer symptomsId, String bodyPart, String injury, Person person) {
		this.symptomsId = symptomsId;
		this.bodyPart = bodyPart;
		this.injury = injury;
		this.person = person;
	}

	@Override
	public String toString() {
		return "Symptoms [symptomsId=" + symptomsId + ", bodyPart=" + bodyPart + ", injury=" + injury + ", person="
				+ person + ", timestamp=" + timestamp + "]";
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getSymptomsId() {
		return symptomsId;
	}

	public void setSymptomsId(Integer symptomsId) {
		this.symptomsId = symptomsId;
	}

	public String getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}

	public String getInjury() {
		return injury;
	}

	public void setInjury(String injury) {
		this.injury = injury;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
