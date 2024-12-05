	package org.sist.sb04_oracle_mybatis_jsp;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.sist.sb04_oracle_mybatis_jsp.persistence.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import lombok.extern.java.Log;

@SpringBootTest
@Log
class Sb04OracleMybatisJspApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	TimeMapper timeMapper;
	
	@Test
	void timeMapperTest() {
		System.out.println("현재 시간 뭐라 찍히게?@@@@@"+this.timeMapper.getTime());
	}
	
	@Autowired
	DataSource dataSource;
	
	@Test
	void asdfConnection() {
		try(Connection conn = this.dataSource.getConnection()) {
			log.info("@@@@@@@@@@@@@@@@@connection : " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
