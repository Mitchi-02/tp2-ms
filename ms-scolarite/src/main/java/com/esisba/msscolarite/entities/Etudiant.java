package com.esisba.msscolarite.entities;

import com.esisba.msscolarite.model.Virement;
import com.esisba.msscolarite.model.Formation;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date dateN;

    private String promo;

    @Temporal(TemporalType.DATE)
    private Date dateInscription;

    @ManyToOne
    private Etablissement etablissement;

    private Long formation_id;

    @Transient
    private Formation formation;

    @Transient
    private List<Virement> virements;
}
