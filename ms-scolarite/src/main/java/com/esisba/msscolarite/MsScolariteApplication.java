package com.esisba.msscolarite;

import com.esisba.msscolarite.entities.Etablissement;
import com.esisba.msscolarite.entities.Etudiant;
import com.esisba.msscolarite.repositories.EtablissementRepository;
import com.esisba.msscolarite.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.sql.Date;

@SpringBootApplication
@EnableFeignClients
public class MsScolariteApplication implements CommandLineRunner {

    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    EtablissementRepository etablissementRepository;
    public static void main(String[] args) {
        SpringApplication.run(MsScolariteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Etablissement e1 = etablissementRepository.save(new Etablissement(null, "java", null));
        Etablissement e2 = etablissementRepository.save(new Etablissement(null, "angular", null));

        Etudiant et1 = etudiantRepository.save(new Etudiant(null, "malki", Date.valueOf("1999-01-01"), "4isi", null, e1, 1L, null, null));
        Etudiant et2 = etudiantRepository.save(new Etudiant(null, "ali", Date.valueOf("1995-08-11"), "4siw", null, e1, 2L, null, null));
        Etudiant et3 = etudiantRepository.save(new Etudiant(null, "karim", Date.valueOf("1996-11-22"), "MasterSiC", null, e2, 1L, null, null));
        Etudiant et4 = etudiantRepository.save(new Etudiant(null, "fouad", Date.valueOf("2000-02-15"), "MasterSiR", null, e2, 2L, null, null));

    }
}
