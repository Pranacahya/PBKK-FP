package com.PBKK.SIPTC.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.PBKK.SIPTC.entity.Status;

@Repository
public class StatusDAOImpl implements StatusDAO {
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Status.class)
			.buildSessionFactory();
	
	@Override
	public List<Status> getAllStatus() {
		
		Session currentSession = factory.getCurrentSession();
		currentSession.beginTransaction();
		Query<Status> query = currentSession.createQuery("from Status", Status.class);
		List<Status> statuses = query.getResultList();
		currentSession.close();
		
		return statuses;
	}

	@Override
	public Status getStatus(int theId) {
		
		Session currentSession = factory.getCurrentSession();
		currentSession.beginTransaction();
		Status status = currentSession.get(Status.class, theId);
		currentSession.close();
		return status;
	}

}
