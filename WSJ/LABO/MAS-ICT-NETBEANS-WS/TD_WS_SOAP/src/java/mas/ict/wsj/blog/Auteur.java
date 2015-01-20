/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas.ict.wsj.blog;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author seb
 */
public class Auteur {
    
    private String nom;
    private String prenom;
    private String seudo;
    private List<Message> messages = new ArrayList<Message>();
    
    public Auteur(){}

    
    
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSeudo(String seudo) {
        this.seudo = seudo;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Auteur(String nom, String prenom, String seudo) {
        this.nom = nom;
        this.prenom = prenom;
        this.seudo = seudo;
    }

    public String getSeudo() {
        return seudo;
    }
    
    
    
}
