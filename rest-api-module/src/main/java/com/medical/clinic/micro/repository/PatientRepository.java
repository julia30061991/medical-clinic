package com.medical.clinic.micro.repository;

import com.medical.clinic.micro.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    //поиск пациента по id
    Patient getPatientById(int id);

    //поиск пациента по uuid
    Patient getPatientByUuid(UUID uuid);

    //поиск пациента по номеру телефона
    Patient getPatientByPhoneNumber(String number);

    //список всех пациентов клиники
    @Override
    List<Patient> findAll();
}