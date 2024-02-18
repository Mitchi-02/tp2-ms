package com.esisba.msscolarite.proxy;

import com.esisba.msscolarite.model.Formation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-formation", url = "localhost:8081")
public interface FormationProxy {
    @GetMapping("/formations/{id}")
    public Formation getFormationById(@PathVariable("id") Long id);
}
