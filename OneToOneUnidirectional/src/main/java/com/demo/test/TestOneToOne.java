package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Faculty;

public class TestOneToOne {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Course c1 = new Course("DAC", 5);
		Course c2 = new Course("DBDA", 6);
		Course c3 = new Course("DITISS", 7);

		Faculty f1 = new Faculty("Divya", "Jalgaon", c1);
		Faculty f2 = new Faculty("Ketan", "Mumbai", c2);
		Faculty f3 = new Faculty("Sakshi", "Mumbai", c3);

//		session.save(c1);
//		session.save(c2);
//		session.save(c3);
//		session.save(f1);
//		session.save(f2);
//		session.save(f3);

		Faculty ftest = session.get(Faculty.class, 3);
		System.out.println(ftest);
		Course ctest = session.get(Course.class, 2);
		System.out.println(ctest);
		tr.commit();
		session.close();
		sf.close();
	}
}