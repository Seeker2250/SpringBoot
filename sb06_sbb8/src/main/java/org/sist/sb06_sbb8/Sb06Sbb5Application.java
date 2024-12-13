package org.sist.sb06_sbb8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@EntityScan(basePackages = "org.sist.sb06_sbb6.question") 이거 @Entity쓰지 않아도 이거로 scan가능
@SpringBootApplication//이게 component scan 내포함
public class Sb06Sbb5Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Sb06Sbb5Application.class, args);
		
	}

}
