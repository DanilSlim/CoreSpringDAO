package com.habuma.spitter.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.habuma.spitter.domain.Test;

@Repository("spitterJPADAO")
@Transactional(transactionManager = "txJPAManager")
public class JpaSpitterDao implements TestDAO {
	
	@PersistenceContext(unitName = "emf")
	private EntityManager em;
	
	

	@Override
	public void getTestById(int id) {
		
		Test test=em.find(Test.class, id);
		
		System.out.println("JPA Test ID="+test.getID()+" JPA Test Name:"+test.getName());
	}

	@Override
	public void addTestData(Test test) {
		em.persist(test);
		
		System.out.println("JPA INsert OK");

	}

}
