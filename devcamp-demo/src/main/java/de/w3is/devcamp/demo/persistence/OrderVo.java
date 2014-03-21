package de.w3is.devcamp.demo.persistence;

import java.io.Serializable;

import javax.inject.Named;

import org.camunda.bpm.engine.cdi.annotation.BusinessProcessScoped;

@BusinessProcessScoped
@Named()
public class OrderVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7521617667174298255L;
	
	private String firstName;
	
	private String lastName;
	
	private String id;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String orderId) {
		this.id = orderId;
	}
}
