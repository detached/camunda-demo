package de.w3is.devcamp.demo;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.camunda.bpm.engine.cdi.BusinessProcess;
import org.slf4j.Logger;

@Stateless
public class ProcessStarter {
	
	private final static String PROCESS_NAME = "persist-order-1.0";
	
	@Inject
	private Logger log;
	
	@Inject
	private BusinessProcess businessProcess;
	
	public String startProcess(String firstName, String lastName, String orderId) {
		
		
		log.info("Start " + PROCESS_NAME + " | firstName=" + firstName + " | lastName=" + lastName +  " | orderId=" + orderId);
				
		businessProcess.setVariable(ProcessVariables.FIRST_NAME, firstName);
		businessProcess.setVariable(ProcessVariables.LAST_NAME, lastName);
		businessProcess.setVariable(ProcessVariables.ORDER_ID, orderId);
		
		return businessProcess.startProcessByKey(PROCESS_NAME, orderId).getId();
	}
}

