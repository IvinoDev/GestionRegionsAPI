package com.apigestionregion.springjwt.security.services;


import com.apigestionregion.springjwt.models.Population;

public interface PopulationService {
    Population creer (Population population);/*C'est la méthode permettant de creer une population*/
    Iterable<Object[]> lire();/*C'est la méthode permettant d'afficher une liste des population créer*/
    Iterable<Object[]> lireFIND_EN_FONCTION_REGIONENTRER_ALL_NONMBRE_HABITANT_AND_ANNEE(String regions);/*C'est la méthode permettant d'afficher une liste contenant le nombre d'habitant et l'année correspondant a ce nombre  d'habitant; d'une region donnée en parametre*/
    Population modifier(Long idPopulation, Population population);/*C'est la méthode permettant de modifier une population*/
    String supprimer(Long id);/*C'est la méthode permettant de supprimer une population*/
}

