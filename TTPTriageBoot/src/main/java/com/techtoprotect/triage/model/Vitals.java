package com.techtoprotect.triage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techtoprotect.triage.enums.Severity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Vitals {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer vitalsId;
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
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "person_id")
    private Person person;

    public Vitals() {
    }

    public Vitals(Integer vitalsId, Integer diastolicBloodPressure, Integer systolicBloodPressure, Integer pulse, Integer respirationRate, Integer pulseOx, Timestamp timestamp, Severity severity, Person person) {
        this.vitalsId = vitalsId;
    	this.diastolicBloodPressure = diastolicBloodPressure;
        this.systolicBloodPressure = systolicBloodPressure;
        this.pulse = pulse;
        this.respirationRate = respirationRate;
        this.pulseOx = pulseOx;
        this.timestamp = timestamp;
        this.severity = severity;
        this.person = person;
    }

    public Integer getVitalsId() {
        return vitalsId;
    }

    public void setVitalsId(Integer vitalsId) {
        this.vitalsId = vitalsId;
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
