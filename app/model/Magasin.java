package model;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Magasin extends Model {
    public static Finder<Long, Magasin> find = new Finder<>(Long.class, Magasin.class);
    @Id
    @GeneratedValue
    private Long magasin_id;
    @Column(nullable = false, unique = true)
    private String magasin_name;

    public Magasin(String magasin_name) {
        this.magasin_name = magasin_name;
    }

    public Magasin() {
    }

    public Long getMagasin_id() {
        return magasin_id;
    }

    public void setMagasin_id(Long magasin_id) {
        this.magasin_id = magasin_id;
    }

    public String getMagasin_name() {
        return magasin_name;
    }

    public void setMagasin_name(String magasin_name) {
        this.magasin_name = magasin_name;
    }
}
