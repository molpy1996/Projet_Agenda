/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Victor Briere
 */
public class Agenda implements Serializable{

    ArrayList<RdV> liste_RdV;
    String nom;

    //constructeur par dÃ©faut
    public Agenda() {
        this.liste_RdV = null;
        this.nom = null;
    }

    //constructeur surchargÃ©
    public Agenda(ArrayList<RdV> _liste_RdV, String _nom) {
        this.liste_RdV = new <RdV> ArrayList();
        this.liste_RdV.addAll(_liste_RdV);
        this.nom = _nom;
    }

    //getters
    public ArrayList<RdV> getListe_RdV() {
        return this.liste_RdV;
    }

    public String getNom() {
        return nom;
    }

    //setter
    public void setNom(String nom) {
        this.nom = nom;
    }

    //autres methodes
    
    /**
     * retourne tous les Rdvs (par date et horaires croissants) entre 2 dates
     *
     * @param d1
     * @param d2
     * @return
     */
    public ArrayList<RdV> afficherRdV(LocalDate d1, LocalDate d2) {
        ArrayList<RdV> plage_RdV = new ArrayList();
        if (this.getListe_RdV() != null) {
            for (RdV elem_agenda : this.getListe_RdV()) {
                //si le rdv inscrit dans l'agenda est compris entre d1 et d2
                //d1<elem_agenda<d2 (OU d2<elem_agenda<d1 si d2<d1)
                if ((elem_agenda.getDate().isAfter(d1) && elem_agenda.getDate().isBefore(d2))
                        || (elem_agenda.getDate().isAfter(d2) && elem_agenda.getDate().isBefore(d1))) {                    
                    plage_RdV.add(elem_agenda);
                }
            }
            //on trie la liste de rdv qui sont entre les dates d1 et d2
            Collections.sort(plage_RdV);
        }

        return plage_RdV;
    }

    /**
     * renvoyer une arrayList des RdVs correspondant a un critere ou une
     * conjonction de criteres critères : entre 2 dates, entre 2 heures, avec un
     * certain libelle, avec un rappel = a 0 ou 1,
     *
     */
    public ArrayList<RdV> critereRdV() {
        ArrayList<RdV> conjonct_RdV = new <RdV> ArrayList();
        //appel des fonctions specifiques (critere_date_horaire, critere_libelle, critere_rappel
        return conjonct_RdV;
    }

    /**
     * modifier un RdV (s'occcupe pas de l'affichage)
     */
    public void modifierRdV() {
        //faire un switch avec 1 setter d'un attribut dans chaque case 
        //et des booléens pour chaque case qui permet de l'activer ou non
    }

    /**
     * ajouter un RdV (si le creneau date-horaire est libre)
     *
     * @param _rdv
     */
    public void ajoutRdV(RdV _rdv) {
        if(this.getListe_RdV().isEmpty()){ //si la liste de rdv de l'agenda est vide
            this.getListe_RdV().add(_rdv);
        }
        else if(this.getListe_RdV().size()==1) //si l'agenda n'a qu'un rdv stocké
        {
            if (!(_rdv.getDate().equals(this.getListe_RdV().get(0).getDate())
                        && (_rdv.getHdebut().isAfter(this.getListe_RdV().get(0).getHdebut()) && _rdv.getHdebut().isBefore(this.getListe_RdV().get(0).getHfin())
                        || _rdv.getHfin().isAfter(this.getListe_RdV().get(0).getHdebut()) && _rdv.getHfin().isBefore(this.getListe_RdV().get(0).getHfin())))) {
                    this.getListe_RdV().add(_rdv);
                }
        }
        
        else 
            for (RdV elem_agenda : this.getListe_RdV()) {
                //si le creneau est libre on ajoute le rdv dans l'agenda
                if (!(_rdv.getDate().equals(elem_agenda.getDate())
                        && (_rdv.getHdebut().isAfter(elem_agenda.getHdebut()) && _rdv.getHdebut().isBefore(elem_agenda.getHfin())
                        || _rdv.getHfin().isAfter(elem_agenda.getHdebut()) && _rdv.getHfin().isBefore(elem_agenda.getHfin())))) {
                    this.getListe_RdV().add(_rdv);
                }
            }
    }

    /**
     * supprimer un RdV
     *
     * @param _rdv
     */
    public void suppressionRdV(RdV _rdv) {
        //on supprime un rdv de l'agenda
        this.getListe_RdV().remove(_rdv);
        //on reinitialise a null l'objet rdv
        _rdv = null;
    }

    /**
     * supprimer TOUS les RdVs
     */
    public void suppressionRdV_all() {
        //on vide l'agenda de ses elements
        for (RdV elem_agenda : this.liste_RdV) {
            this.getListe_RdV().remove(elem_agenda);
        }
        //on reinitialise a null l'objet agenda
        //this.agd = null;
    }

}
