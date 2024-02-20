package com.esisba.msformation.proxy;

import com.esisba.msformation.model.Etudiant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-scolarite", url = "localhost:8082")
public interface EtudiantProxy {
    @GetMapping("/api/etudiants_formation/{formation_id}")
    public List<Etudiant> getEtudiantsByFormationId(@PathVariable("formation_id") Long formation_id);
}
