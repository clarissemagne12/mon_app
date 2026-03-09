package org.example.mon_app.controllers;

import org.example.mon_app.Tachei;
import org.example.mon_app.entities.Tache;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/taches")
public class TacheController {

    private final Tachei tacheService;

    public TacheController(Tachei tacheService) {
        this.tacheService = tacheService;
    }

    // Créer une nouvelle tâche
    @PostMapping
    public ResponseEntity<Tache> createTache(@RequestBody Tache tache) {
        Tache created = tacheService.createTache(tache);
        return ResponseEntity.ok(created);
    }

    // Récupérer une tâche par ID
    @GetMapping("/{id}")
    public ResponseEntity<Tache> getTacheById(@PathVariable Long id) {
        Optional<Tache> tache = tacheService.getTacheById(id);
        return tache.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Récupérer toutes les tâches
    @GetMapping
    public ResponseEntity<List<Tache>> getAllTaches() {
        List<Tache> taches = tacheService.getAllTaches();
        return ResponseEntity.ok(taches);
    }

    // Mettre à jour une tâche
    @PutMapping("/{id}")
    public ResponseEntity<Tache> updateTache(@PathVariable Long id, @RequestBody Tache tacheDetails) {
        Optional<Tache> existing = tacheService.getTacheById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Tache tache = existing.get();
        tache.setTitle(tacheDetails.getTitle());
        tache.setDescription(tacheDetails.getDescription());
        tache.setStatut(tacheDetails.getStatut());
        tache.setUserId(tacheDetails.getUserId());
        Tache updated = tacheService.updateTache(tache);
        return ResponseEntity.ok(updated);
    }

    // Supprimer une tâche
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTache(@PathVariable Long id) {
        Optional<Tache> existing = tacheService.getTacheById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        tacheService.deleteTache(id);
        return ResponseEntity.noContent().build();
    }

    // Récupérer les tâches par statut
    @GetMapping("/statut/{statut}")
    public ResponseEntity<List<Tache>> getTachesByStatut(@PathVariable String statut) {
        List<Tache> taches = tacheService.getTachesByStatut(statut);
        return ResponseEntity.ok(taches);
    }

    // Récupérer les tâches par utilisateur
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Tache>> getTachesByUserId(@PathVariable Long userId) {
        List<Tache> taches = tacheService.getTachesByUserId(userId);
        return ResponseEntity.ok(taches);
    }
}