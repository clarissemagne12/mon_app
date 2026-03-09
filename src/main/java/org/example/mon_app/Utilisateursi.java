package org.example.mon_app;

import org.example.mon_app.entities.Utilisateurs;

import java.util.List;
import java.util.Optional;

public interface Utilisateursi {


    // Créer un nouvel utilisateur
    Utilisateurs createUser(Utilisateurs utilisateurs);

    // Récupérer un utilisateur par ID
    Optional<Utilisateurs> getUserById(Long id);

    // Récupérer tous les utilisateurs
    List<Utilisateurs> getAllUsers();

    // Mettre à jour un utilisateur
    Utilisateurs updateUser(Utilisateurs utilisateurs);

    // Supprimer un utilisateur par ID
    void deleteUser(Long id);

    // Récupérer un utilisateur par email (utile pour login)
    Optional<Utilisateurs> getUserByEmail(String email);
}
