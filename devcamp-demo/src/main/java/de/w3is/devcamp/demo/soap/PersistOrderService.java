package de.w3is.devcamp.demo.soap;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import de.w3is.devcamp.demo.ProcessStarter;

@WebService
@SOAPBinding(style = Style.RPC)
public class PersistOrderService {
	
	@Inject
	private ProcessStarter processStarter;
	
	@WebMethod
	@WebResult(name = "processId")
	public String persistOrder(@WebParam(name = "firstName") String firstName, 
			@WebParam(name = "lastName") String lastName, 
			@WebParam(name = "orderId") String orderId){
		
		return processStarter.startProcess(firstName, lastName, orderId);
	}
}
