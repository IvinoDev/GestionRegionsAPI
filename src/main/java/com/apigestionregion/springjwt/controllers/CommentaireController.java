package com.apigestionregion.springjwt.controllers;


import com.apigestionregion.springjwt.models.Commentaire;
import com.apigestionregion.springjwt.repository.CommentaireRepository;
import com.apigestionregion.springjwt.security.services.CommentaireService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/comments")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

//    @Autowired
//    CommentaireRepository commentaireRepo;


    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @PostMapping("/create/{idRegions}/{idUser}")
    public Commentaire addCommentaire(@PathVariable Long idRegions, @PathVariable Long idUser, @RequestBody Commentaire commentaire)
    {
        return commentaireService.create(commentaire, idRegions, idUser);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/read/{id}")
    public Collection<Commentaire> readCommentaire(@PathVariable Long id)
    {
        return commentaireService.readCommentaireByRegion(id);
    }
}
