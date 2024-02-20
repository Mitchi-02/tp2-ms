package com.esisba.msbourse.controllers;

import com.esisba.msbourse.entities.Virement;
import com.esisba.msbourse.repositories.VirementRepository;
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
    VirementRepository virementRepository;
    @GetMapping("/virements/{etudiant_id}")
    public List<Virement> indexEtudiant(@PathVariable("etudiant_id") Long etudiant_id) {
        return virementRepository.getVirementByEtudiant_Id(etudiant_id);
    }
}
