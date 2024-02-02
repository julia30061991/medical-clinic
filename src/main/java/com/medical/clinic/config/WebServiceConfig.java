package com.medical.clinic.config;

import com.medical.clinic.service.TimetableWebService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * Configuration for SOAP WebService.
 */

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint timetableEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new TimetableWebService());
        endpoint.publish("/timetable");
        return endpoint;
    }
}