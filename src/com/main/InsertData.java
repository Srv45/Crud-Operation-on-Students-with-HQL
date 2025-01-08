package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.entity.Student;

public class InsertData {

	public static void main(String[] args) {
	
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "insert into Student(reg_No,name,age,email,address)values(:reg,:name,:age,:email,:address)";
		MutationQuery mtquery = ss.createMutationQuery(hqlQuery);
		mtquery.setParameter("reg", 11907066);
		mtquery.setParameter("name", "Shubham Verma");
		mtquery.setParameter("age", 22);
		mtquery.setParameter("email", "shubham@gmail.com");
		mtquery.setParameter("address", "Pune");
		mtquery.executeUpdate();
		tr.commit();

		System.out.println("Data inserted successufully...");
		ss.close();
	}

}
