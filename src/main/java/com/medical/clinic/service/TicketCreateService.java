package com.medical.clinic.service;

import com.medical.clinic.model.AdmissionTicket;
import com.medical.clinic.repository.AdmissionTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TicketCreateService {
    private LocalTime timeStart = LocalTime.of(8, 0);
    private LocalTime timeEnd = LocalTime.of(18, 0);

    private final AdmissionTicketRepository repository;

    @Autowired
    public TicketCreateService(AdmissionTicketRepository repository) {
        this.repository = repository;
    }

    public List<AdmissionTicket> createTickets() {
        List<AdmissionTicket> tickets = new ArrayList<>();
        int countTickets = 2 * (timeEnd.getHour() - timeStart.getHour());
        for (int i = 0; i < countTickets; i++) {
            AdmissionTicket ticket = new AdmissionTicket();
            ticket.setDate(LocalDate.now());
            ticket.setReserve(false);
            ticket.setTimeStart(timeStart);
            timeStart = timeStart.plusMinutes(30);
            tickets.add(ticket);
        }
        timeStart = LocalTime.of(8, 0);
        repository.saveAll(tickets);
        return tickets;
    }
}