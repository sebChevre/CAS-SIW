package filler;

import dao.ClientDAO;
import dao.CommandeDAO;
import dao.LigneCommandeDAO;
import dao.ProduitDAO;
import data.Client;
import data.Commande;
import data.LigneCommande;
import data.Produit;
import util.Util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sce on 10.09.14.
 */
public class CommandeFiller {

	static List<Client> alLClients;
	static List<Produit> allProduit;

	static{
		alLClients = new ClientDAO().findAll();
		allProduit = new ProduitDAO().findAll();
	}

	public static void main(String[] args) {


	}

	public static void fillCommande(int nbre){

		for(int cpt=0;cpt<nbre;cpt++){
			fillOneCommande();
		}
	}


	static void fillOneCommande(){
		Commande cmd = new Commande();
		cmd.setClientClieId(getClientAleatoire().getClieId());
		cmd.setCmdeDate(new Timestamp(new Date().getTime()));
		cmd = new CommandeDAO().add(cmd);

		//5 produits

		int nbreProduit = Util.getNbreAlesWithMax(5);

        List<LigneCommande> lignesCommandes = new ArrayList<LigneCommande>();

		for(int cpt=0;cpt<nbreProduit;cpt++){


			LigneCommande ln = new LigneCommande();
			ln.setCommandeCmdeId(cmd.getCmdeId());
			ln.setProduitProdId(getProduitAleatoire().getProdId());
			ln.setLncmProduitNombre(cpt + 1);
			lignesCommandes.add(ln);
		}

        new LigneCommandeDAO().addLignesCommande(lignesCommandes);
	}

	static Client getClientAleatoire(){

		int size = alLClients.size();
		int alea = Util.getNbreAlesWithMax(size-1);
		return alLClients.get(alea);

	}

	static Produit getProduitAleatoire(){
		int size = allProduit.size();
		int alea = Util.getNbreAlesWithMax(size-1);
		return allProduit.get(alea);
	}

}
