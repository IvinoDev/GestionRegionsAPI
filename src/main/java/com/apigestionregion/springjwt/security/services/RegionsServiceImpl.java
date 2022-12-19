package com.apigestionregion.springjwt.security.services;

import com.apigestionregion.springjwt.models.Regions;
import com.apigestionregion.springjwt.repository.RegionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor/*Permet de créer un constructeur avec argument*/
@Service/*Permet de spécifier que nos méthdes sont des services*/
public class RegionsServiceImpl implements RegionsService{
@Autowired
    private final RegionsRepository regionsRepository;
    @Override
    public Regions creer(Regions regions) {
        return regionsRepository.save(regions);
    }/*C'est  l'implementation de la méthode permettant de creer une region*/

    @Override
    public Iterable<Object[]> lire() {
        return regionsRepository.FIND_ALLREGION_WITH_PAYS();    }/*C'est  l'implementation de la méthode permettant de lire une region*/

    @Override
    public Iterable<Object[]> lireFIND_REGION_SANS_Pays() {/*C'est  l'implementation de la méthode lireFIND_REGION_SANS_Pays permettant permettant d'afficher une liste des regions sans le pays*/
        return regionsRepository.FIND_REGION_SANS_Pays();
    }

    @Override
    public Iterable<Object[]> lireFIND_REGION_EN_FONCTION_DU_Pays(String pays) {/*C'est l'implementation de la méthode lire lireFIND_REGION_EN_FONCTION_DU_Pays permettant d'afficher une liste des regions d'un pays donné en entrant le pays en parametre*/
        return  regionsRepository.FIND_REGION_EN_FONCTION_DU_Pays(pays);
    }

    @Override
    public Iterable<Object[]> lireFIND_ALLREGION_WITH_PAYS() {
        return regionsRepository.FIND_ALLREGION_WITH_PAYS();
    }/*C'est  l'implementation de la méthode lireFIND_ALLREGION_WITH_PAYS permettant d'afficher une liste des regions avec le pays correspondant*/

    @Override
    public Iterable<Object[]> lireFIND_REGION_POPULATION_ANNEE_NBHABUTANT(String regions) {/*C'est  l'implementation de la méthode lireFIND_REGION_POPULATION_ANNEE_NBHABUTANT permettant d'afficher une liste contenant le nom de la region,  le nombre d'habitant et l'année correspondant a ce nombre  d'habitant;  d'une region donnée en parametre*/
        return regionsRepository.FIND_REGION_POPULATION_ANNEE_NBHABUTANT(regions);
    }

    @Override
    public Regions modifier(Long idRegions,Regions regions) {//*C'est  l'implementation de la méthode modifier permettant de modifier une region en spécifiant son id*//*
        return regionsRepository.findById(idRegions)
                .map(regions1 -> {
                    regions1.setNom(regions.getNom());
                    regions1.setCodeRegions(regions.getCodeRegions());
                    regions1.setLangue(regions.getLangue());
                    regions1.setSuperficie_regions(regions.getSuperficie_regions());
                    regions1.setDomaine_activite(regions.getDomaine_activite());
                    regions1.setPays(regions.getPays());
                    //regions1.setPopulation(regions.getPopulation());
                    return regionsRepository.save(regions1);
                }).orElseThrow(() -> new RuntimeException("Pays non trouvé"));
    }

    @Override
    public String supprimer(Long idRegions) {/*C'est  l'implementation de la méthode supprimer permettant de supprimer une region en spécifiant son id*/
        regionsRepository.deleteById(idRegions);
        return "Regions supprimer";
    }
}