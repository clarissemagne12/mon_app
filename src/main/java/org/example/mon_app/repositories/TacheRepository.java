package org.example.mon_app.repositories;

import org.example.mon_app.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheRepository extends JpaRepository <Tache, Long> {

    // Méthode pour récupérer les tâches par statut
    List<Tache> findByStatut(String statut);

    // Méthode pour récupérer les tâches d'un utilisateur spécifique
    List<Tache> findByUserId(Long userId);
}
