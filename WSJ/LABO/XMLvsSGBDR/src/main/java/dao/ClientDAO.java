package dao;

import data.Client;
import data.HibernateSessionFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by sce on 10.09.14.
 */
public class ClientDAO {

	public Client add(Client client){
		Transaction trans = HibernateSessionFactory.getSession().beginTransaction();
        HibernateSessionFactory.getSession().save(client);
		trans.commit();
        System.out.println("Client add: " + client);
        return client;
	}

	public List<Client> addClients(List<Client> clients){
		final Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		for(Client c : clients){
			session.save(c);
		}
		trans.commit();
        session.close();
        System.out.println("Saving clients list, size: " + clients.size());
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

	public Client getById(Integer user_id) {
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

}
