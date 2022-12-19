package com.apigestionregion.springjwt.models;

import lombok.*;

import javax.persistence.*;

@Entity/*Permet de montrer que notre classe qui va suivre est un entité ainsi elle sera créer dans la base de donnée*/
@Table(name = "Population")/*Permet de donner un nom a notre table*/
@Data/*Permet de créer les setters et getters de ma classe  Population grace la dependance lombok*/
public class Population {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String annee;
    private Long nbHabitant;

    @ManyToOne
    Regions regions;

}
