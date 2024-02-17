package com.esisba.msformation;

import com.esisba.msformation.entities.Formation;
import com.esisba.msformation.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsFormationApplication implements CommandLineRunner {

	@Autowired
	FormationRepository formationRepository;
	public static void main(String[] args) {
		SpringApplication.run(MsFormationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Formation f1 = formationRepository.save(new Formation(null, "java", 30));
		Formation f2 = formationRepository.save(new Formation(null, "angular", 40));
	}
}
