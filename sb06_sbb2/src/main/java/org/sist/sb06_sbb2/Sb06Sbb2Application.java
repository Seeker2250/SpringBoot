package org.sist.sb06_sbb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//@EntityScan(basePackages = "org.sist.sb06_sbb2.question")
@SpringBootApplication
public class Sb06Sbb2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb06Sbb2Application.class, args);
	}

}
