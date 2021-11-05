package com.habuma.spitter.persistence;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class SimpleJdbcTemplateSpitterDao implements GetData{
	
    private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
	
		this.jdbcTemplate=jdbcTemplate;
	}
	
	
	

	@Override
	public void printData() {
		
		int rowCount=jdbcTemplate.queryForObject("select count(*) from tst", Integer.class);
		
		System.out.println("Row count= "+rowCount);
		
		TestObject tstObject=jdbcTemplate.queryForObject("select tst.\"ID\", tst.\"Name\" from tst where tst.\"ID\"=?",
				(ResultSet, RowNum)->{
					TestObject newObj=new TestObject();
					newObj.setId(ResultSet.getInt("ID"));
					newObj.setName(ResultSet.getString("Name"));
					return newObj;
				},99);
		
		System.out.println("Test ID="+tstObject.getId()+" Test name: "+tstObject.getName());
		
	}


	@Override
	public void printData(int J) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void setData() {
		
		/*this.jdbcTemplate.update(
		        "insert into tst (\"ID\",\"Name\") values (?,?)",
		        777, "Pinto");*/
		
		String sql="select * from tst";
		
		List <TestObject> listObjects=jdbcTemplate.query(sql,
				(ResultSet, RowNum)->{
					TestObject newObj=new TestObject();
					newObj.setId(ResultSet.getInt("ID"));
					newObj.setName(ResultSet.getString("Name"));
					return newObj;}
				);
		
		for(TestObject obj:listObjects) {
			
			System.out.println("Test ID="+obj.getId()+" Test name: "+obj.getName());
			
		}
	}

}
