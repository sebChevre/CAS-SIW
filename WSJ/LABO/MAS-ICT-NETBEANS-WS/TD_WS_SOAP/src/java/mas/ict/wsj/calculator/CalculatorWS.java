/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas.ict.wsj.calculator;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author seb
 */
@WebService(serviceName = "CalculatorWS")
public class CalculatorWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "multiplication")
    public String multiplication(@WebParam(name = "parameter") float parameter, @WebParam(name = "parameter1") float parameter1) {
        //TODO write your implementation code here:
        return String.valueOf(parameter * parameter1);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "disvision")
    public String disvision(@WebParam(name = "parameter") float parameter, @WebParam(name = "parameter1") float parameter1) {
        //TODO write your implementation code here:
        return null;
    }
}
