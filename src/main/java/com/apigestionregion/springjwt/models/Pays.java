package com.apigestionregion.springjwt.models;


import lombok.*;

import javax.persistence.*;

/*Là nous avons la classe Pays*/
@Entity/*Permet de montrer que notre classe qui va suivre est un entité ainsi elle sera créer dans la base de donnée*/
@Table(name = "Pays")/*Permet de donner un nom a notre table*/
@Getter
@Setter/*Permet de créer les setters de ma classe  Pays  grace la dependance lombok*/
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;


}