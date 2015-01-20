package ws.firstday.bean;

import java.util.ArrayList;
import java.util.List;


public class Etudiant {
	
	String name = "default";
	boolean enTravail = false;
	List<String> competences = new ArrayList<String>();

	public Etudiant(){
		competences.add("C++");
		competences.add("Java");
	}
	
	public List<String> getCompetences() {
		return competences;
	}

	public void setCompetences(List<String> competences) {
		this.competences = competences;
	}

	public boolean isEnTravail() {
		return enTravail;
	}

	public void setEnTravail(boolean enTravail) {
		this.enTravail = enTravail;
	}

	public String getNom() {
		return name;
	}

	public void setNom(String nom) {
		this.name = nom;
	}
	
}
