package de.w3is.devcamp.demo.bpm;

import javax.inject.Inject;
import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;

import de.w3is.devcamp.demo.persistence.OrderDao;
import de.w3is.devcamp.demo.persistence.OrderVo;

@Named("persistOrderDelegate")
public class PersistOrder implements JavaDelegate {

	@Inject
	private Logger log;
	
	@Inject
	private OrderDao orderDao;
	
	@Inject
	private OrderVo order;
	
	@Override
	public void execute(DelegateExecution delegateExecution) throws Exception {
		log.info("persist order");
		
		orderDao.persist(order);
	}

}
