package com.in28minutes.soap.webservices.personas;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.in28minutes.personas.EstadoCivil;
import com.in28minutes.personas.PersonaDetails;
import com.in28minutes.personas.PersonasFindByIdRequest;
import com.in28minutes.personas.PersonasFindByIdResponse;
import com.in28minutes.personas.Sexo;
import com.in28minutes.soap.webservices.personas.bean.Personas;
import com.in28minutes.soap.webservices.personas.soap.service.PersonasDetailsService;

@Endpoint
public class PersonaDetailsEndPoint {

	@Autowired
	private PersonasDetailsService personasServices;

	@PayloadRoot(namespace = "http://in28minutes.com/personas", localPart = "PersonasFindByIdRequest")
	@ResponsePayload
	public PersonasFindByIdResponse personaFindById(@RequestPayload PersonasFindByIdRequest request) {
		PersonasFindByIdResponse response = new PersonasFindByIdResponse();

		Personas persona = this.personasServices.findById(request.getIdPersona());
		response.setPersonaDetails(mapPersonaDetalle(persona));
		return response;

	}

	public PersonaDetails mapPersonaDetalle(Personas persona) {
		PersonaDetails p = new PersonaDetails();
		p.setIdPersona(persona.getIdPersona());
		p.setNombres(persona.getNombres());
		p.setPaterno(persona.getPaterno());
		p.setMaterno(persona.getMaterno());
		p.setFechaNacimiento(toCalendar(persona.getFechaNacimiento()));
		p.setDireccion(persona.getDireccion());
		p.setTelefono(persona.getTelefono());
		if (persona.getSexo() == "M") {
			p.setSexo(Sexo.M);
		} else {
			p.setSexo(Sexo.F);
		}
		if (persona.getEstadoCivil().equals("C")) {
			p.setEstadoCivil(EstadoCivil.C);
		} else if (persona.getEstadoCivil().equals("S")) {
			p.setEstadoCivil(EstadoCivil.S);
		} else {
			p.setEstadoCivil(EstadoCivil.V);
		}
		p.setActivo(persona.getActivo());
		p.setSalario(persona.getSalario());

		return p;
	}

	public static XMLGregorianCalendar toCalendar(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		XMLGregorianCalendar dateCalendar = null;
		try {
			dateCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (DatatypeConfigurationException e) {

			e.printStackTrace();
		}
		return dateCalendar;
	}

}
