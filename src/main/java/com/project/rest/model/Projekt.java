package com.project.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.zip.DataFormatException;

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
    private Date data_utworzenia;
    private Date data_oddania;

}
