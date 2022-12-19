package com.apigestionregion.springjwt.security.services;

import com.apigestionregion.springjwt.models.Pays;
import com.apigestionregion.springjwt.repository.PaysRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PaysServiceImpl implements PaysService{
    private final PaysRepository paysRepository;
    @Override
    public Pays creer(Pays pays) {
        return paysRepository.save(pays); /*C'est  l'implementation de la méthode permettant de creer un pays*/
    }

    @Override
    public List<Pays> lire() {
        return paysRepository.findAll();
    }/*C'est  l'implementation de la méthode permettant d'afficher une liste des pays créer*/

    @Override
    public Pays modifier(Long idPays, Pays pays) {//*C'est l'implementation de la méthode permettant de modifier un pays*//*
        return paysRepository.findById(idPays)
                .map(pays1 -> {
                    pays1.setNom(pays.getNom());
                    return paysRepository.save(pays1);
                }).orElseThrow(() -> new RuntimeException("Pays non trouvé"));
    }

    @Override
    public String supprimer(Long idPays) {/*C'est l'implementation de la méthode permettant de supprimer un pays*/
        paysRepository.deleteById(idPays);
        return "Pays supprimer";
    }
}