package com.project.rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ProjektCooperators")
@Data
@Getter
public class ProjektCooperators {
    @GeneratedValue
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idProjekt")
    private Projekt projekt;

    public ProjektCooperators(User user, Projekt projekt){
        this.user=user;
        this.projekt=projekt;
    }
}
