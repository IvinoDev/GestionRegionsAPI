package com.apigestionregion.springjwt.security.services;

import com.apigestionregion.springjwt.models.Regions;

public interface RegionsService {
    Regions creer (Regions regions);/*C'est la méthode permettant de creer une region*/

    Iterable<Object[]> lire();/*C'est la méthode permettant d'afficher une liste des regions créer*/
    Iterable<Object[]> lireFIND_REGION_SANS_Pays();/*C'est la méthode permettant d'afficher une liste des regions sans le pays*/

    Iterable<Object[]> lireFIND_REGION_EN_FONCTION_DU_Pays(String pays);/*C'est la méthode permettant d'afficher une liste des regions d'un pays donné en entrant le pays en parametre*/

    Iterable<Object[]> lireFIND_ALLREGION_WITH_PAYS();/*C'est la méthode permettant d'afficher une liste des regions avec le pays correspondant*/
    Iterable<Object[]>  lireFIND_REGION_POPULATION_ANNEE_NBHABUTANT(String regions);/*C'est la méthode permettant d'afficher une liste contenant le nom de la region,  le nombre d'habitant et l'année correspondant a ce nombre  d'habitant;  d'une region donnée en parametre*/
    Regions modifier(Long idRegions, Regions regions);/*C'est la méthode permettant de modifier une population*/
    String supprimer(Long idRegions);/*C'est la méthode permettant de supprimer une population*/
}

