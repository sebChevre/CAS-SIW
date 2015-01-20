/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas.ict.wsj.blog;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author seb
 */
@WebService(serviceName = "BlogWS")
public class BlogWS {

    
    private static List<Auteur> AUTEURS = new ArrayList<Auteur>();
    private static List<Message> MESSAGES = new ArrayList<Message>();
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "listAuthors")
    public List<Auteur> listAuthors(){
        return AUTEURS;
    }
    
    @WebMethod(operationName = "addAuthor")
    public boolean addAuthor(
            @WebParam(name = "pseudo") String pseudo,
            @WebParam(name = "firstName") String firstName,
            @WebParam(name = "lastName") String lastName){
        
        AUTEURS.add(new Auteur(firstName,lastName,pseudo));
        
        return true;
    }
    
    @WebMethod(operationName = "removeAuthor")
    public boolean removeAuthor(@WebParam(name = "author") String pseudo){
        for(Auteur auteur : AUTEURS){
            if(auteur.getSeudo().equals(pseudo)){
                AUTEURS.remove(auteur);
                return true;
            }
        }
        
        return false;
    }
    
    @WebMethod(operationName = "listMessages")
    public List<Message> listMessages() {
        return MESSAGES;
    }
    
    @WebMethod(operationName = "addMessage")
    public boolean addMesage(
            @WebParam(name = "author") String pseudo,
            @WebParam(name = "title") String title,
            @WebParam(name = "content") String content){
        
        Message m = new Message();
        m.setAuteur(null);
        m.setDescription(content);
        m.setTitre(title);
        
        MESSAGES.add(m);
        
        return true;
    }
    
    @WebMethod(operationName = "removeMessage")
    public boolean removeMessage(
        @WebParam(name = "message") String title){
        
        for(Message m : MESSAGES){
            if(m.getTitre().equals(title)){
                MESSAGES.remove(m);
                return true;
            }
        }
        
        return false;
    }
    
    
}
