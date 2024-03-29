package com.medical.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClinicTimetable {
    private XMLGregorianCalendar start;
    private XMLGregorianCalendar end;
    private XMLGregorianCalendar date;
    private Integer ticketCount;
    private List<TicketXML> tickets;
}