package controllers.utils.pojo.AsyncMessagePojo.Magasin;


import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import model.Magasin;

import java.util.List;

public class ListeMagasinPojo extends AsyncMessagePojo {

    private List<MagasinPojo> liste_magasin;

    public ListeMagasinPojo() {
    }

    public ListeMagasinPojo(List<MagasinPojo> liste_magasin) {
        this.liste_magasin = liste_magasin;
    }

    @Override
    public void action() {
        for (MagasinPojo pojo : liste_magasin)
            if (Magasin.find.where().eq("magasin_name", pojo.getNom_magasin()) == null)
                new Magasin(pojo.getNom_magasin()).save();

    }

    public List<MagasinPojo> getListe_magasin() {
        return liste_magasin;
    }

    public void setListe_magasin(List<MagasinPojo> liste_magasin) {
        this.liste_magasin = liste_magasin;
    }
}


