package com.apigestionregion.springjwt.security.services;

import com.apigestionregion.springjwt.models.Commentaire;
import com.apigestionregion.springjwt.models.Regions;

import java.util.Collection;
import java.util.List;

public interface CommentaireService {

    Commentaire create(Commentaire commentaire, Long idRegions, Long idUser);

    Collection<Commentaire> readCommentaireByRegion(Long id);

//    Regions getById(Long id);

}
