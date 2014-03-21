package de.w3is.devcamp.demo.persistence;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;

@Stateless
public class OrderDao  {
	
	@Inject
	private Logger log;
	
	public void persist(OrderVo order) {
		log.info("Persist Order | lastName=" + order.getLastName() + " | firstName=" + order.getFirstName() + " | orderId=" + order.getId());
	}
}
