package com.apigestionregion.springjwt.controllers;

import com.apigestionregion.springjwt.models.Pays;
import com.apigestionregion.springjwt.security.services.PaysService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pays")
@AllArgsConstructor
public class PaysController {




    /* Permet de creer une entrée pour*/
    @Autowired
    private final PaysService paysService;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public Pays creer(@RequestBody Pays pays) {
        return paysService.creer(pays);
    }








    /*Permet d'afficher la liste de toute les  pays*/
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/read")
    public List<Pays> lire() {
        return paysService.lire();
    }





    /*Permet de modifier un pays donné*/

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{idPays}")
    public Pays update(@PathVariable Long idPays, @RequestBody Pays pays) {
        return paysService.modifier(idPays,pays);
    }






    /*Permet de supprimer un pays donnée*/
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{idPays}")
    public String supprimer(@PathVariable Long idPays) {
        return paysService.supprimer(idPays);
    }
}
