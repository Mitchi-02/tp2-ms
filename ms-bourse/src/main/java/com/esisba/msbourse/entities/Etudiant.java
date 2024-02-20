package com.esisba.msbourse.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id
    private Long id;

    @Column(unique = true)
    private Long NCompteCCP;

    private String salaireParent;

    private boolean situationImpot;

    @OneToMany(mappedBy = "etudiant")
    private List<Virement> virements;
}
