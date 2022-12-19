package com.apigestionregion.springjwt.security.services;

import com.apigestionregion.springjwt.models.Pays;

import java.util.List;

public interface PaysService {
    Pays creer (Pays pays);/*C'est la méthode permettant de creer un pays*/
    List<Pays> lire();/*C'est la méthode permettant d'afficher une liste des pays créer*/
    Pays modifier(Long idPays, Pays pays);//*C'est la méthode permettant de modifier un pays*/
    String supprimer(Long idPays);/*C'est la méthode permettant de supprimer un pays*/
}

