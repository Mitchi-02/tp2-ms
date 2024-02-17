package com.esisba.msscolarite.repositories;

import com.esisba.msscolarite.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
