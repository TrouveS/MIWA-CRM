package model;

import play.db.ebean.Model;

import javax.persistence.*;
/**
 * Created by AmdouniNajla on 08/01/2016.
 */
@Entity
public class Promotion extends Model{

    public static Integer[] montantPromotion = new Integer[] {10, 15, 20, 25, 30, 35, 40, 50, 60, 70};

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long promotionId;
    @Column(nullable = false)
    private Long clientId;
    @Column(nullable = false)
    private int Remise;


    public Promotion(){
    }

    public Promotion(Long clientId, int remise) {
        this.clientId = clientId;
        Remise = remise;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public int getRemise() {
        return Remise;
    }

    public void setRemise(int remise) {
        Remise = remise;
    }
}
