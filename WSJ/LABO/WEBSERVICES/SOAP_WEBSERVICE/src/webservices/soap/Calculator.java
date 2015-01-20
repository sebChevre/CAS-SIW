package webservices.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by sce on 10.11.14.
 */
@WebService(serviceName = "Calculator")
public class Calculator {

	@WebMethod(operationName = "multi")
	public String multiplication(@WebParam(name="valeur1")float valeur1, @WebParam(name="valeur2")float valeur2){
		return String.valueOf(valeur1 * valeur2);
	}

}
