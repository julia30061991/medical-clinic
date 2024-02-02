package com.medical.clinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter (value = AccessLevel.PUBLIC)
@Setter (value = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "INT")
    private int id;
    @Column(name = "uuid", nullable = false, updatable = false)
    private UUID uuid;
    @Column(name = "full_name", columnDefinition = "VARCHAR(255)")
    private String fullName;
    @Column(name = "speciality")
    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    @Override
    public String toString() {
        return "Врач: " + fullName + ", идентификатор: " + uuid + ", специальность: " + speciality;
    }
}
