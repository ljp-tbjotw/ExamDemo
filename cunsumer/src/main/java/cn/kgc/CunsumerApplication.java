package cn.kgc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring-comsumer.xml")
public class CunsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CunsumerApplication.class, args);
	}

}
