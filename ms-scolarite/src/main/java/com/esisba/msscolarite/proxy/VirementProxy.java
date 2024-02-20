package com.esisba.msscolarite.proxy;

import com.esisba.msscolarite.model.Formation;
import com.esisba.msscolarite.model.Virement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-bourse", url = "localhost:8083")
public interface VirementProxy {
    @GetMapping("/api/virements/{etudiant_id}")
    public List<Virement> getVirementByEtudiantId(@PathVariable("etudiant_id") Long etudiant_id);
}
