package kr.or.comma.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCTest {
	
	private static final Logger log = LoggerFactory.getLogger(JDBCTest.class);
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		try { 
			Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
														  "java",
														  "java");
			log.info("Connection : " + con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
