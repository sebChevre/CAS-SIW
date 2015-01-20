/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author seb
 */
@ManagedBean(name="test")
public class AuteursManagedBeans {
   
    public AuteursManagedBeans(){}
    
    public int getCallWebServices () {
        return listAuthors().size();
    }

    private static boolean addAuthor(java.lang.String pseudo, java.lang.String firstName, java.lang.String lastName) {
        jsf.BlogWS_Service service = new jsf.BlogWS_Service();
        jsf.BlogWS port = service.getBlogWSPort();
        return port.addAuthor(pseudo, firstName, lastName);
    }

    private static java.util.List<jsf.Auteur> listAuthors() {
        jsf.BlogWS_Service service = new jsf.BlogWS_Service();
        jsf.BlogWS port = service.getBlogWSPort();
        return port.listAuthors();
    }
}
