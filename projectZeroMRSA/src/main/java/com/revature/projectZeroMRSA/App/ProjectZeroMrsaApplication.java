package com.revature.projectZeroMRSA.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.revature.models")
@EnableJpaRepositories("com.revature.repositories")
public class ProjectZeroMrsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectZeroMrsaApplication.class, args);
	}

}
