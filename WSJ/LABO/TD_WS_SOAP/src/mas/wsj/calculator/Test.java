package mas.wsj.calculator;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by seb on 06.11.14.
 */
@WebService()
public class Test {

    @WebMethod
    public boolean test(String t){
        return true;
    }
}
