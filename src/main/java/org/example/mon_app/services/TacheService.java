package org.example.mon_app.services;

import org.example.mon_app.Tachei;
import org.example.mon_app.entities.Tache;
import org.example.mon_app.repositories.TacheRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacheService implements Tachei {

    private final TacheRepository tacheRepository;

    public TacheService(TacheRepository tacheRepository) {
        this.tacheRepository = tacheRepository;
    }

    @Override
    public Tache createTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public Optional<Tache> getTacheById(Long id) {
        return tacheRepository.findById(id);
    }

    @Override
    public List<Tache> getAllTaches() {
        return tacheRepository.findAll();
    }

    @Override
    public Tache updateTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public void deleteTache(Long id) {
        tacheRepository.deleteById(id);
    }

    @Override
    public List<Tache> getTachesByStatut(String statut) {
        return tacheRepository.findByStatut(statut);
    }

    @Override
    public List<Tache> getTachesByUserId(Long userId) {
        return tacheRepository.findByUserId(userId);
    }
}