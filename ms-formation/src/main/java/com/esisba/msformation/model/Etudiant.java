package com.esisba.msformation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    private long id;
    private String name;
    private String etablissement;
}
