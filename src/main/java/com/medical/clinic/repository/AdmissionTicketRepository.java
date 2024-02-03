package com.medical.clinic.repository;

import com.medical.clinic.model.AdmissionTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AdmissionTicketRepository extends JpaRepository <AdmissionTicket, Long> {

    //поиск талона по id
    AdmissionTicket findById(int id);

    //получение талона по id
    @Lock(LockModeType.PESSIMISTIC_READ)
    AdmissionTicket getById(int id);

    //получение всех выданных талонов
    @Override
    List<AdmissionTicket> findAll();

    //получение всех талонов определенного пациента
    List<AdmissionTicket> findAllByPatientID(int id);

    //получение всех cвободных талонов к врачу
    List<AdmissionTicket> findAllByDoctorIDAndDate(int id, LocalDate date);


}
