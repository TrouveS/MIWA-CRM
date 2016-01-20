package controllers.utils.pojo.AsyncMessagePojo.PromotionPojo;

import model.Client;
import model.Promotion;
import java.util.List;

/**
 * Created by LuxiaMars on 12/01/2016.
 */
public class PromotionPojo {

    private Long client_id;
    private Integer promotion;

    public PromotionPojo(Long client_id, Integer promotion) {
        this.client_id = client_id;
        this.promotion = promotion;
    }

    public PromotionPojo() {
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Integer getPromotion() {
        return promotion;
    }

    public void setPromotion(Integer promotion) {
        this.promotion = promotion;
    }


}
