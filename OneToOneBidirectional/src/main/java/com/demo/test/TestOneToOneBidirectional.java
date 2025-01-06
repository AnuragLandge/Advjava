package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Faculty;

public class TestOneToOneBidirectional {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Course c1 = new Course();
		c1.setCname("Ketan");
		c1.setDuration(6);

		Faculty f1 = new Faculty("Divya", "DAC", c1);
		c1.setF1(f1);

		Course c2 = session.get(Course.class, 1);
		if (c2 != null)
			session.delete(c2);

		Transaction tr = session.beginTransaction();
		session.save(f1);
		session.save(c1);
		tr.commit();
		session.close();
		sf.close();

	}

}
