package com.apigestionregion.springjwt.repository;

import com.apigestionregion.springjwt.models.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegionsRepository extends JpaRepository<Regions, Long> {
    /*C'est la requette qui permet d'afficher une liste de tout les regions avec le pays correspondant*/
    @Query(value = "SELECT regions.nom , pays.nom as pays FROM regions, pays where regions.id_pays = pays.id", nativeQuery = true )
    public Iterable<Object[]> FIND_ALLREGION_WITH_PAYS(); /*C'est la methode permettant d'afficher notre requette sous forme de liste qui sera appeler dans le package service */


    /*C'est la requette qui permet d'afficher une liste de tout les regions sans  le pays */
    @Query(value = "SELECT regions.nom FROM regions", nativeQuery = true )
    public Iterable<Object[]> FIND_REGION_SANS_Pays();

    /*C'est la requette qui permet d'afficher une liste de tout les regions d'un pays donné, en rentrant le nom du pays en parametre */
    @Query(value = "SELECT regions.nom FROM regions, pays WHERE regions.pays_id = pays.id AND pays.nom = :pays", nativeQuery = true )
    public Iterable<Object[]> FIND_REGION_EN_FONCTION_DU_Pays(String pays);
    /*C'est la requette qui permet d'afficher une liste de tout les entrées d'une region donnée par année c'est à dire la region , l'année et le nombre d'habitant */
    @Query(value = "SELECT regions.nom, population.annee, population.nb_habitant FROM regions,population WHERE  population.regions_id = regions.id AND regions.nom =:regions", nativeQuery = true )
    public Iterable<Object[]> FIND_REGION_POPULATION_ANNEE_NBHABUTANT(String regions);
}

