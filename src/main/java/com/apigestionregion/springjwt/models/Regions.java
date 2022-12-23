package com.apigestionregion.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity/*Permet de montrer que notre classe qui va suivre est un entité ainsi elle sera créer dans la base de donnée*/
@Table(name = "Regions")/*Permet de donner un nom a notre table*/
@Data/*Permet de créer les setters et les getters de ma classe Regions grace la dependance lombok*/
/*Permet de créer un constructeur sans argument*/
public class Regions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codeRegions;
    private String nom;
    private String langue;
    private String superficie_regions;
    private String domaine_activite;
    private String src;

    @ManyToOne
    private Pays pays;


    @ManyToOne(cascade=CascadeType.ALL)
    private Image image;

//    @JsonIgnore
    @OneToMany
    private Collection<Commentaire> commentaire = new ArrayList<>();


   /* @ManyToOne
    @JoinColumn(name = "population_id_population")
    private Population population;*/
}