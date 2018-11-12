/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class Agenda {

    ArrayList<RdV> agd;

    /*
    String nom;
    
     */
    
    //constructeur par défaut
    Agenda() {
        this.agd = null;
    }

    //constructeur surchargé
    Agenda(ArrayList<RdV> _agd) {
        this.agd.addAll(_agd);
    }

    //autres methodes
    /**
     * sauvegarder ET fermer l'agenda
     */
    
    
    /**
     * afficher tous les Rdvs (par date et horaires croissants) entre 2 dates
     */
    
    
    /**
     * afficher les RdVs correspondant a un critere ou une conjonction de
     * criteres
     */
    
    /**
     * modifier un RdV
     */
    
    
    /**
     * ajouter un RdV (si le creneau date-horaire est libre)
     */
    
    
    void ajoutRdV(RdV _rdv) {
        for (RdV elem_agenda : this.agd) {
            /*if (s'il n'existe aucun elem_agenda.getHdebut()
                et s'il n'existe aucun elem_agenda.getHfin()
                entre _rdv.getHdebut() et _rdv.getHfin())*/{
                this.agd.add(_rdv);
            }
        }
    }

    /**
     * supprimer un RdV
     */
    void suppressionRdV(RdV _rdv){
        this.agd.remove(_rdv);
    }
    
    /**
     * supprimer TOUS les RdVs
     */
    void suppressionRdV_all(){
        //on vide l'agenda de ses elements
        for(RdV elem_agenda : this.agd){
            this.agd.remove(elem_agenda);
        }
        //on reinitialise a null l'objet agenda
        this.agd=null;
    }
    
}
