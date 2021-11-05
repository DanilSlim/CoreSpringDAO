package com.habuma.spitter.persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.habuma.spitter.domain.Test;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext.xml");
		
		GetData dao=(GetData) context.getBean("spitterDao");
		
		dao.printData();
		
		dao.setData();
		
		
		ScanTest scanTest=(ScanTest) context.getBean("scanTest");
		
		scanTest.printScanTest();
		
		TestDAO testDAO=(TestDAO) context.getBean("hibernateSpitterDao");
		
		testDAO.getTestById(100);
		
		testDAO=(TestDAO) context.getBean("spitterJPADAO");
		
		Test test=new Test();
		test.setID(333);
		test.setName("Pongo");
		
		//testDAO.addTestData(test);
		
		testDAO.getTestById(777);

	}

}
