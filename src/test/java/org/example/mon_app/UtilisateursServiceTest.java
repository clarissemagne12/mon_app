package org.example.mon_app;

import org.example.mon_app.Utilisateursi;
import org.example.mon_app.entities.Utilisateurs;
import org.example.mon_app.repositories.UtilisateursRepository;
import org.example.mon_app.services.UtilisateursService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UtilisateursServiceTest {

    private UtilisateursRepository utilisateursRepository;
    private Utilisateursi utilisateursService;

    @BeforeEach
    void setUp() {
        utilisateursRepository = mock(UtilisateursRepository.class);
        utilisateursService = new UtilisateursService(utilisateursRepository);
    }

    @Test
    void testCreateUser() {
        Utilisateurs user = new Utilisateurs();
        user.setName("John");
        user.setEmail("john@example.com");
        user.setPassword("pass123");

        when(utilisateursRepository.save(user)).thenReturn(user);

        Utilisateurs created = utilisateursService.createUser(user);

        assertNotNull(created);
        assertEquals("John", created.getName());
        verify(utilisateursRepository, times(1)).save(user);
    }

    @Test
    void testGetUserById() {
        Utilisateurs user = new Utilisateurs();
        user.setId(1L);
        user.setName("Alice");

        when(utilisateursRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<Utilisateurs> found = utilisateursService.getUserById(1L);

        assertTrue(found.isPresent());
        assertEquals("Alice", found.get().getName());
    }

    @Test
    void testGetAllUsers() {
        Utilisateurs user1 = new Utilisateurs();
        user1.setId(1L);
        user1.setName("Alice");

        Utilisateurs user2 = new Utilisateurs();
        user2.setId(2L);
        user2.setName("Bob");

        when(utilisateursRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<Utilisateurs> allUsers = utilisateursService.getAllUsers();

        assertEquals(2, allUsers.size());
    }

    @Test
    void testUpdateUser() {
        Utilisateurs user = new Utilisateurs();
        user.setId(1L);
        user.setName("Alice");

        when(utilisateursRepository.existsById(1L)).thenReturn(true);
        when(utilisateursRepository.save(user)).thenReturn(user);

        Utilisateurs updated = utilisateursService.updateUser(user);

        assertEquals("Alice", updated.getName());
        verify(utilisateursRepository, times(1)).save(user);
    }

    @Test
    void testDeleteUser() {
        when(utilisateursRepository.existsById(1L)).thenReturn(true);

        utilisateursService.deleteUser(1L);

        verify(utilisateursRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetUserByEmail() {
        Utilisateurs user = new Utilisateurs();
        user.setEmail("test@example.com");

        when(utilisateursRepository.findByEmail("test@example.com"))
                .thenReturn(Optional.of(user));

        Optional<Utilisateurs> found = utilisateursService.getUserByEmail("test@example.com");

        assertTrue(found.isPresent());
        assertEquals("test@example.com", found.get().getEmail());
    }
}