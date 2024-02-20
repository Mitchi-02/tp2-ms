package com.esisba.msscolarite.repositories;

import com.esisba.msscolarite.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    @Query("select e from Etudiant e where e.formation_id = :id_formation")
    List<Etudiant> findAllByFormation_id(@Param("id_formation") Long id_formation);

    List<Etudiant> findByIdIn(List<Long> ids);
}
