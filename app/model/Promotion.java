package model;

import play.db.ebean.Model;

import java.util.List;
import javax.persistence.*;
/**
 * Created by AmdouniNajla on 08/01/2016.
 */
public class Promotion extends Model{

    public static Finder<Long, Promotion> find = new Finder<>(Long.class, Promotion.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;
    @Column(nullable = false)
    private int Remise;


    public Promotion() {
    }

    public Promotion(Long clientId, int Remise) {
        this.clientId = clientId;
        this.Remise = Remise;
    }

    public int getRemise() {
        return Remise;
    }
    public void setRemise(int Remise) {
        this.Remise = Remise;
    }

}
