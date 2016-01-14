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
    @Column (nullable = false)
    private String sexe;
    @Column(nullable = false)
    private String date_naissance;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idfidelite;
    @Column(nullable = false)
    private String idRue;
    @Column(nullable = false)
    private String idVille;
    @Column(nullable = false)
    private String idCodePostal;
    @Column(nullable = false)
    private String magasin;
    @Column(nullable = true)
    private String typologie;
    @Column(nullable = true)
    private Integer credit; /**Risque de credit**/
    @Column(nullable = true)
    private String typedemande;
    @Column(nullable = true, unique = true)
    private  String rib;
    @Column(nullable = true)
    private Integer rating;
    @Column(nullable = true)
    private Integer nbIncidents;


    public Clients() {
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
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

    public String getSexe(){return sexe;}

    public void setSexe(String sexe) {this.sexe = sexe;}

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

    public Long getIdFidelite() {
        return idfidelite;
    }

    public void setIdFidelite(Long idfidelite) {
        this.idfidelite = idfidelite;
    }

    public String getIdRue() {
        return idRue;
    }

    public void setIdRue(String idRue) {
        this.idRue = idRue;
    }

    public String getIdVille() {
        return idVille;
    }

    public void setIdVille(String idVille) {
        this.idVille = idVille;
    }

    public String getIdCodePostal() {
        return idCodePostal;
    }

    public void setIdCodePostal(String idCodePostal) {
        this.idCodePostal =idCodePostal;
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

    public Integer getCredit() {
        return credit;
    }
    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getTypedemande() {
        return typedemande;
    }
    public void setTypedemande(String typedemande) {
        this.typedemande = typedemande;
    }



    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getNbIncidents() {
        return nbIncidents;
    }

    public void setNbIncidents(Integer nbIncidents) {
        this.nbIncidents = nbIncidents;
    }
}


