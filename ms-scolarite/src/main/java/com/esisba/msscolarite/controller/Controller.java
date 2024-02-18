package com.esisba.msscolarite.controller;

import com.esisba.msscolarite.entities.Etudiant;
import com.esisba.msscolarite.model.Formation;
import com.esisba.msscolarite.proxy.FormationProxy;
import com.esisba.msscolarite.repositories.EtablissementRepository;
import com.esisba.msscolarite.repositories.EtudiantRepository;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @Resource
    EtudiantRepository etudiantRepository;
    @Resource
    EtablissementRepository etablissementRepository;
    @Resource
    FormationProxy formationProxy;

    @GetMapping("/etudiants/{ide}")
    public Etudiant show(@PathVariable("ide") Long ide) {
        Etudiant e = etudiantRepository.findById(ide).get();
        Long idFormation = e.getId_formation();

        Formation f = formationProxy.getFormationById(idFormation);

        e.setFormation(f);

        return e;
    }
}
