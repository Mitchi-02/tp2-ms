package com.esisba.msbourse.proxy;

import com.esisba.msbourse.DTO.EtudiantInRequest;
import com.esisba.msbourse.model.Etudiant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ms-scolarite", url = "localhost:8082")
public interface EtudiantProxy {
    @PostMapping("/api/etudiants_in")
    public List<Etudiant> getEtudiantsWhereIdIn(@RequestBody EtudiantInRequest body);
}
