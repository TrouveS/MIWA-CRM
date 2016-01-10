package model;

import play.db.ebean.Model;
import java.util.List;
import javax.persistence.*;
/**
 * Created by AmdouniNajla on 08/01/2016.
 */
@Entity
public class Clients extends Model {


    public static Finder<Long, Clients> find = new Finder<>(Long.class, Clients.class);
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false, unique = true)
    public String email;
    @Column(nullable = false)
    private String date_naissance;
    @Column(nullable = false)
    private Boolean fidelise;
    @Column(nullable = false)
    private String adresse;
    @Column(nullable = false)
    private String magasin;
    @Column(nullable = false)
    private String typologie;
    @Column(nullable = false)
    private String typedemande;
    @Column(nullable = false, unique = true)
    private  Long rib;
    @Column(nullable = false)
    private String typeincident;
    @Column(nullable = false)


    public Clients() {
    }

    public Clients(String nom, String prenom, String email, String date_naissance, Boolean fidelise, String adresse, String magasin, String typologie, String typedemande, Long rib, String typeincident) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_naissance = date_naissance;
        this.fidelise = fidelise;
        this.adresse = adresse;
        this.magasin = magasin;
        this.typologie = typologie;
        this.typedemande = typedemande;
        this.rib = rib;
        this.typeincident = typeincident;

    }

    public Long getUserId() {
        return clientId;
    }

    public void setUserId(Long userId) {
        this.clientId = userId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date_naissance;
    }

    public void setDate(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public boolean getFidelise() {
        return fidelise;
    }

    public void setFidelise(Boolean fidelise) {
        this.fidelise = fidelise;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMagasin() {
        return magasin;
    }

    public void setMagasin(String magasin) {
        this.magasin = magasin;
    }

    public String getTypologie() {
        return typologie;
    }

    public void setTypologie(String typologie) {
        this.typologie = typologie;
    }

    public String getTypedemande() {
        return typedemande;
    }
    public void setTypedemande(String typedemande) {
        this.typedemande = typedemande;
    }
    public Long getRib() {
        return rib;
    }

    public void setRib(Long rib) {
        this.rib = rib;
    }

    public String getTypeincident() {
        return typeincident;
    }
    public void setTypeincident(String typeincident) {
        this.typeincident = typeincident;
    }
}


