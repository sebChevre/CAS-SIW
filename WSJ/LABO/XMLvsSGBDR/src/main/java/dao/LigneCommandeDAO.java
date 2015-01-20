package dao;

import data.HibernateSessionFactory;
import data.LigneCommande;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by sce on 10.09.14.
 */
public class LigneCommandeDAO {



	public LigneCommande add(LigneCommande ligneCommande){

		Transaction trans = HibernateSessionFactory.getSession().beginTransaction();

        HibernateSessionFactory.getSession().save(ligneCommande);
		trans.commit();

		return ligneCommande;
	}

    public List<LigneCommande> addLignesCommande(List<LigneCommande> lignesCommande){
        final Session session = HibernateSessionFactory.getSession();

        Transaction trans = session.beginTransaction();
        for(LigneCommande lc : lignesCommande){

            session.save(lc);

        }
        trans.commit();
        session.close();
        System.out.println("Lignes Commandes added, size: " + lignesCommande.size());

        return lignesCommande;
    }

	public void deleteAll(){
		final Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		String hql = String.format("delete from LigneCommande");
		Query query = session.createQuery(hql);
		query.executeUpdate();

		trans.commit();
	}

/*
	public List<Client> addClients(List<Client> clients){
		final Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		for(Client c : clients){
			session.save(c);
		}
		trans.commit();
		return clients;
	}

	public void deleteAll(){
		final Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		String hql = String.format("delete from Client");
		Query query = session.createQuery(hql);
		query.executeUpdate();

		trans.commit();
	}

	public Client getById(Long user_id) {
		Session session = null;
		Client client = null;
		try {
			session = HibernateSessionFactory.getSession();
			client =  (Client)session.get(Client.class,
					user_id);
			Hibernate.initialize(client);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return client;
	}

	public List<Client> findAll(){
		final Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		Query query = session.createQuery("from Client");
		List<Client> clients = query.list();
		trans.commit();
		return clients;
	}
	*/
	public List<LigneCommande> findByCommandeId(int commandId){
        final Session session = HibernateSessionFactory.getSession();
        Transaction trans = session.beginTransaction();

        Query query = session.createQuery("from LigneCommande as lc where lc.commandeCmdeId = " + commandId);
        List<LigneCommande> lignes = query.list();
        return lignes;
    }

}
