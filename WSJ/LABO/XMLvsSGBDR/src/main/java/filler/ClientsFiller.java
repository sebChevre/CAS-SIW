package filler;

import dao.ClientDAO;
import data.Client;
import util.ClientsData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sce on 09.09.14.
 */
public class ClientsFiller {

	public static void main(String[] args) {

		fillClient();
	}

	public static void fillClient(){

		List<Client> clientsToInsert = new ArrayList<Client>();

		for(ClientsData cl:ClientsData.values()){
			Client c = new Client();
			c.setClieLocalite(cl.localite);
			c.setClieNom(cl.nom);
			c.setCliePrenom(cl.prenom);
			c.setClieRue(cl.rue);
			clientsToInsert.add(c);
		}

		ClientDAO cdao = new ClientDAO();
		cdao.addClients(clientsToInsert);

	}
}
