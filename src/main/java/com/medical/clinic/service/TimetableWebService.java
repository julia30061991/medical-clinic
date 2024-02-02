package com.medical.clinic.service;

import com.medical.clinic.model.ClinicTimetable;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * SOAP WebService.
 * Go to http://localhost:8080/timetable?wsdl to get .wsdl file
 */

@WebService(serviceName = "ClinicTimetable")
public class TimetableWebService {

    @WebMethod(operationName = "timetable")
    public ClinicTimetable getTimeTable() throws DatatypeConfigurationException {
        ClinicTimetable timetable = new ClinicTimetable();
        timetable.setDate(convertDateToXMLGCalendar(LocalDate.now()));
        timetable.setStart(convertTimeToXMLGCalendar(LocalTime.of(8,0)));
        timetable.setEnd(convertTimeToXMLGCalendar(LocalTime.of(18,0)));
        timetable.setTicketCount(10);
        return timetable;
//        return service.createTimetable();
    }

    private XMLGregorianCalendar convertDateToXMLGCalendar(LocalDate date) throws DatatypeConfigurationException {
        XMLGregorianCalendar newDate = DatatypeFactory.newInstance().newXMLGregorianCalendar();
        newDate.setYear(date.getYear());
        newDate.setMonth(date.getMonthValue());
        newDate.setDay(date.getDayOfMonth());
        return newDate;
    }

    private XMLGregorianCalendar convertTimeToXMLGCalendar(LocalTime time) throws DatatypeConfigurationException {
        int timezone = 0; //узнать таймзону
        XMLGregorianCalendar XMLTime = DatatypeFactory.newInstance()
                .newXMLGregorianCalendarTime(time.getHour(), time.getMinute(), time.getSecond(), timezone);
        return XMLTime;
    }
}
