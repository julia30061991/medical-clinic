package com.medical.clinic.micro.repository;

import com.medical.clinic.micro.model.Doctor;
import com.medical.clinic.micro.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    //поиск врача по id
    Doctor getDoctorById(int id);

    //поиска врача по uuid
    Doctor getDoctorByUuid(UUID uuid);

    //поиск врача определенной специальности
    Doctor getDoctorBySpeciality(Speciality speciality);

    //список всех врачей определенной специальности
    List<Doctor> findAllBySpeciality(Speciality speciality);

    //список всех врачей клиники
    @Override
    List<Doctor> findAll();
}