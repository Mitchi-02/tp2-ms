package com.esisba.msscolarite.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantInRequest {
    private List<Long> etudiants;
}
