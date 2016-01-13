package controllers.clientManagement;

import controllers.utils.pojo.AsyncMessagePojo.ClientMessagePojo.ClientMessagePojo;
import controllers.utils.pojo.AsyncMessagePojo.PromotionPojo.PromotionListPojo;
import controllers.utils.pojo.AsyncMessagePojo.PromotionPojo.PromotionPojo;
import controllers.utils.sender.AsyncMessageProducer;
import play.Logger;
import play.mvc.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static play.mvc.Results.ok;

/**
 * Created by LuxiaMars on 11/01/2016.
 */
public class PromotionList {

    private static List<PromotionPojo> promotionList = new ArrayList<>();

    public PromotionList() {
    }

    public List<PromotionPojo> getPromotionList() {
        return promotionList;
    }

    private static void cleanPromotionList() {
        promotionList.clear();
    }

    public void addToPromotiontList(PromotionPojo promotion) {
        promotionList.add(promotion);
    }

    public static Result sendPromotionList() {
        PromotionListPojo promotionListPojo = new PromotionListPojo();
        try {
            AsyncMessageProducer crm_promotion_bo_list = new AsyncMessageProducer("CRM_to_BACKOFFICE_promotion");
            crm_promotion_bo_list.sendMessage(promotionListPojo);
            cleanPromotionList();
            Logger.info("client message in queue {}", "CRM_to_BACKOFFICE_client");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        try {
            AsyncMessageProducer crm_promotion_crm_list = new AsyncMessageProducer("CRM_to_ECOMMERCE_promotion");
            crm_promotion_crm_list.sendMessage(promotionListPojo);
            cleanPromotionList();
            Logger.info("client message in queue {}", "CRM_to_ECOMMERCE_client");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return ok();
    }
}
