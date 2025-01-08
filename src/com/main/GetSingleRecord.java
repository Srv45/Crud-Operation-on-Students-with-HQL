package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Student;

public class GetSingleRecord {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "from Student where reg_No =:reg";
		Query<Student> query = ss.createQuery(hqlQuery, Student.class);
		query.setParameter("reg", 11907066);
		Student s = query.getSingleResult();
		tr.commit();

		System.out.println(s);
		ss.close();
	}

}