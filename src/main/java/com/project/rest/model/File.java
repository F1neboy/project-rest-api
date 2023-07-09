package com.project.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="files")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class File {

    @Id
    @GeneratedValue
    private long id;

    private String contentType;

    private String fileName;

    @Lob
    private byte[] data;

    @ManyToOne
    @JoinColumn(name="idProjekt")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Projekt projekt;
}
