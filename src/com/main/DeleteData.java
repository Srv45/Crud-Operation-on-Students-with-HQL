package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.entity.Student;

public class DeleteData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "delete from Student where reg_No =:reg";
		MutationQuery mtquery = ss.createMutationQuery(hqlQuery);
		mtquery.setParameter("reg", 11907066);
		mtquery.executeUpdate();
		tr.commit();

		System.out.println("Data deleted successufully...");
		ss.close();
	}

}