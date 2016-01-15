package controllers.utils.pojo.AsyncMessagePojo.PromotionPojo;

import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import model.Promotion;

import java.util.List;

/**
 * Created by LuxiaMars on 12/01/2016.
 */
public class PromotionListPojo extends AsyncMessagePojo {

    private List<PromotionPojo> promotionClient;

    public PromotionListPojo(List<PromotionPojo> promotionClient) {
        this.promotionClient = promotionClient;
    }

    public PromotionListPojo() {
    }

    public List<PromotionPojo> getPromotionClient() {
        return promotionClient;
    }

    public void setPromotionClient(List<PromotionPojo> promotionClient) {
        this.promotionClient = promotionClient;
    }

    public void action() {

    }

}
