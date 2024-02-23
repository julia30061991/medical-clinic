package com.medical.clinic.micro.service;

import com.medical.clinic.micro.model.AdmissionTicket;
import com.medical.clinic.micro.repository.AdmissionTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceivingTicketServiceImpl implements ReceivingTicketService {

    private final AdmissionTicketRepository repository;

    @Autowired
    public ReceivingTicketServiceImpl(AdmissionTicketRepository repository) {
        this.repository = repository;
    }

    public boolean reserveTicket(int ticketID) {
        AdmissionTicket ticket;
        boolean res = false;
        if (repository.findById(ticketID) != null) {
            if (!repository.findById(ticketID).isReserve()) {
                ticket = repository.getById(ticketID);
                ticket.setReserve(true);
                repository.save(ticket);
                res = true;
            }
        }
        return res;
    }

    public List<AdmissionTicket> getAllPatientTickets(int patientID) {
        return repository.findAllByPatientId(patientID);
    }

    public List<AdmissionTicket> getAllFreeTickets(int doctorID, LocalDate date) {
        List<AdmissionTicket> list = repository.findAllByDoctorIdAndDate(doctorID, date);
        List<AdmissionTicket> result = new ArrayList<>();
        for (AdmissionTicket ticket : list) {
            if (!ticket.isReserve()) {
                result.add(ticket);
            }
        }
        return result;
    }
}