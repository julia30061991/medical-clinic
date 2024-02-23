package com.medical.clinic.micro.controller;

import com.medical.clinic.micro.model.AdmissionTicket;
import com.medical.clinic.micro.service.ReceivingTicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    private final ReceivingTicketServiceImpl service;

    @Autowired
    public RestController(ReceivingTicketServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/v1/ticket/{id}")
    public ResponseEntity<Object> reserveTicket(@PathVariable("id") int id) {
        boolean isOK = service.reserveTicket(id);
        String message = isOK ? "Вы успешно записаны на прием" : "Талон зарезервирован или талона нет в расписании";
        HttpStatus status = isOK ? HttpStatus.OK : HttpStatus.NOT_ACCEPTABLE;
        return new ResponseEntity<>(message, status);
    }

    @GetMapping("/v1/patients/tickets")
    public ResponseEntity<Object> getAllPatientTickets(@RequestParam int patient_id) {
        List<AdmissionTicket> list = service.getAllPatientTickets(patient_id);
        Object info = list.size() > 0 ? list : "У пациента пока нет оформленных талонов";
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @GetMapping("/v1/tickets")
    public ResponseEntity<Object> getFreeTickets(@RequestParam int doctor_id,
                                                 @RequestParam LocalDate date) {
        List<AdmissionTicket> list = service.getAllFreeTickets(doctor_id, date);
        Object info = list.size() > 0 ? list : "Свободных талонов нет";
        return new ResponseEntity<>(info, HttpStatus.OK);
    }
}