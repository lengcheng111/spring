package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.Student;

public class StudentDAOHibernate {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Student student) {
		final Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}

	public static void main(String[] args) {
		StudentDAOHibernate test = new StudentDAOHibernate();
		Student student = new Student(1, "abc", "agagaG");
		test.save(student);
	}
}
