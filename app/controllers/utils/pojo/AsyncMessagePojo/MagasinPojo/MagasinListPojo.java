package controllers.utils.pojo.AsyncMessagePojo.MagasinPojo;

import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import model.Magasin;

import java.util.List;

/**
 * Created by Calu on 20/01/2016.
 */
public class MagasinListPojo extends AsyncMessagePojo {

    private List<MagasinPojo> liste_magasin;

    public MagasinListPojo(List<MagasinPojo> liste_magasin) {
        this.liste_magasin = liste_magasin;
    }

    public MagasinListPojo() {
    }

    public List<MagasinPojo> getListe_magasin() {
        return liste_magasin;
    }

    public void setListe_magasin(List<MagasinPojo> liste_magasin) {
        this.liste_magasin = liste_magasin;
    }

    @Override
    public void action() {

        for (MagasinPojo store : liste_magasin)
        {
            Magasin magasin = new Magasin();
            magasin.setId_magasin(store.getId_magasin());
            magasin.setNom_magasin(store.getNom_magasin());
            magasin.setAdresse_magasin(store.getAdresse_magasin());
            magasin.save();
        }
    }
}