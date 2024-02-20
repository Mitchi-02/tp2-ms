package com.esisba.msbourse.repositories;

import com.esisba.msbourse.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}
