//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.03.04 a las 06:55:09 PM BOT 
//


package com.in28minutes.personas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PersonaDetails" type="{http://in28minutes.com/personas}PersonaDetails"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "personaDetails"
})
@XmlRootElement(name = "PersonasFindByIdResponse")
public class PersonasFindByIdResponse {

    @XmlElement(name = "PersonaDetails", required = true)
    protected PersonaDetails personaDetails;

    /**
     * Obtiene el valor de la propiedad personaDetails.
     * 
     * @return
     *     possible object is
     *     {@link PersonaDetails }
     *     
     */
    public PersonaDetails getPersonaDetails() {
        return personaDetails;
    }

    /**
     * Define el valor de la propiedad personaDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonaDetails }
     *     
     */
    public void setPersonaDetails(PersonaDetails value) {
        this.personaDetails = value;
    }

}