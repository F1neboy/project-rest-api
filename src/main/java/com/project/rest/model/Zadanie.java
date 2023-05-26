package com.project.rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Zadanie")
@Data
public class Zadanie {
    @Id
    @GeneratedValue
    private Long id;
    private String nazwa;
    private Integer kolejnosc;
    private String opis;
    private Date czasDodania;

    @ManyToOne
    @JoinColumn(name="idProjekt")
    private Projekt projekt;

    @OneToOne
    @JoinColumn(name="idUserCreate")
    private User userCreate;

    @OneToOne
    @JoinColumn(name="idUserDo")
    private User userDo;

}
