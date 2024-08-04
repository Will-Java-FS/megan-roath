package com.revature.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.revature.models")
@SpringBootApplication
public class BasicApplication {



	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}

}

/*Spring Boot introduces the @SpringBootApplication annotation. This single annotation is
equivalent to using @Configuration, @EnableAutoConfiguration, and @ComponentScan.
As a result, when we run this Spring Boot application, it will automatically scan
the components in the current package and its sub-packages. Thus it will register
them in Spring’s Application Context, and allow us to inject beans using @Autowired.
@Autowired on Properties

 */
