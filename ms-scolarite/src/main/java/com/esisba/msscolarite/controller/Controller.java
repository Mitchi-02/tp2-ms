package com.esisba.msscolarite.controller;

import com.esisba.msscolarite.entities.Etudiant;
import com.esisba.msscolarite.model.Formation;
import com.esisba.msscolarite.model.Virement;
import com.esisba.msscolarite.proxy.FormationProxy;
import com.esisba.msscolarite.proxy.VirementProxy;
import com.esisba.msscolarite.repositories.EtablissementRepository;
import com.esisba.msscolarite.repositories.EtudiantRepository;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    @Resource
    EtudiantRepository etudiantRepository;
    @Resource
    EtablissementRepository etablissementRepository;
    @Resource
    FormationProxy formationProxy;
    @Resource
    VirementProxy virementProxy;

    @GetMapping("/etudiants/{ide}")
    public Etudiant show(@PathVariable("ide") Long ide) {
        Optional<Etudiant> check = etudiantRepository.findById(ide);
        if(check.isEmpty())
        {
            return null;
        }
        Etudiant e = check.get();
        Long idFormation = e.getId_formation();

        Formation f = formationProxy.getFormationById(idFormation);

        e.setFormation(f);

        return e;
    }
    @GetMapping("/etudiants/{ide}/formation")
    public Formation showFormation(@PathVariable("ide") Long ide) {
        Optional<Etudiant> check = etudiantRepository.findById(ide);
        if(check.isEmpty())
        {
            return null;
        }

        return formationProxy.getFormationById(check.get().getId_formation());
    }
    @GetMapping("/etudiants/{ide}/virements")
    public List<Object> showVirements(@PathVariable("ide") Long ide) {
        Optional<Etudiant> check = etudiantRepository.findById(ide);
        if(check.isEmpty())
        {
            return null;
        }

        return virementProxy.getVirementByEtudiantId(ide);
    }
}
