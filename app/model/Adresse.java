package model;
import play.db.ebean.Model;

import java.util.List;
import javax.persistence.*;
/**
 * Created by AmdouniNajla on 08/01/2016.
 */
@Entity
public class Adresse extends Model {


    public static Finder<Long, Adresse> find = new Finder<>(Long.class, Adresse.class);

    @Column(nullable = false, unique = true)
    private  Long rue;
    @Column(nullable = false)
    private String Ville;
    @Column(nullable = false)
    private Int CodePostal;


    public Adresse() {
    }

    public Adresse(Long rue, String Ville, Int Codepostal) {
        this.rue = rue;
        this.Ville = Ville;
        this.CodePostal = CodePostal;
    }

    public String getVille() {
        return Ville;
    }
    public void setVille(String Ville) {
        this.Ville = Ville;
    }

    public Long getRue() {
        return rue;
    }

    public void setRue(Long rue) {
        this.rue = rue;
    }

    public Int getCodePostal() {
        return CodePostal;
    }
    public void setCodePostal(Int CodePostal) {
        this.CodePostal = CodePostal;
    }
}