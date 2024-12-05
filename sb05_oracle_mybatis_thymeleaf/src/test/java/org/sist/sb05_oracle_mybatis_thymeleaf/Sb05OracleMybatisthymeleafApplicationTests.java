	package org.sist.sb05_oracle_mybatis_thymeleaf;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.sist.sb05_oracle_mybatis_thymeleaf.persistence.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import lombok.extern.java.Log;

@SpringBootTest
@Log
class Sb05OracleMybatisthymeleafApplicationTests {

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
