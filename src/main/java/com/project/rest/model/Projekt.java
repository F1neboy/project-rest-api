package com.project.rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Projekt")
@Data
public class Projekt {
    @Id
    @GeneratedValue
    private Long id;
    private String nazwa;
    private String opis;
    @CreationTimestamp
    private Date dataUtworzenia;
    private Date dataOddania;

    @ManyToOne
    @JoinColumn(name="idUser")
    private User userProject;

    public Projekt(String nazwa, String opis){
        this.nazwa=nazwa;
        this.opis=opis;
        this.userProject=null;
        this.dataOddania=null;
    }

}
