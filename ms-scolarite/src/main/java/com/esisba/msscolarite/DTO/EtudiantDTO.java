package com.esisba.msscolarite.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantDTO {
    private Long id;
    private String name;
    private String etablissement;
}
