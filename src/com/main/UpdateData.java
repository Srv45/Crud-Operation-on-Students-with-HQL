package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.entity.Student;

public class UpdateData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "update Student set address =:add where reg_No =:reg";
		MutationQuery mtquery = ss.createMutationQuery(hqlQuery);
		mtquery.setParameter("add", "Talegaon");
		mtquery.setParameter("reg", 11907066);
		mtquery.executeUpdate();
		tr.commit();

		System.out.println("Data updated successufully...");
		ss.close();
	}

}
