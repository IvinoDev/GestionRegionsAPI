package com.apigestionregion.springjwt.repository;

import com.apigestionregion.springjwt.models.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PopulationRepository extends JpaRepository<Population, Long> {
    /*Afficher une liste des éléments de la population avec la region correspondante*/
    @Query(value = "SELECT regions.nom ,population.nb_habitant, population.annee FROM population, regions where population.regions_id = regions.id", nativeQuery = true )
    public Iterable<Object[]> FINDALLREGIONWITH_NONMBRE_HABITANT_AND_ANNEE();

    /*C'est la requette qui permet d'afficher une de toute les entrée par année de la region entrer en parametre*/

    @Query(value = "SELECT population.annee, population.nb_habitant FROM population, regions WHERE population.regions_id = regions.id AND regions.nom=:regions", nativeQuery = true )
    public Iterable<Object[]> FIND_EN_FONCTION_REGIONENTRER_ALL_NONMBRE_HABITANT_AND_ANNEE(String regions);
}

