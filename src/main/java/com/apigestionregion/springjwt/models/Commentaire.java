package com.apigestionregion.springjwt.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "commentaire")
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Date date;

    //Un commentaire est fait par un et un seul utilisateur
    @ManyToOne
    private User user;

    //un commentaire concerne une et une seule région
//    @ManyToOne
//    private Regions regions;
}
