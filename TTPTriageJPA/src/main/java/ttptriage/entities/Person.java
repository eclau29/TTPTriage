package ttptriage.entities;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String location;
	
//	@Column(name = "vitals_id")
//	private Integer vitalsId;
	
	@OneToOne(mappedBy = "person")
	private PersonalInfo personalInfo;
	
	@Column(name = "gps_location")
	private String gpsLocation;
	
	@Column(name = "initial_eval_time")
	private Timestamp initialEvalTime;
	
	private String gender;
	
	@OneToMany(mappedBy = "person")
	private List<Vitals> vitalsList;
	
	@OneToMany(mappedBy = "person", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Symptoms> symptomsList;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "cat_id")
	private Integer catastrophe;

	public Person() {
	}

	public Person(Integer id, String location, 
//			Integer vitalsId, 
			String gpsLocation, Timestamp initialEvalTime,
			String gender, PersonalInfo personalInfo, Integer catastrophe) {
		this.id = id;
		this.location = location;
//		this.vitalsId = vitalsId;
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

//	public Integer getVitalsId() {
//		return vitalsId;
//	}
//
//	public void setVitalsId(Integer vitalsId) {
//		this.vitalsId = vitalsId;
//	}

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

	public Integer getCatastrophe() {
		return catastrophe;
	}

	public void setCatastrophe(Integer catastrophe) {
		this.catastrophe = catastrophe;
	}
}
