package com.in28minutes.soap.webservices.personas.soap.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.soap.webservices.personas.bean.Personas;

@Component
public class PersonasDetailsService {

	public enum Status {
		SUCCESS, FAILURE;
	}

	private static List<Personas> personas = new ArrayList<>();

	static {
		Date fechaNac = new Date();
		try {
			fechaNac = new SimpleDateFormat("dd/MM/yyyy").parse("21/09/1983");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Personas p1 = new Personas(1, "Adalid", "Callejas", "Vega", fechaNac, "Av 6 de Agosto nro. 2224", "73591373",
				"M", "S", new BigDecimal("11536.50"), true);

		personas.add(p1);
		Personas p2 = new Personas(1, "David", "Callejas", "Vega", fechaNac, "Av 6 de Agosto nro. 2224", "73591373",
				"M", "S", new BigDecimal("8536.00"), true);

		personas.add(p2);

		Personas p3 = new Personas(1, "Elva", "Callejas", "Vega", fechaNac, "Av 6 de Agosto nro. 2224", "73591373", "M",
				"S", new BigDecimal("7536.00"), true);

		personas.add(p3);
	}

	public List<Personas> findAll() {
		return this.personas;
	}

	public Personas findById(Integer id) {
		for (Personas p : personas) {
			if (p.getIdPersona() == id) {
				return p;
			}
		}
		return null;
	}

	public Status deleteById(Integer id) {
		Iterator<Personas> personas = this.personas.iterator();
		while (personas.hasNext()) {
			Personas p = personas.next();
			if (p.getIdPersona() == id) {
				personas.remove();
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}

}
