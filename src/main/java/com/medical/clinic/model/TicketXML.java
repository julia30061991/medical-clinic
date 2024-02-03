package com.medical.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.datatype.XMLGregorianCalendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketXML {
    private Integer id;
    private Integer doctorID;
    private Integer patientID;
    private XMLGregorianCalendar date;
    private XMLGregorianCalendar timeStart;
    private Boolean reserve;
}
