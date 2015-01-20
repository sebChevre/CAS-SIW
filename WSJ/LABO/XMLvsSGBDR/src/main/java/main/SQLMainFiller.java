package main;

import dao.ClientDAO;
import dao.CommandeDAO;
import dao.LigneCommandeDAO;
import dao.ProduitDAO;
import filler.ClientsFiller;
import filler.CommandeFiller;
import filler.ProduitsFiller;

/**
 * Created by seb on 08.09.14.
 */
public class SQLMainFiller {




    public static void main(final String[] args) throws Exception {
		deleteAll();
		ProduitsFiller.fillProduits(100);
		ClientsFiller.fillClient();
		CommandeFiller.fillCommande(200);
    }

	public static void deleteAll(){
		LigneCommandeDAO lcdao = new LigneCommandeDAO();
		lcdao.deleteAll();
		CommandeDAO comdao = new CommandeDAO();
		comdao.deleteAll();
		ClientDAO cdao = new ClientDAO();
		cdao.deleteAll();
		ProduitDAO pdao = new ProduitDAO();
		pdao.deleteAll();
	}
}
