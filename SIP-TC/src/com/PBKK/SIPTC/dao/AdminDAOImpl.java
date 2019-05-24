package com.PBKK.SIPTC.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.PBKK.SIPTC.entity.Admin;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Override
	public Admin getAdmin(String nrp, String password) {
		
		// get the current hibernate session
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Admin.class)
				.buildSessionFactory();
				
		Session currentSession = factory.getCurrentSession();
		currentSession.beginTransaction();
		
		// create a query
		Query<Admin> query = currentSession
				.createQuery("from Admin where nrp_admin =:nrp and password =:pass", Admin.class);
		query.setParameter("nrp", nrp);
		query.setParameter("pass", password);
		
		// execute query and get one admin data
		List<Admin> resultAdmin = query.getResultList();
//		System.out.println(resultAdmin);
		currentSession.close();
		
		// return the result
		if (resultAdmin.size() >= 1) {
			return resultAdmin.get(0);
		}
		
		return null;
	}
}