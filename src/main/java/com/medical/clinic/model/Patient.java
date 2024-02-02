package com.medical.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "INT")
    private int id;

    @Column(name = "uuid", nullable = false, updatable = false)
    private UUID uuid;

    @Column(name = "full_name", columnDefinition = "VARCHAR(255)")
    private String fullName;

    @Column(name = "birthday_date", columnDefinition = "DATE")
    private Date birthdayDate;

    @Column(name = "phone_number", columnDefinition = "VARCHAR(255)")
    private String phoneNumber;

    @Override
    public String toString() {
        return "Пациент: " + fullName + ", идентификатор: " + uuid +
                ", дата рождения: " + birthdayDate + " контактный номер: " + phoneNumber;
    }
}
