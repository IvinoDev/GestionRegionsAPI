package com.apigestionregion.springjwt.controllers;

import com.apigestionregion.springjwt.models.Population;
import com.apigestionregion.springjwt.security.services.PopulationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/population")
@AllArgsConstructor
public class PopulationController {
    @Autowired
    private final PopulationService populationService;



    @PreAuthorize("hasRole('ADMIN')")
    /*LA CREATION D'UNE ENTREE POUR LA POPULATION C'EST A DIRE SON CONTENU*/
    @PostMapping("/create")
    public Population creer(@RequestBody Population population) {

        return populationService.creer(population);
    }




    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    /*LA RECUPERATION DE LA POPULATION SOUS FORME DE LISTE*/
    @GetMapping("/read")
    public Iterable<Object[]> lire() {
        return populationService.lire();
    }




    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    /*Permet d'obtenir une liste du nombre d'habitant et l'année ce la population en fonction de la region entrer*/
    @GetMapping("/read1/{regions}")
    public Iterable<Object[]> lireFIND_EN_FONCTION_REGIONENTRER_ALL_NONMBRE_HABITANT_AND_ANNEE(@PathVariable String regions) {
        return populationService.lireFIND_EN_FONCTION_REGIONENTRER_ALL_NONMBRE_HABITANT_AND_ANNEE(regions);
    }





    @PreAuthorize("hasRole('ADMIN')")
   // lA MISE A JOUR DE LA POPULATION
    @PutMapping("/update/{idPopulation}")
    public Population update(@PathVariable Long idPopulation, @RequestBody Population population) {
        return populationService.modifier(idPopulation,population);
    }




    @PreAuthorize("hasRole('ADMIN')")
    /*Permet de modifier la population*/
    @DeleteMapping("/delete/{id}")
    public String supprimer(@PathVariable Long id) {
        return populationService.supprimer(id);
    }


}

