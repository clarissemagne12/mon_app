package org.example.mon_app.repositories;

import org.example.mon_app.entities.Tache;
import org.example.mon_app.entities.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UtilisateursRepository  extends JpaRepository<Utilisateurs, Long> {
    Optional<Utilisateurs> findByEmail(String email);
}
