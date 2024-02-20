package com.esisba.msbourse.controllers;

import com.esisba.msbourse.DTO.EtudiantInRequest;
import com.esisba.msbourse.entities.Virement;
import com.esisba.msbourse.model.Etudiant;
import com.esisba.msbourse.proxy.EtudiantProxy;
import com.esisba.msbourse.repositories.EtudiantRepository;
import com.esisba.msbourse.repositories.VirementRepository;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class Controller {

    @Resource
    VirementRepository virementRepository;
    @Resource
    EtudiantRepository etudiantRepository;
    @Resource
    EtudiantProxy etudiantProxy;

    @GetMapping("/virements/{etudiant_id}")
    public List<Virement> indexEtudiant(@PathVariable("etudiant_id") Long etudiant_id) {
        if (etudiantRepository.findById(etudiant_id).isEmpty()) {
            return new ArrayList<>();
        }

        return virementRepository.getAllByEtudiant_Id(etudiant_id)
                .stream()
                .map(v -> {
                    v.setNCompteCCP(etudiantRepository.findById(etudiant_id).get().getNCompteCCP());
                    return v;
                })
                .collect(Collectors.toList()); // Add this line to collect the stream into a List
    }

    @GetMapping("/etudiants_boursiers")
    public List<Etudiant> indexEtudiantsBoursiers() {
        List<Long> ids = etudiantRepository.findDistinctIds();
        System.out.println("distinct" + ids);
        return etudiantProxy.getEtudiantsWhereIdIn(new EtudiantInRequest(ids));
    }
}
