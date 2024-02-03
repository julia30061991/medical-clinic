package com.medical.clinic.service;

import com.medical.clinic.model.AdmissionTicket;
import com.medical.clinic.model.ClinicTimetable;
import com.medical.clinic.model.TicketXML;
import com.medical.clinic.repository.AdmissionTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class TimetableCreateService {
    private LocalTime timeStart = LocalTime.of(8, 0);
    private LocalTime timeEnd = LocalTime.of(18, 0);

    @Autowired
    private final AdmissionTicketRepository repository;

    public TimetableCreateService(AdmissionTicketRepository repository) {
        this.repository = repository;
    }

    public ClinicTimetable createTimetable() {
        ClinicTimetable timetableClinic = new ClinicTimetable();
        TicketCreateService ticketCreateService = new TicketCreateService(repository);
        try {
            List<AdmissionTicket> ticketsAdm = ticketCreateService.createTickets();
            timetableClinic.setDate(convertDateToXMLGCalendar(LocalDate.now()));
            timetableClinic.setTicketCount(ticketsAdm.size());
            timetableClinic.setStart(convertTimeToXMLGCalendar(timeStart));
            timetableClinic.setEnd(convertTimeToXMLGCalendar(timeEnd));
            timetableClinic.setTickets(mapTickets(ticketsAdm));
            return timetableClinic;
        } catch (DatatypeConfigurationException e) {
            e.getMessage();
        }
        return timetableClinic;
    }

    private XMLGregorianCalendar convertDateToXMLGCalendar(LocalDate date) throws DatatypeConfigurationException {
        XMLGregorianCalendar newDate = DatatypeFactory.newInstance().newXMLGregorianCalendar();
        newDate.setYear(date.getYear());
        newDate.setMonth(date.getMonthValue());
        newDate.setDay(date.getDayOfMonth());
        return newDate;
    }

    private XMLGregorianCalendar convertTimeToXMLGCalendar(LocalTime time) throws DatatypeConfigurationException {
        int timezone = 0;
        XMLGregorianCalendar XMLTime = DatatypeFactory.newInstance()
                .newXMLGregorianCalendarTime(time.getHour(), time.getMinute(), time.getSecond(), timezone);
        return XMLTime;
    }

    private List<TicketXML> mapTickets (List<AdmissionTicket> listAdmissionTickets) throws DatatypeConfigurationException {
        List<TicketXML> ticketXmlList = new ArrayList<>();
        for(AdmissionTicket ticket: listAdmissionTickets) {
            TicketXML ticketXML = new TicketXML();
            ticketXML.setDate(convertDateToXMLGCalendar(ticket.getDate()));
            ticketXML.setTimeStart(convertTimeToXMLGCalendar(ticket.getTimeStart()));
            ticketXmlList.add(ticketXML);
        }
        return ticketXmlList;
    }
}