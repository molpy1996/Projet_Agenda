/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Victor BRIERE
 */
public class RdV implements Comparable <RdV> {

    private LocalDate date;
    private LocalTime h_debut;
    private LocalTime h_fin;
    private String libelle;
    private boolean rappel;

    //constructeur par defaut
    public RdV() {
        this.date = LocalDate.parse("0000-00-00");
        this.h_debut = LocalTime.parse("00:00");
        this.h_fin = LocalTime.parse("00:00");
        this.libelle = null;
        this.rappel = false;
    }

    //constructeur surchargÃ©
    public RdV(LocalDate _date, LocalTime _h_debut, LocalTime _h_fin, String _libelle,
            boolean _rappel) {
        this.setDate(_date);
        this.setHdebut(_h_debut);
        this.setHfin(_h_fin);
        this.setLibelle(_libelle);
        this.setRappel(_rappel);
    }

    //getters
    public LocalDate getDate() {
        return this.date;
    }

    public LocalTime getHdebut() {
        return this.h_debut;
    }

    public LocalTime getHfin() {
        return this.h_fin;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public boolean getRappel() {
        return this.rappel;
    }

    //setters
    public final void setDate(LocalDate _date) {
        this.date = _date;
    }

    public final void setHdebut(LocalTime _h_debut) {
        this.h_debut = _h_debut;
    }

    public final void setHfin(LocalTime _h_fin) {
        this.h_fin = _h_fin;
    }

    public final void setLibelle(String _libelle) {
        if (_libelle.length() <= 30) {
            this.libelle = _libelle;
        }
    }

    public final void setRappel(boolean _rappel) {
        this.rappel = _rappel;
    }

    //autres methodes
    /**
     * Comparaison de RdV en fonction de leur date et si dates Ã©gales en fct de
     * leur horaire
     *
     * @param rdv1
     * @param rdv2
     * @return
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
     * ajouter un RdV (si le creneau date-horaire est libre) (Ã  faire dans
     * agenda ?)
     */
    /**
     * supprimer un RdV (Ã  faire dans Agenda ?)
     */
    /**
     * supprimer TOUS les RdVs (Ã  faire dans agenda ?)
     */

    @Override
    public int compareTo(RdV o) {
        
        int compare = this.getDate().compareTo(o.getDate());
        if(compare == 0){
            compare = this.getHdebut().compareTo(o.getHdebut());
        }
        return compare;       
    }
    
    @Override
    public String toString(){
        return "libelle : " + getLibelle()+  "date : " + getDate() + " Hdebut : " 
                + getHdebut() + "\n";
    }

}