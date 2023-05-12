package com.project.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    // forgein key do projekt id
    private String nazwa;
    private Integer kolejnosc;
    private String opis;
    private Date czas_dodania;

}
