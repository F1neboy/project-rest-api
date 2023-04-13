package com.project.rest.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Users")
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String pass;
    private String imie;
    private String nazwisko;
    private String email;
    @Nullable
    private Long nr_indeksu;
    private Rola rola;

}
