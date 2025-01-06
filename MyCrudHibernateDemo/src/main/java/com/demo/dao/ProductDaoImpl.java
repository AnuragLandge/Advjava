package com.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {

	static SessionFactory sf;
	static {
		sf = HibernateUtil.getMyConnection();
	}

	@Override
	public void closeMyConnection() {
		HibernateUtil.closedMyConnection();
	}

	@Override
	public void addProduct(Product p1) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(p1);
		tr.commit();
		session.close();

	}

	@Override
	public List<Product> displayAllProduct() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("from Product");
		List<Product> plist = query.getResultList();
		tr.commit();
		session.close();
		return plist;
	}

	@Override
	public boolean removeById(int pid) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Product p = session.get(Product.class, pid);
		boolean flag = false;
		if (p != null) {
			session.delete(p);
			flag = true;
		}
		tr.commit();
		session.close();
		return flag;
	}

	@Override
	public boolean updateById(int pid, int qty, double price) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Product p = session.get(Product.class, pid);
		if (p != null) {
			p.setQty(qty);
			p.setPrice(price);
			session.save(p);
			tr.commit();
			session.close();
			return true;
		}
		session.close();
		return false;
	}

	@Override
	public Product displayById(int pid) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Product p = session.get(Product.class, pid);
		tr.commit();
		session.close();
		return p;
	}

	@Override
	public List<Product> sortByName() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("from Product p order by p.pname");
		List<Product> plist = query.getResultList();
		tr.commit();
		session.close();
		return plist;
	}
}
