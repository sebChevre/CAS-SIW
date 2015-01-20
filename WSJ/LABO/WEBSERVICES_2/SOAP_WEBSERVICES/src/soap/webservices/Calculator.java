package soap.webservices;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by sce on 11.11.2014.
 */
@WebService(serviceName = "calculator")
public class Calculator {

  @WebMethod(operationName = "multi")
  public String multiplication(@WebParam(name = "valeur1")float valeur1,@WebParam(name = "valeur2") float valeur2) {
    return String.valueOf(valeur1 * valeur2);
  }


  public static void main(String[] argv) {
    Object implementor = new Calculator ();
    String address = "http://localhost:9000/Calculator";
    Endpoint.publish(address, implementor);
  }
}
