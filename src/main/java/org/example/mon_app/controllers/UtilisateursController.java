package org.example.mon_app.controllers;

import org.example.mon_app.Utilisateursi;
import org.example.mon_app.entities.Utilisateurs;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UtilisateursController {

    private final Utilisateursi utilisateursService;

    public UtilisateursController(Utilisateursi utilisateursService) {
        this.utilisateursService = utilisateursService;
    }

    // Créer un nouvel utilisateur
    @PostMapping
    public ResponseEntity<Utilisateurs> createUser(@RequestBody Utilisateurs user) {
        Utilisateurs created = utilisateursService.createUser(user);
        return ResponseEntity.ok(created);
    }

    // Récupérer un utilisateur par ID
    @GetMapping("/{id}")
    public ResponseEntity<Utilisateurs> getUserById(@PathVariable Long id) {
        Optional<Utilisateurs> user = utilisateursService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Récupérer tous les utilisateurs
    @GetMapping
    public ResponseEntity<List<Utilisateurs>> getAllUsers() {
        List<Utilisateurs> users = utilisateursService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Mettre à jour un utilisateur
    @PutMapping("/{id}")
    public ResponseEntity<Utilisateurs> updateUser(@PathVariable Long id, @RequestBody Utilisateurs userDetails) {
        Optional<Utilisateurs> existing = utilisateursService.getUserById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Utilisateurs user = existing.get();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        Utilisateurs updated = utilisateursService.updateUser(user);
        return ResponseEntity.ok(updated);
    }

    // Supprimer un utilisateur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<Utilisateurs> existing = utilisateursService.getUserById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        utilisateursService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // Récupérer un utilisateur par email
    @GetMapping("/email/{email}")
    public ResponseEntity<Utilisateurs> getUserByEmail(@PathVariable String email) {
        Optional<Utilisateurs> user = utilisateursService.getUserByEmail(email);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}