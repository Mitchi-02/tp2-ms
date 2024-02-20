package com.esisba.msformation.controller;

import com.esisba.msformation.model.Etudiant;
import com.esisba.msformation.proxy.EtudiantProxy;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Resource
    EtudiantProxy etudiantProxy;

    @GetMapping("/formations/{formation_id}/etudiants")
    public List<Etudiant> show(@PathVariable("formation_id") Long formation_id) {
        return etudiantProxy.getEtudiantsByFormationId(formation_id);
    }
}
