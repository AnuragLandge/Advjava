package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Faculty;

public class TestOneToOneUnidirectionalLazyFetch {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Faculty f1 = session.load(Faculty.class, 1);
		System.out.println(f1);
		System.out.println(f1.getC());
		
		tr.commit();
		session.close();
		sf.close();
	}

}
