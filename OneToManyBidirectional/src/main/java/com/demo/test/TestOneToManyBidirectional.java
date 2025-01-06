package com.demo.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public class TestOneToManyBidirectional {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		// Department Data
		Department d1 = new Department();
		d1.setDeptName("DAC");
		d1.setDeptLoc("Pune");

		Department d2 = new Department();
		d2.setDeptName("DBDA");
		d2.setDeptLoc("Mumbai");

		// Employee Data
		Employee e1 = new Employee("Ketan", 3456, LocalDate.of(2024, 11, 15), d1);
		Employee e2 = new Employee("Divya", 5555, LocalDate.of(2023, 11, 15), d1);
		Employee e3 = new Employee("Om", 5656, LocalDate.of(2021, 11, 15), d2);
		Employee e4 = new Employee("Mrunal", 7676, LocalDate.of(2020, 11, 15), d2);

		// setting e1 and e2 to SET s1
		Set<Employee> s1 = new HashSet<>();
		s1.add(e1);
		s1.add(e2);
		d1.setElist(s1);

		// setting e3 and e4 to SET s2
		Set<Employee> s2 = new HashSet<>();
		s2.add(e3);
		s2.add(e4);
		d2.setElist(s2);

		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		session.save(d1);
		session.save(d2);
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);

		tr.commit();
		session.close();
		sf.close();
	}

}
