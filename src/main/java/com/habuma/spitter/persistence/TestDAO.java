package com.habuma.spitter.persistence;

import com.habuma.spitter.domain.Test;

public interface TestDAO {
	
	void getTestById(int id);
	
	void addTestData(Test test);
	
	

}
