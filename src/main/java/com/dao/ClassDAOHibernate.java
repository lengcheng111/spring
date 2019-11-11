package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.ClassDTO;

public class ClassDAOHibernate {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(ClassDTO classDTO) {
		final Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(classDTO);
		session.getTransaction().commit();
		session.close();
	}
}
