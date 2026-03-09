package org.example.mon_app;

import org.example.mon_app.Tachei;
import org.example.mon_app.entities.Tache;
import org.example.mon_app.entities.Utilisateurs;
import org.example.mon_app.repositories.TacheRepository;
import org.example.mon_app.services.TacheService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TacheServiceTest {

    private TacheRepository tacheRepository;
    private Tachei tacheService;

    @BeforeEach
    void setUp() {
        tacheRepository = mock(TacheRepository.class);
        tacheService = new TacheService(tacheRepository);
    }

    @Test
    void testCreateTache() {
        Tache tache = new Tache();
        tache.setTitle("Tâche 1");
        tache.setDescription("Description 1");
        tache.setStatut("EN_COURS");

        when(tacheRepository.save(tache)).thenReturn(tache);

        Tache created = tacheService.createTache(tache);

        assertNotNull(created);
        assertEquals("Tâche 1", created.getTitle());
        verify(tacheRepository, times(1)).save(tache);
    }

    @Test
    void testGetTacheById() {
        Tache tache = new Tache();
        tache.setId(1L);
        tache.setTitle("Tâche 1");

        when(tacheRepository.findById(1L)).thenReturn(Optional.of(tache));

        Optional<Tache> found = tacheService.getTacheById(1L);

        assertTrue(found.isPresent());
        assertEquals("Tâche 1", found.get().getTitle());
    }

    @Test
    void testGetAllTaches() {
        Tache t1 = new Tache();
        t1.setId(1L);
        t1.setTitle("Tâche 1");

        Tache t2 = new Tache();
        t2.setId(2L);
        t2.setTitle("Tâche 2");

        when(tacheRepository.findAll()).thenReturn(Arrays.asList(t1, t2));

        List<Tache> allTaches = tacheService.getAllTaches();

        assertEquals(2, allTaches.size());
    }

    @Test
    void testUpdateTache() {
        Tache tache = new Tache();
        tache.setId(1L);
        tache.setTitle("Tâche 1");

        when(tacheRepository.save(tache)).thenReturn(tache);

        Tache updated = tacheService.updateTache(tache);

        assertEquals("Tâche 1", updated.getTitle());
        verify(tacheRepository, times(1)).save(tache);
    }

    @Test
    void testDeleteTache() {
        tacheService.deleteTache(1L);
        verify(tacheRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetTachesByStatut() {
        Tache t1 = new Tache();
        t1.setId(1L);
        t1.setStatut("EN_COURS");

        when(tacheRepository.findByStatut("EN_COURS")).thenReturn(List.of(t1));

        List<Tache> taches = tacheService.getTachesByStatut("EN_COURS");

        assertEquals(1, taches.size());
        assertEquals("EN_COURS", taches.get(0).getStatut());
    }

    @Test
    void testGetTachesByUserId() {
        Utilisateurs user = new Utilisateurs();
        user.setId(1L);

        Tache t1 = new Tache();
        t1.setId(1L);
        t1.setUserId(user);

        when(tacheRepository.findByUserId(1L)).thenReturn(List.of(t1));

        List<Tache> taches = tacheService.getTachesByUserId(1L);

        assertEquals(1, taches.size());
        assertEquals(1L, taches.get(0).getUserId().getId());
    }
}