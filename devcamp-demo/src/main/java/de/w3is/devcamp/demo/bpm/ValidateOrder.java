package de.w3is.devcamp.demo.bpm;

import javax.inject.Inject;
import javax.inject.Named;

import org.camunda.bpm.engine.cdi.annotation.ProcessVariable;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;

import de.w3is.devcamp.demo.ProcessVariables;
import de.w3is.devcamp.demo.persistence.OrderVo;

@Named("validateOrderDelegate")
public class ValidateOrder implements JavaDelegate {

	@Inject
	private Logger log;

	@Inject
	@ProcessVariable(ProcessVariables.LAST_NAME)
	private Object lastNameProcessVariable;

	@Inject
	@ProcessVariable(ProcessVariables.FIRST_NAME)
	private Object firstNameProcessVariable;

	@Inject
	@ProcessVariable(ProcessVariables.ORDER_ID)
	private Object orderIdProcessVariable;
	
	@Inject
	private OrderVo order;

	@Override
	public void execute(DelegateExecution delegateExecution) throws Exception {

		log.info("validate order | firstName=" + firstNameProcessVariable
				+ " | lastName=" + lastNameProcessVariable + " | orderId="
				+ orderIdProcessVariable);

			String firstName = (String) firstNameProcessVariable;
			String lastName = (String) lastNameProcessVariable;
			String orderId = (String) orderIdProcessVariable;

			if (!firstName.isEmpty() 
					&& !lastName.isEmpty()
					&& !orderId.isEmpty() 
					&& !firstName.equals("Malory")) {
				
				order.setFirstName(firstName);
				order.setLastName(lastName);
				order.setId(orderId);
				
				log.info("order is valid.");
				
				delegateExecution.setVariable(ProcessVariables.IS_ORDER_VALID, true);
				
				return;
			}

		log.info("order is invalid.");
		delegateExecution.setVariable(ProcessVariables.IS_ORDER_VALID, false);
	}
}
