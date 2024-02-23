package com.medical.clinic.micro.service;

import com.medical.clinic.micro.model.AdmissionTicket;

import java.time.LocalDate;
import java.util.List;

public interface ReceivingTicketService {

    boolean reserveTicket(int id);

    List<AdmissionTicket> getAllPatientTickets(int patientID);

    List<AdmissionTicket> getAllFreeTickets(int doctorID, LocalDate date);
}