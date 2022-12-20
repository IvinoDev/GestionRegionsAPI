package com.apigestionregion.springjwt.controllers;

import com.apigestionregion.springjwt.models.Image;
import com.apigestionregion.springjwt.models.Regions;
import com.apigestionregion.springjwt.security.services.RegionsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/regions")
@AllArgsConstructor
public class RegionsController {

    @Autowired
    private final RegionsService regionsService;







    /*Permet creer une entrée pour */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = {"/create"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String creer(@RequestPart("regions") Regions regions, @RequestPart("image") MultipartFile img) {
        try {
           Image image =  uploadImage(img);
           regions.setImage(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        regionsService.creer(regions);
        return "La region a été ajouté avec succcès";
    }






    /*Permet d'afficher la liste de toute les regions avec tout les chanmps de notre entités region */
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/read")
    public Iterable<Object[]> lire() {
        return regionsService.lire();
    }







    /*Permet d'afficher la liste de toute les regions sans le pays */
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/read1")
    public Iterable<Object[]> lireFIND_REGION_SANS_Pays() {
        return regionsService.lireFIND_REGION_SANS_Pays();
    }







    /*Permet d'afficher la liste de toute les regions en fonction du pays */
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/read2/{pays}")
    public Iterable<Object[]> lireFIND_REGION_EN_FONCTION_DU_Pays(@PathVariable String pays) {
        return regionsService.lireFIND_REGION_EN_FONCTION_DU_Pays(pays);
    }






    /*Permet d'afficher la liste de toute les regions avec le pays correspondante */
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/read3")
    public Iterable<Object[]> lireFIND_ALLREGION_WITH_PAYS() {
        return regionsService. lireFIND_ALLREGION_WITH_PAYS();
    }









    /*Permet d'afficher la liste de toute les entrée d'une region donné avec le nombre d'habitant avec l'année correspondante */
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/read4/{regions}")
    public Iterable<Object[]> lireFIND_REGION_POPULATION_ANNEE_NBHABUTANT(@PathVariable String regions) {
        return regionsService.lireFIND_REGION_POPULATION_ANNEE_NBHABUTANT(regions);
    }








    /*Permet de modifier une regions donnée*/
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PutMapping("/update/{idRegions}")
    public Regions update(@PathVariable Long idRegions, @RequestBody Regions regions) {
        return regionsService.modifier(idRegions,regions);
    }






    /*Permet de supprimer une regions donnée*/
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{idRegions}")
    public String supprimer(@PathVariable Long idRegions) {
        return regionsService.supprimer(idRegions);
    }




    public Image uploadImage(MultipartFile file) throws IOException {
        Image image = new Image(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return image;
    }

}

