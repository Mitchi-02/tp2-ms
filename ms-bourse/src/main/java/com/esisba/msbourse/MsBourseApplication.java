package com.esisba.msbourse;

import com.esisba.msbourse.entities.Etudiant;
import com.esisba.msbourse.entities.Virement;
import com.esisba.msbourse.repositories.EtudiantRepository;
import com.esisba.msbourse.repositories.VirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MsBourseApplication implements CommandLineRunner {

    @Autowired
    VirementRepository virementRepository;
    @Autowired
    EtudiantRepository etudiantRepository;

    public static void main(String[] args) {
        SpringApplication.run(MsBourseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Etudiant e1 = etudiantRepository.save(new Etudiant(1L, "100", true, null));
        Etudiant e2 = etudiantRepository.save(new Etudiant(2L, "200", true, null));
        Etudiant e3 = etudiantRepository.save(new Etudiant(3L, "300", true, null));
        Etudiant e4 = etudiantRepository.save(new Etudiant(4L, "400", true, null));

        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(e1);
        etudiants.add(e2);
        etudiants.add(e3);
        etudiants.add(e4);

        for (Etudiant e: etudiants){
            virementRepository.save(new Virement(null, "10000", Date.valueOf("2024-01-01"), e));
            virementRepository.save(new Virement(null, "20000", Date.valueOf("2024-01-02"), e));
        }
    }
}
