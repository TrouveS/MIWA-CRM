package model;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Magasin extends Model {

    @Id
    @GeneratedValue
    private Long magasin_id;
    @Column(nullable = false)
    private String id_magasin;
    @Column(nullable = false)
    private String nom_magasin;
    @Column(nullable = false)
    private String adresse_magasin;


    public Magasin(String id_magasin, String nom_magasin, String adresse_magasin) {
        this.id_magasin = id_magasin;
        this.nom_magasin = nom_magasin;
        this.adresse_magasin = adresse_magasin;
    }

    public Magasin() {
    }

    public Long getMagasin_id() {
        return magasin_id;
    }

    public void setMagasin_id(Long magasin_id) {
        this.magasin_id = magasin_id;
    }

    public String getId_magasin() {
        return id_magasin;
    }

    public void setId_magasin(String id_magasin) {
        this.id_magasin = id_magasin;
    }

    public String getNom_magasin() {
        return nom_magasin;
    }

    public void setNom_magasin(String nom_magasin) {
        this.nom_magasin = nom_magasin;
    }

    public String getAdresse_magasin() {
        return adresse_magasin;
    }

    public void setAdresse_magasin(String adresse_magasin) {
        this.adresse_magasin = adresse_magasin;
    }
}
