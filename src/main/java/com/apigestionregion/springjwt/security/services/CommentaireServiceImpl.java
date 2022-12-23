package com.apigestionregion.springjwt.security.services;

import com.apigestionregion.springjwt.models.Commentaire;
import com.apigestionregion.springjwt.models.Regions;
import com.apigestionregion.springjwt.models.User;
import com.apigestionregion.springjwt.repository.CommentaireRepository;
import com.apigestionregion.springjwt.repository.RegionsRepository;
import com.apigestionregion.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CommentaireServiceImpl implements CommentaireService {
    @Autowired
    private CommentaireRepository repo;
    @Autowired
    private RegionsRepository regionRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public Commentaire create(Commentaire commentaire, Long idRegions, Long idUser) {
        Regions regions = regionRepo.findById(idRegions).get();
        User user = userRepo.findById(idUser).get();
        commentaire.setUser(user);
        repo.save(commentaire);
        regions.getCommentaire().add(commentaire);
        regionRepo.save(regions);
        return commentaire;
    }


    @Override
    public Collection<Commentaire> readCommentaireByRegion(Long id) {

        Regions region = regionRepo.findById(id).get();

        return region.getCommentaire();
    }

}
