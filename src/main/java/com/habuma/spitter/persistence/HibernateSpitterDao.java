package com.habuma.spitter.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.habuma.spitter.domain.Test;

@Repository

public class HibernateSpitterDao implements TestDAO{
	
	private SessionFactory sessionFactory;
	
	
	
	@Autowired
	public HibernateSpitterDao(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
	}
	
	private Session getCurrentSession() {
		
		return sessionFactory.getCurrentSession();
	}

	@Transactional(transactionManager="txManager")
	@Override
	public void getTestById(int id) {
		
		Test test=getCurrentSession().get(Test.class,id);
		
		System.out.println("Test Hibernate ID="+test.getID()+" Test Hibernate Name:"+test.getName());
		
	}

	@Override
	@Transactional(transactionManager="txManager")
	public void addTestData(Test test) {
		
		getCurrentSession().save(test);
		
		System.out.println("Save nas been complite");
		
		
	}

}
