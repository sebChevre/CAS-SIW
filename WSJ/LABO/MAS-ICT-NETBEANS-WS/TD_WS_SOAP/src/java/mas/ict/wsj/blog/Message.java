/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas.ict.wsj.blog;

import java.util.Date;

/**
 *
 * @author seb
 */
public class Message {
    
    private Auteur auteur;
    private String titre;
    private String description;
    private Date date;
    
    
    public Message() {}

    public Auteur getAuteur() {
        return auteur;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
    
    
}
