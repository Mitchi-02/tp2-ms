package com.esisba.msscolarite.controller;

import com.esisba.msscolarite.DTO.EtudiantBourseDTO;
import com.esisba.msscolarite.DTO.EtudiantInRequest;
import com.esisba.msscolarite.entities.Etudiant;
import com.esisba.msscolarite.DTO.EtudiantDTO;
import com.esisba.msscolarite.model.Formation;
import com.esisba.msscolarite.model.Virement;
import com.esisba.msscolarite.proxy.FormationProxy;
import com.esisba.msscolarite.proxy.VirementProxy;
import com.esisba.msscolarite.repositories.EtablissementRepository;
import com.esisba.msscolarite.repositories.EtudiantRepository;
import jakarta.annotation.Resource;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Long idFormation = e.getFormation_id();

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

        return formationProxy.getFormationById(check.get().getFormation_id());
    }
    @GetMapping("/etudiants/{ide}/virements")
    public List<Virement> showVirements(@PathVariable("ide") Long ide) {
        Optional<Etudiant> check = etudiantRepository.findById(ide);
        if(check.isEmpty())
        {
            return null;
        }

        return virementProxy.getVirementByEtudiantId(ide);
    }

    @GetMapping("/etudiants_formation/{formation_id}")
    public List<EtudiantDTO> showEtudiantsByFormation(@PathVariable("formation_id") Long formation_id) {
        return etudiantRepository.findAllByFormation_id(formation_id).stream()
                .map(e -> {
                    return new EtudiantDTO(e.getId(), e.getName(), e.getEtablissement().getName());
                })
                .collect(Collectors.toList());
    }
    @PostMapping("/etudiants_in")
    public List<EtudiantBourseDTO> showEtudiantsByIdIn(@RequestBody EtudiantInRequest body) {
        System.out.println("ids" + body.getEtudiants());
        return etudiantRepository.findByIdIn(body.getEtudiants()).stream()
                .map(e -> {
                    return new EtudiantBourseDTO(e.getId(), e.getName(), e.getPromo(), e.getDateInscription(), e.getEtablissement().getName());
                })
                .collect(Collectors.toList());
    }
}
