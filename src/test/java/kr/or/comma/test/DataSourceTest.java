package kr.or.comma.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {
	
	private static final Logger log = LoggerFactory.getLogger(DataSourceTest.class);

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		
		try {
			
			Connection con = dataSource.getConnection();
			
			log.info("Connection : " + con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
