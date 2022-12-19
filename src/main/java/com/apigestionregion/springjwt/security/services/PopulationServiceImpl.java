package com.apigestionregion.springjwt.security.services;

import com.apigestionregion.springjwt.models.Population;
import com.apigestionregion.springjwt.repository.PopulationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PopulationServiceImpl implements PopulationService{
    private final PopulationRepository populationRepository;
    @Override
    public Population creer(Population population) {/*C'est  l'implementation de la méthode creer de l'interface PopulationService*/
        return populationRepository.save(population);

    }

    @Override
    public Iterable<Object[]> lire() {/*C'est  l'implementation de la méthode lire de l'interface PopulationService*/
        return populationRepository.FINDALLREGIONWITH_NONMBRE_HABITANT_AND_ANNEE();
    }

    @Override
    public Iterable<Object[]> lireFIND_EN_FONCTION_REGIONENTRER_ALL_NONMBRE_HABITANT_AND_ANNEE(String regions) {/*C'est  l'implementation de la méthode lireFIND_EN_FONCTION_REGIONENTRER_ALL_NONMBRE_HABITANT_AND_ANNEE de l'interface PopulationService*/
        return populationRepository.FIND_EN_FONCTION_REGIONENTRER_ALL_NONMBRE_HABITANT_AND_ANNEE( regions);
    }

    @Override
    public Population modifier(Long idPopulation, Population population) {//*C'est  l'implementation de la méthode modifier de l'interface PopulationService*//*
        return populationRepository.findById(idPopulation)
                .map(population1 -> {
                    population1.setAnnee(population.getAnnee());
                    population1.setNbHabitant(population.getNbHabitant());
                    population1.setRegions(population.getRegions());

                    return populationRepository.save(population1);
                }).orElseThrow(() -> new RuntimeException("Pays non trouvé"));
    }

    @Override
    public String supprimer(Long id) {/*C'est  l'implementation de la méthode supprimer de l'interface PopulationService*/
        populationRepository.deleteById(id);
        return "Regions supprimer";
    }
}
