/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.mon_app.entities;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.*;
/**
 *
 * @author user
 */
@Entity
@Table(catalog = "service", schema = "")
@NamedQueries({
    @NamedQuery(name = "Utilisateurs.findAll", query = "SELECT u FROM Utilisateurs u"),
    @NamedQuery(name = "Utilisateurs.findById", query = "SELECT u FROM Utilisateurs u WHERE u.id = :id"),
    @NamedQuery(name = "Utilisateurs.findByName", query = "SELECT u FROM Utilisateurs u WHERE u.name = :name"),
    @NamedQuery(name = "Utilisateurs.findByEmail", query = "SELECT u FROM Utilisateurs u WHERE u.email = :email"),
    @NamedQuery(name = "Utilisateurs.findByPassword", query = "SELECT u FROM Utilisateurs u WHERE u.password = :password")})
public class Utilisateurs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String email;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Tache> tacheCollection;

    public Utilisateurs() {
    }

    public Utilisateurs(Long id) {
        this.id = id;
    }

    public Utilisateurs(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Tache> getTacheCollection() {
        return tacheCollection;
    }

    public void setTacheCollection(Collection<Tache> tacheCollection) {
        this.tacheCollection = tacheCollection;
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
        if (!(object instanceof Utilisateurs)) {
            return false;
        }
        Utilisateurs other = (Utilisateurs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject3.Utilisateurs[ id=" + id + " ]";
    }
    
}
