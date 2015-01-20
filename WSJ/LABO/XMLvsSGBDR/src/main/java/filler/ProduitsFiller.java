package filler;

import dao.ProduitDAO;
import data.Produit;
import util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sce on 09.09.14.
 */
public class ProduitsFiller {

	public static void main(String[] args) {

		fillProduits(100);

	}

	public static void fillProduits(int numberOfProduits){

		List<Produit> produitsToInsert = new ArrayList<Produit>();

		for(int cpt=0;cpt<numberOfProduits;cpt++){
			Produit p = new Produit();
			p.setProdDesc("Description du produit test n° " + cpt);
			p.setProdPrix(Util.generateMontantAleatoire());
			produitsToInsert.add(p);
		}

		ProduitDAO pdao = new ProduitDAO();
		pdao.addProduits(produitsToInsert);


	}

}
