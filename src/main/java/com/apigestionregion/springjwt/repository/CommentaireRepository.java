package com.apigestionregion.springjwt.repository;

import com.apigestionregion.springjwt.models.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
//    List<Commentaire> findAllById(Long id);
}
