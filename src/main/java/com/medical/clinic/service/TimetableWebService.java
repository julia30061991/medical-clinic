package com.medical.clinic.service;

import com.medical.clinic.model.AdmissionTicket;
import com.medical.clinic.model.ClinicTimetable;
import com.medical.clinic.repository.AdmissionTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;

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

//    @WebMethod(operationName = "timetable")
//    public ClinicTimetable getTimeTable() throws DatatypeConfigurationException {
//        TimetableCreateService service = new TimetableCreateService();
//        return service.createTimetable();
    }
//}
