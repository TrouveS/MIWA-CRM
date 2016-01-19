package controllers;

import controllers.utils.pojo.AsyncMessagePojo.PromotionPojo.PromotionListPojo;
import controllers.utils.pojo.AsyncMessagePojo.PromotionPojo.PromotionPojo;
import controllers.utils.sender.AsyncMessageProducer;
import model.Promotion;
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
public class PromotionController {

    public static Result sendPromotionList() {
        Logger.info("Envoi promotion");
        List<PromotionPojo> promotionListPojos = new ArrayList<>();
        for (Promotion promotion: Promotion.find.all())
            promotionListPojos.add(new PromotionPojo(promotion.getClientId(), promotion.getRemise()));

        PromotionListPojo promotionListPojo = new PromotionListPojo(promotionListPojos);
        try {
            AsyncMessageProducer crm_promotion_bo_list = new AsyncMessageProducer("CRM_promotion");
            crm_promotion_bo_list.sendMessage(promotionListPojo);
            Logger.info("client message in queue {}", "CRM_promotion");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return ok();
    }

}
