package com.in28minutes.soap.webservices.soap;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.in28minutes.curses.CourseDetails;
import com.in28minutes.curses.DeleteCourseDetailsRequest;
import com.in28minutes.curses.DeleteCourseDetailsResponse;
import com.in28minutes.curses.GetAllCourseDetailsRequest;
import com.in28minutes.curses.GetAllCourseDetailsResponse;
import com.in28minutes.curses.GetCourseDetailsRequest;
import com.in28minutes.curses.GetCourseDetailsResponse;
import com.in28minutes.soap.webservices.bean.Curses;
import com.in28minutes.soap.webservices.soap.exception.CourseNotFoundException;
import com.in28minutes.soap.webservices.soap.service.CourseDetatailsService;
import com.in28minutes.soap.webservices.soap.service.CourseDetatailsService.Status;

@Endpoint
public class CurseDetailsEndPoint  {

	@Autowired
	private CourseDetatailsService courseDetatailsService;

	@PayloadRoot(namespace = "http://in28minutes.com/curses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRecuest(@RequestPayload GetCourseDetailsRequest request) {
		Curses curses = this.courseDetatailsService.findById(request.getId());
		if(curses==null) {
			throw new CourseNotFoundException("Invalid Course Id : "+request.getId());
		}
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		response.setCourseDetails(mapCourse(curses));
		return response;

	}

	@PayloadRoot(namespace = "http://in28minutes.com/curses", localPart = "GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsRecuest(
			@RequestPayload GetAllCourseDetailsRequest request) {
		List<Curses> curses = this.courseDetatailsService.findAll();
		return mapAllCourseDetails(curses);

	}

	public CourseDetails mapCourse(Curses course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		response.setCourseDetails(courseDetails);
		return courseDetails;

	}

	public GetAllCourseDetailsResponse mapAllCourseDetails(List<Curses> courses) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		for (Curses course : courses) {
			CourseDetails mapCourse = mapCourse(course);
			response.getCourseDetails().add(mapCourse);
		}

		return response;

	}
	
	
	@PayloadRoot(namespace = "http://in28minutes.com/curses", localPart = "DeleteCourseDetailsRequest")
	@ResponsePayload
	public DeleteCourseDetailsResponse deleteCourseDetailsRequest(
			@RequestPayload DeleteCourseDetailsRequest request) {
		DeleteCourseDetailsResponse response=new DeleteCourseDetailsResponse();
		Status status = this.courseDetatailsService.deleteById(request.getId());
		response.setStatus(mapStatus(status));
		return response;

	}

	private com.in28minutes.curses.Status mapStatus(Status status) {
		if(status==Status.FAILURE)
			return com.in28minutes.curses.Status.FAILURE;
		return com.in28minutes.curses.Status.SUCCESS;
	}

}
