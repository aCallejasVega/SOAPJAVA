package com.in28minutes.soap.webservices.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServicesConfiguration {

	@Bean
	ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);

		return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
	}

	@Bean(name = "curses")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema coursesSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();

		definition.setPortTypeName("CoursePort");
		definition.setTargetNamespace("http://in28minutes.com/curses");
		definition.setLocationUri("/ws");
		definition.setSchema(coursesSchema);

		return definition;
	}

	@Bean
	XsdSchema coursesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("curses-details.xsd"));
	}

	@Bean(name = "personas")
	public DefaultWsdl11Definition defaultWsdlPersona(XsdSchema personaSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();

		definition.setPortTypeName("PersonasPort");
		definition.setTargetNamespace("http://in28minutes.com/personas");
		definition.setLocationUri("/ws");
		definition.setSchema(personaSchema);

		return definition;
	}

	@Bean
	XsdSchema personaSchema() {
		return new SimpleXsdSchema(new ClassPathResource("personas-details.xsd"));
	}
}
