package com.in28minutes.soap.webservices.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.soap.webservices.bean.Curses;

@Component
public class CourseDetatailsService {

	public enum Status {
		SUCCESS, FAILURE;
	}

	private static List<Curses> corses = new ArrayList<>();

	static {
		Curses curse1 = new Curses(1, "Spring", "10 Steps");
		corses.add(curse1);

		Curses curse2 = new Curses(2, "Spring MVC", "10 Examples");
		corses.add(curse2);

		Curses curse3 = new Curses(3, "Spring BootC", "for student");
		corses.add(curse3);

		Curses curse4 = new Curses(4, "Angular", "for student");
		corses.add(curse4);
	}

	public Curses findById(int id) {
		for (Curses course : this.corses) {
			if (course.getId() == id) {
				return course;
			}
		}
		return null;
	}

	public List<Curses> findAll() {
		return this.corses;
	}

	public Status deleteById(int id) {
		Iterator<Curses> iterator = this.corses.iterator();
		while (iterator.hasNext()) {
			Curses curse = iterator.next();
			if (curse.getId() == id) {
				iterator.remove();
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;		
	}

}
