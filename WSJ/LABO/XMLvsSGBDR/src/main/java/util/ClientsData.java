package util;

/**
 * Created by sce on 09.09.14.
 */
public enum ClientsData {

	CLIENTS1("Dubois","Jacques","Rue du Moulin","Moutier"),
	CLIENTS2("Beuret","Nicole","Rue du Moulin","Delémont"),
	CLIENTS3("Dubois","Michel","Rue du Moulin","Delémont"),
	CLIENTS4("Robert","Pascal","Rue du Moulin","Delémont"),
	CLIENTS5("Gogniat","David","Rue du Moulin","Moutier"),
	CLIENTS6("Gogniat","Edourad","Rue du Moulin","Delémont"),
	CLIENTS7("Marquis","William","Rue du Moulin","Moutier"),
	CLIENTS8("Chèvre","Jacques","Rue du Moulin","Moutier"),
	CLIENTS9("Boillat","Pénéloppe","Rue du Moulin","Delémont"),
	CLIENTS10("Boillat","François","Rue du Moulin","Moutier"),
	CLIENTS11("Boillat","Eugénie","Rue du Moulin","Genève"),
	CLIENTS12("Dubois","Jacky","Rue du Moulin","Genève"),
	CLIENTS13("Wirz","Albert","Rue du Moulin","Genève"),
	CLIENTS14("Wirz","Eugénie","Rue du Moulin","Zurich"),
	CLIENTS15("Hertz","Jean","Rue du Moulin","Moutier"),
	CLIENTS16("Balestedt","Daniel","Rue du Moulin","Delémont"),
	CLIENTS17("Moritz","Claude","Rue du Moulin","Delémont"),
	CLIENTS18("Schaller","Claude","Rue du Moulin","Zurich"),
	CLIENTS19("Crelier","Jacques","Rue du Moulin","Delémont"),
	CLIENT20("Dubois","Noelle","Rue du Moulin","Moutier"),
	CLIENTS21("Mory","Dadi","Rue du Moulin","Zurich"),
	CLIENTS22("Mory","Jacques","Rue du Moulin","Bressaucourt"),
	CLIENTS23("Dubois","James","Rue du Moulin","Zurich"),
	CLIENTS24("Deruuns","Jacques","Rue du Moulin","Bressaucourt"),
	CLIENTS25("Sandoz","Yves","Rue du Moulin","Vicques"),
	CLIENTS26("Zingg","Frédéric","Rue du Moulin","Zurich"),
	CLIENTS27("Dubois","Frédérique","Rue du Moulin","Vicques"),
	CLIENTS28("Wrener","Hans","Rue du Moulin","Bâle"),
	CLIENTS29("Beauséjour","Jacques","Rue du Moulin","Bâle"),
	CLIENTS30("Hallyday","Jacques","Rue du Moulin","Zurich"),
	CLIENTS31("Jeannerat","Jacques","Rue du Moulin","Bâle"),
	CLIENTS32("Gatherat","Françoise","Rue du Moulin","Bâle"),
	CLIENTS33("Dubpond","Yves","Rue du Moulin","Bassecourt"),
	CLIENTS34("Durand","Ethienne","Rue du Moulin","Lucerne"),
	CLIENTS35("Dubois","Isabelle","Rue du Moulin","Zurich");

	public String nom;
	public String prenom;
	public String rue;
	public String localite;

	ClientsData(String nom, String prenom, String rue, String localite){
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.localite = localite;
	}
}
