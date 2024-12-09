package org.sist.sb06_sbb3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//@EntityScan(basePackages = "org.sist.sb06_sbb3.question") 이거 @Entity쓰지 않아도 이거로 scan가능
@SpringBootApplication
public class Sb06Sbb3Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb06Sbb3Application.class, args);
	}

}
