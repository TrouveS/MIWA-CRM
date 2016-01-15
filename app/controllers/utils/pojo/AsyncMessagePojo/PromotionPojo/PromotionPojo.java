package controllers.utils.pojo.AsyncMessagePojo.PromotionPojo;

import controllers.clientManagement.PromotionList;
import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import model.Client;
import model.Promotion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LuxiaMars on 12/01/2016.
 */
public class PromotionPojo extends AsyncMessagePojo{

    private Long client_id;
    private Integer promotion;

    @Override
    public void action(){

        List<Client> clients = new ArrayList<>();
        PromotionList promotionList = new PromotionList();
        PromotionPojo promo = new PromotionPojo();
        clients = (List<Client>) Client.find.orderBy("rating desc").findPagingList(2).getPage(0).getList();

        for (int i = 0; i<2; i++) {
            /** Selection client aleatoire**/
            promo.client_id = clients.get(i).getUserId();

            /** Selection promotion aleatoire **/
            Integer size = Promotion.montantPromotion.length;
            Integer randomNum = 0 + (int) (Math.random() * (size - 1));
            promo.promotion = (Promotion.montantPromotion[randomNum]);

            /** Push promotion dans la liste **/
            promotionList.addToPromotiontList(promo);
        }
    }

}
