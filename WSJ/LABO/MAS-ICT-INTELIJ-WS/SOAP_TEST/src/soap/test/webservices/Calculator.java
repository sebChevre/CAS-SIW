package soap.test.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by seb on 06.11.14.
 */

@WebService(serviceName = "calculator")
public class Calculator {

	public Calculator(){};

	@WebMethod(operationName = "multiplication")
    public String multiplication (float valeur1, float valeur2){
        return String.valueOf(valeur1 * valeur2);
    }


}
