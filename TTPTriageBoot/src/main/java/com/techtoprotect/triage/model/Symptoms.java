package com.techtoprotect.triage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Symptoms {
    @Id
    @Column(name = "symptoms_id")
    private Integer symptomsId;

    @Column(name = "body_part")
    private String bodyPart;

    private String injury;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Symptoms(Integer symptomsId, String bodyPart, String injury, Person person) {
        this.symptomsId = symptomsId;
        this.bodyPart = bodyPart;
        this.injury = injury;
        this.person = person;
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
