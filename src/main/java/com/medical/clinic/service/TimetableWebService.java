package com.medical.clinic.service;

import com.medical.clinic.model.ClinicTimetable;
import com.medical.clinic.repository.AdmissionTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.jws.WebMethod;

public class TimetableWebService {

    @Autowired
    private final AdmissionTicketRepository repository;

    public TimetableWebService(AdmissionTicketRepository repository) {
        this.repository = repository;
    }

    @WebMethod(operationName = "timetable")
    public ClinicTimetable getTimeTable() {
        TimetableCreateService service = new TimetableCreateService(repository);
        return service.createTimetable();
    }
}