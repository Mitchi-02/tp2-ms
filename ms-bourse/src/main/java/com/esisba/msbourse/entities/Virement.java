package com.esisba.msbourse.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Virement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String montant;

    @Temporal(TemporalType.DATE)
    private Date dateVirement;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    private Etudiant etudiant;
}
