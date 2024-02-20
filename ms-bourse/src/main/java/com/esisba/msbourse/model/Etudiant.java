package com.esisba.msbourse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    private long id;

    private String name;

    private String promo;

    private Date dateInscription;

    private String etablissement;
}
