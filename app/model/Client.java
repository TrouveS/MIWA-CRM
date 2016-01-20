package model;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by AmdouniNajla on 08/01/2016.
 */
@Entity
public class Client extends Model {


    public static Finder<Long, Client> find = new Finder<>(Long.class, Client.class);
    @Column(nullable = false, unique = true)
    public String email;
    @Id
    @GeneratedValue()
    private Long clientId; // Id fidelise same
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String sexe;
    @Column(nullable = false)
    private Date date_naissance;
    @Column(nullable = false)
    private Long client_id_local;
    @Column(nullable = false)
    private String idRue;
    @Column(nullable = false)
    private String idVille;
    @Column(nullable = false)
    private String idCodePostal;
    @Column(nullable = false)
    private String magasinId;
    @Column()
    private String typologie;
    @Column()
    private Integer credit;
    /**
     * Risque de credit
     **/
    @Column()
    private String typedemande;
    @Column(unique = true)
    private String rib;
    @Column()
    private Integer rating;
    @Column()
    private Integer nbIncidents;


    public Client(String email, String nom, String prenom, String sexe, Date date_naissance, Long client_id_local, String idRue, String idVille, String idCodePostal, String magasinId) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.date_naissance = date_naissance;
        this.client_id_local = client_id_local;
        this.idRue = idRue;
        this.idVille = idVille;
        this.idCodePostal = idCodePostal;
        this.magasinId = magasinId;

        for (int i = 0; i < 4; i++) {
            Double rib_gen = 1000 + (Math.random() * (9999 - 1000));
            Integer rib_body = rib_gen.intValue();
            rib = rib + rib_body.toString() + "-";
        }
        Double cle_gen = 10 + (Math.random() * (99 - 10));
        Integer cle = cle_gen.intValue();
        rib = rib + cle.toString();
        rating = 100;
    }

    public Client() {
        Double rib_gen = 1000 + (Math.random() * (9999 - 1000));
        Integer rib_body = rib_gen.intValue();
        rib = rib_body.toString() + "-";

        for (int i = 1; i < 4; i++) {
            rib_gen = 1000 + (Math.random() * (9999 - 1000));
            rib_body = rib_gen.intValue();
            rib = rib + rib_body.toString() + "-";
        }
        Double cle_gen = 10 + (Math.random() * (99 - 10));
        Integer cle = cle_gen.intValue();
        rib = rib + cle.toString();
        rating = 100;
    }

    public Integer getNbIncidents() {
        return nbIncidents;
    }

    public void setNbIncidents(Integer nbIncidents) {
        this.nbIncidents = nbIncidents;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getTypedemande() {
        return typedemande;
    }

    public void setTypedemande(String typedemande) {
        this.typedemande = typedemande;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getTypologie() {
        return typologie;
    }

    public void setTypologie(String typologie) {
        this.typologie = typologie;
    }

    public String getMagasinId() {
        return magasinId;
    }

    public void setMagasinId(String magasinId) {
        this.magasinId = magasinId;
    }

    public String getIdCodePostal() {
        return idCodePostal;
    }

    public void setIdCodePostal(String idCodePostal) {
        this.idCodePostal = idCodePostal;
    }

    public String getIdVille() {
        return idVille;
    }

    public void setIdVille(String idVille) {
        this.idVille = idVille;
    }

    public String getIdRue() {
        return idRue;
    }

    public void setIdRue(String idRue) {
        this.idRue = idRue;
    }

    public Long getClient_id_local() {
        return client_id_local;
    }

    public void setClient_id_local(Long client_id_local) {
        this.client_id_local = client_id_local;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


