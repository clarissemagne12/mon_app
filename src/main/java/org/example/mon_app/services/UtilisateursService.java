package org.example.mon_app.services;

import org.example.mon_app.Utilisateursi;
import org.example.mon_app.entities.Utilisateurs;
import org.example.mon_app.repositories.UtilisateursRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateursService implements Utilisateursi {

    private final UtilisateursRepository utilisateursRepository;

    public UtilisateursService(UtilisateursRepository utilisateursRepository) {
        this.utilisateursRepository = utilisateursRepository;
    }

    @Override
    public Utilisateurs createUser(Utilisateurs utilisateurs) {
        return utilisateursRepository.save(utilisateurs);
    }

    @Override
    public Optional<Utilisateurs> getUserById(Long id) {
        return utilisateursRepository.findById(id);
    }

    @Override
    public List<Utilisateurs> getAllUsers() {
        return utilisateursRepository.findAll();
    }

    @Override
    public Utilisateurs updateUser(Utilisateurs utilisateurs) {
        if (!utilisateursRepository.existsById(utilisateurs.getId())) {
            throw new IllegalArgumentException("Utilisateur non trouvé avec l'id : " + utilisateurs.getId());
        }
        return utilisateursRepository.save(utilisateurs);
    }

    @Override
    public void deleteUser(Long id) {
        if (!utilisateursRepository.existsById(id)) {
            throw new IllegalArgumentException("Utilisateur non trouvé avec l'id : " + id);
        }
        utilisateursRepository.deleteById(id);
    }

    @Override
    public Optional<Utilisateurs> getUserByEmail(String email) {
        return utilisateursRepository.findByEmail(email);
    }
}