package dao;

import data.HibernateSessionFactory;
import data.Produit;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by sce on 10.09.14.
 */
public class ProduitDAO {

	public Produit add(Produit produit){
		Transaction trans = HibernateSessionFactory.getSession().beginTransaction();
        HibernateSessionFactory.getSession().save(produit);
		trans.commit();
		return produit;
	}

	public List<Produit> addProduits(List<Produit> produits){
		final Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		for(Produit p : produits){
			session.save(p);
		}
		trans.commit();
        session.close();
		return produits;
	}

	public void deleteAll(){
		final Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		String hql = String.format("delete from Produit");
		Query query = session.createQuery(hql);
		query.executeUpdate();

		trans.commit();
	}
	public List<Produit> findAll(){
		final Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		Query query = session.createQuery("from Produit");
		List<Produit> produits = query.list();
		trans.commit();
		return produits;
	}

}
