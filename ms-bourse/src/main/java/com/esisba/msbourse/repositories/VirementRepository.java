package com.esisba.msbourse.repositories;

import com.esisba.msbourse.entities.Virement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface VirementRepository extends JpaRepository<Virement, Long> {
    List<Virement> getAllByEtudiant_Id(Long id);
}
