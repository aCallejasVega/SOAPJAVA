//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.03.04 a las 06:55:09 PM BOT 
//


package com.in28minutes.personas;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.in28minutes.personas package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.in28minutes.personas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PersonasFindByIdRequest }
     * 
     */
    public PersonasFindByIdRequest createPersonasFindByIdRequest() {
        return new PersonasFindByIdRequest();
    }

    /**
     * Create an instance of {@link PersonasFindByIdResponse }
     * 
     */
    public PersonasFindByIdResponse createPersonasFindByIdResponse() {
        return new PersonasFindByIdResponse();
    }

    /**
     * Create an instance of {@link PersonaDetails }
     * 
     */
    public PersonaDetails createPersonaDetails() {
        return new PersonaDetails();
    }

}
