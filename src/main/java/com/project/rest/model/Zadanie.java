package com.project.rest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

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
    @Null
    private Integer kolejnosc;
    private String opis;

    @CreationTimestamp
    private Date czasDodania;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name="idProjekt")
    private Projekt projekt;

    @OneToOne
    @JoinColumn(name="idUserCreate")
    private User userCreate;

    @OneToOne
    @JoinColumn(name="idUserDo", nullable = true)
    private User userDo;
}
