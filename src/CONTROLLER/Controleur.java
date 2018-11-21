/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;
import MODEL.Agenda;
import MODEL.RdV;
import VIEW.GestionnaireIHM;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;



/**
 *
 * @author asus
 */
public class Controleur {
    
    /**
     * Ouvrir l'agenda d'une personne specifiee ==> si boolean rappel == true;
     * afficher le libelle du RdV dans un pop-up 15min avant
     */
    //penser à creer l'objet correspondant et lui donner un nom avant d'appeler cette fct 
    //recuperer le nom de cet agenda à partir du fichier de la personne
    public static Agenda LoadAgd(Agenda agenda) {
        ObjectInputStream ois = null;
        Agenda loaded_agd= null;
        try {
            //on définit le fichier ou a ete serialise l'objet
            final FileInputStream fichier = new FileInputStream(agenda.getNom()+".ser");
            
            ois = new ObjectInputStream(fichier);
            //on deserialise l'objet a partir du fichier
            loaded_agd = (Agenda) ois.readObject();
            
            System.out.println("Agenda : ");

            System.out.println("nom : " + loaded_agd.getNom());
            System.out.println("Dans LoadAgd : ");
            
            for(RdV elem_agenda : agenda.getListe_RdV()){
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
    }
    
    
    
    public static void Load_Agd(Agenda agenda) {
        //on charge l'agenda à partir d'un fichier en lecture
        try {
                String fichier = "C:\\Users\\asus\\Desktop\\Nouveau_Projet_Agenda_ING3\\Projet_Agenda_Java_ING3-master\\saved_agendas\\"
                        + agenda.getNom() + ".txt";
                InputStream ips = new FileInputStream(fichier);
                InputStreamReader ipsr = new InputStreamReader(ips);
                BufferedReader br = new BufferedReader(ipsr);
                String ligne = null;
                ArrayList <RdV> liste_RdV = new <RdV> ArrayList();
                //do{
                    while ((ligne = br.readLine()) != null) {
                        //on stock les attributs du rdv sous forme de string dans un tab de string
                        System.out.println("dans la boucle de load");
                        String parsed_rdv[];
                        parsed_rdv = ligne.split("/");
                        //on cree un objet RdV avec ces elements du tab de string
                        RdV rdv = new RdV(/*LocalDate.parse(parsed_rdv[0]),LocalTime.parse(parsed_rdv[1]),
                            LocalTime.parse(parsed_rdv[2]),parsed_rdv[3],Boolean.valueOf(parsed_rdv[4])*/);
                        rdv.setDate(LocalDate.parse(parsed_rdv[0]));
                        rdv.setHdebut(LocalTime.parse(parsed_rdv[1]));
                        rdv.setHfin(LocalTime.parse(parsed_rdv[2]));
                        rdv.setLibelle(parsed_rdv[3]);
                        rdv.setRappel(Boolean.valueOf(parsed_rdv[4]));
                        //on ajoute ce rdv a la liste de rdv de l'objet agenda courant
                        //liste_RdV.add(rdv);
                        agenda.ajoutRdV(rdv);
                    }
                //}while(br.read()!=-1);
            br.close();
        } catch (Exception e) {
            System.out.print("Erreur d'ouverture du fichier en lecture\n");
        }
        
    }

    /**
     * sauvegarder l'agenda dans un fichier
     */
    public static void SaveAgd(Agenda agenda) {
        

        ObjectOutputStream oos = null;

        try {
            //on définit le fichier binaire de stockage de l'agenda
            final FileOutputStream fichier = new FileOutputStream(agenda.getNom()+".ser");

            oos = new ObjectOutputStream(fichier);
            //on serialise l'agenda courant dans le fichier
            oos.writeObject(agenda);
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
    }
    
    public static void Save_Agd(Agenda agenda) {
        System.out.println("dans Save_Agd");
        //on essaye d'ouvrir un fichier dans lequel enregistrer le contenu de l'agenda
        final File listeDeRdV = new File("C:\\Users\\asus\\Desktop\\Nouveau_Projet_Agenda_ING3\\Projet_Agenda_Java_ING3-master\\saved_agendas\\"
                + agenda.getNom() + ".txt");
        try {
            // Creation du fichier
            listeDeRdV.createNewFile();
            // creation d'un writer (un écrivain)
            final FileWriter writer = new FileWriter(listeDeRdV);
            try {

                for (RdV el : agenda.getListe_RdV()) {
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

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //GestionnaireIHM M = new GestionnaireIHM();
        
        ArrayList <RdV> a = new <RdV> ArrayList();
        
        /*RdV r1 = new RdV(LocalDate.parse("2018-11-07"), LocalTime.parse("11:00"), LocalTime.parse("12:00"), "r1", false);
        a.add(r1);
        
        RdV r2 = new RdV(LocalDate.parse("2018-11-06"), LocalTime.parse("11:00"), LocalTime.parse("12:00"), "r2", false);
        a.add(r2);
        
        RdV r3 = new RdV(LocalDate.parse("2018-11-07"), LocalTime.parse("13:00"), LocalTime.parse("14:00"), "r3", false);
        a.add(r3);
        
        RdV r4 = new RdV(LocalDate.parse("1996-07-25"), LocalTime.parse("22:00"), LocalTime.parse("23:00"), "r4", true);
        a.add(r4);*/
        
        
        
        Agenda a1 = new Agenda(a,"a");
        
        //Save_Agd(a1);
        
        Load_Agd(a1);
        
        for(RdV el : a1.getListe_RdV()){
            el.toString();
        }
        
        if(a1.getListe_RdV().size() == 0){
            System.out.println("a1.getListe_RdV est vide");
        }
        //LocalDate d1 = LocalDate.parse("0000-01-01");
        //LocalDate d2 = LocalDate.parse("9999-12-30");        
        
        //a1.afficherRdV(d1,d2);
        
    }
    
    
}
