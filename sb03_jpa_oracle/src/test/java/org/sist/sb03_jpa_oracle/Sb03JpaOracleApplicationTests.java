	package org.sist.sb03_jpa_oracle;

import org.junit.jupiter.api.Test;
import org.sist.sb03_jpa_oracle.persistence.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sb03JpaOracleApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	TimeMapper timeMapper;
	
	@Test
	void timeMapperTest() {
		System.out.println("현재 시간 뭐라 찍히게?@@@@@"+this.timeMapper.getTime());
	}
}
