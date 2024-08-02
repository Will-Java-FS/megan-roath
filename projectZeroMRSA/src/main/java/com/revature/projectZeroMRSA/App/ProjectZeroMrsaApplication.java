package com.revature.projectZeroMRSA.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
//@EntityScan("com.revature.models")
//@EnableJpaRepositories("com.revature.repositories")
public class ProjectZeroMrsaApplication{

	//This is just for testing remove this
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	public static void main(String[] args){
		SpringApplication.run(ProjectZeroMrsaApplication.class, args);
	}

}
