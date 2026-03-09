package org.example.mon_app;

import org.example.mon_app.entities.Tache;

import java.util.List;
import java.util.Optional;

public interface Tachei {

    // Créer une nouvelle tâche
    Tache createTache(Tache tache);

    // Récupérer une tâche par son ID
    Optional<Tache> getTacheById(Long id);

    // Récupérer toutes les tâches
    List<Tache> getAllTaches();

    // Mettre à jour une tâche
    Tache updateTache(Tache tache);

    // Supprimer une tâche par son ID
    void deleteTache(Long id);

    // Méthode supplémentaire : récupérer les tâches par statut
    List<Tache> getTachesByStatut(String statut);

    // Méthode supplémentaire : récupérer les tâches d'un utilisateur spécifique
    List<Tache> getTachesByUserId(Long userId);

}
