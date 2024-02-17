package com.esisba.msscolarite.repositories;

import com.esisba.msscolarite.entities.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
}
