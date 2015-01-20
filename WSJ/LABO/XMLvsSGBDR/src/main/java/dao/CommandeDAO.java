package dao;

import data.Client;
import data.Commande;
import data.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by sce on 10.09.14.
 */
public class CommandeDAO {

	public Commande add(Commande commande){

        final Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
        session.save(commande);
		trans.commit();
        session.close();
        System.out.println("Commande added: " + commande);
        return commande;
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
    public void deleteAll(){
        final Session session = HibernateSessionFactory.getSession();
        Transaction trans = session.beginTransaction();

        String hql = String.format("delete from Commande");
        Query query = session.createQuery(hql);
        query.executeUpdate();

        trans.commit();
    }

    public List<Commande> findAll(){
        final Session session = HibernateSessionFactory.getSession();
        Transaction trans = session.beginTransaction();

        Query query = session.createQuery("from Commande");
        List<Commande> commandes = query.list();
        trans.commit();
        return commandes;
    }

}
