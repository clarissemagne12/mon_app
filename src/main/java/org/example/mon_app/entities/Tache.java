/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.mon_app.entities;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 *
 * @author user
 */
@Entity
@Table(catalog = "service", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tache.findAll", query = "SELECT t FROM Tache t"),
    @NamedQuery(name = "Tache.findById", query = "SELECT t FROM Tache t WHERE t.id = :id"),
    @NamedQuery(name = "Tache.findByTitle", query = "SELECT t FROM Tache t WHERE t.title = :title"),
    @NamedQuery(name = "Tache.findByDescription", query = "SELECT t FROM Tache t WHERE t.description = :description"),
    @NamedQuery(name = "Tache.findByStatut", query = "SELECT t FROM Tache t WHERE t.statut = :statut")})
public class Tache implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String title;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String description;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String statut;
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Utilisateurs userId;

    public Tache() {
    }

    public Tache(Long id) {
        this.id = id;
    }

    public Tache(Long id, String title, String description, String statut) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.statut = statut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Utilisateurs getUserId() {
        return userId;
    }

    public void setUserId(Utilisateurs userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tache)) {
            return false;
        }
        Tache other = (Tache) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject3.Tache[ id=" + id + " ]";
    }
    
}
