package com.prj.api;
import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/resources/config/database/datasource.xml"})
public class dbConnectionTest {

	@Inject
	DataSource dataSource;
	
	@Test
	public void dbConnection() throws Exception{		
		Connection con = dataSource.getConnection();
		Assert.assertNotNull(con);		
	}
}
