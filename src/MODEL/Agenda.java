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
 * @author Victor BriÃ¨re
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
     * Ouvrir l'agenda d'une personne specifiee ==> si boolean rappel == true;
     * afficher le libelle du RdV dans un pop-up 15min avant
     */
    //penser à creer l'objet correspondant et lui donner un nom avant d'appeler cette fct 
    //recuperer le nom de cet agenda à partir du fichier de la personne
    /*public Agenda LoadAgd() {
        ObjectInputStream ois = null;
        Agenda loaded_agd= null;
        try {
            //on définit le fichier ou a ete serialise l'objet
            final FileInputStream fichier = new FileInputStream(this.getNom()+".ser");
            
            ois = new ObjectInputStream(fichier);
            //on deserialise l'objet a partir du fichier
            loaded_agd = (Agenda) ois.readObject();
            
            System.out.println("Agenda : ");

            System.out.println("nom : " + loaded_agd.getNom());
            
            for(RdV elem_agenda : this.getListe_RdV()){
                elem_agenda.toString();
            }

        } catch (final java.io.IOException e) {

            e.printStackTrace();

        } catch (final ClassNotFoundException e) {

            e.printStackTrace();

        } finally {

            try {

                if (ois != null) {

                    ois.close();

                }

            } catch (final IOException ex) {

                ex.printStackTrace();

            }

        }
        return loaded_agd;
    }*/
    
    
    
    /*public void Load_Agd() {
        //on charge l'agenda à partir d'un fichier en lecture
        try {
                String fichier = "C:\\Users\\asus\\Desktop\\Nouveau_Projet_Agenda_ING3\\Projet_Agenda_Java_ING3-master\\saved_agendas\\"
                        + this.getNom() + ".txt";
                InputStream ips = new FileInputStream(fichier);
                InputStreamReader ipsr = new InputStreamReader(ips);
                BufferedReader br = new BufferedReader(ipsr);
                String ligne = null;
                do{
                    while ((ligne = br.readLine()) != null) {
                        //on stock les attributs du rdv sous forme de string dans un tab de string
                        String parsed_rdv[];
                        parsed_rdv = ligne.split("/");
                        //on cree un objet RdV avec ces elements du tab de string
                        RdV rdv = new RdV(LocalDate.parse(parsed_rdv[0]),LocalTime.parse(parsed_rdv[1]),
                            LocalTime.parse(parsed_rdv[2]),parsed_rdv[3],Boolean.valueOf(parsed_rdv[4]));
                        //on ajoute ce rdv a la liste de rdv de l'objet agenda courant
                        this.ajoutRdV(rdv);
                        //on reinitialise l'objet rdv après qu'il ait ete stocke dans la liste de rdv de l'agenda courant
                        rdv = null;

                    }
                }while(br.read()!=-1);
            br.close();
        } catch (Exception e) {
            System.out.print("Erreur d'ouverture du fichier en lecture\n");
        }
        
    }*/

    /**
     * sauvegarder l'agenda dans un fichier
     */
    /*public void SaveAgd() {
        

        ObjectOutputStream oos = null;

        try {
            //on définit le fichier binaire de stockage de l'agenda
            final FileOutputStream fichier = new FileOutputStream(this.getNom()+".ser");

            oos = new ObjectOutputStream(fichier);
            //on serialise l'agenda courant dans le fichier
            oos.writeObject(this);
            //on vide le tampon dans le fichier
            oos.flush();

        } catch (final java.io.IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (oos != null) {

                    oos.flush();

                    oos.close();

                }

            } catch (final IOException ex) {

                ex.printStackTrace();

            }

        }
    }*/
    
    /*public void Save_Agd() {
        //on essaye d'ouvrir un fichier dans lequel enregistrer le contenu de l'agenda
        final File listeDeRdV = new File("C:\\Users\\asus\\Desktop\\Nouveau_Projet_Agenda_ING3\\Projet_Agenda_Java_ING3-master\\saved_agendas\\"
                + this.getNom() + ".txt");
        try {
            // Creation du fichier
            listeDeRdV.createNewFile();
            // creation d'un writer (un écrivain)
            final FileWriter writer = new FileWriter(listeDeRdV);
            try {

                for (RdV el : this.getListe_RdV()) {
                    //on enregistre 1 rdv par ligne
                    writer.write(el.toString());
                }
            } finally {
                // quoiqu'il arrive, on ferme le fichier
                writer.close();
            }
        } catch (Exception e) {
            System.out.println("Impossible de creer le fichier");
        }

    }*/

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
                    System.out.println("dans le if");
                    plage_RdV.add(elem_agenda);
                }
            }
            //on print la liste de rdv avant tri
            for(RdV el : plage_RdV){
                el.toString();
            }
            //on print la liste de rdv avant tri
            System.out.println("après tri");
            //on trie la liste de rdv triée
            Collections.sort(plage_RdV);
            for(RdV el : plage_RdV){
                el.toString();
            }

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
        //for (RdV elem_agenda : this.getListe_RdV()) {
            //si le creneau est libre on ajoute le rdv dans l'agenda
            /*if (!(_rdv.getDate().equals(elem_agenda.getDate())
                    && (_rdv.getHdebut().isAfter(elem_agenda.getHdebut()) && _rdv.getHdebut().isBefore(elem_agenda.getHfin())
                    || _rdv.getHfin().isAfter(elem_agenda.getHdebut()) && _rdv.getHfin().isBefore(elem_agenda.getHfin())))) {
                this.getListe_RdV().add(_rdv);
            }*/
            liste_RdV.add(_rdv);
        //}
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
