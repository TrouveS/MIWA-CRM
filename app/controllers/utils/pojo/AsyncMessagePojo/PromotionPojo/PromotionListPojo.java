package controllers.utils.pojo.AsyncMessagePojo.PromotionPojo;

import controllers.clientManagement.PromotionList;
import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;

import java.util.List;

/**
 * Created by LuxiaMars on 12/01/2016.
 */
public class PromotionListPojo extends AsyncMessagePojo {

    private PromotionList pl;
    private List<PromotionPojo> promotionPojoList = pl.getPromotionList();

    public void action(){}

}
