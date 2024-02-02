package com.medical.clinic.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Embeddable
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@NoArgsConstructor
@Table(name = "tickets")
public class AdmissionTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "INT")
    private int id;
    @Column(name = "doctor_id", columnDefinition = "INT")
    private int doctorID;
    @Column(name = "patient_id", columnDefinition = "INT")
    private int patientID;
    @Column(name = "date", columnDefinition = "DATE")
    private LocalDate date;
    @Column(name = "time", columnDefinition = "TIME")
    private LocalTime timeStart;
    @Column(name = "reserve", columnDefinition = "BOOLEAN")
    private boolean reserve;

    @Override
    public String toString() {
        return "Идентификатор талона: " + id + " , id врача: " + doctorID + " , id пациента: " + patientID +
                ", начало приема: " + date + " " + timeStart;
    }
}