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
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author asus
 */
public class Controleur {

    /**
     *Enregistre le contenu d'un agd dans un fichier texte
     */
    public static void SaveAgd(Agenda agd, String nomFichier) throws Exception {
       FileOutputStream fos;
       ObjectOutputStream oos;
       fos = new FileOutputStream(nomFichier);
       oos = new ObjectOutputStream(fos);
       oos.writeObject(agd);
       oos.flush();
       oos.close();
    }
    
    public static Agenda LoadAgd(String nomFichier) throws Exception {
        FileInputStream fis ;
        ObjectInputStream ois;
        fis = new FileInputStream(nomFichier);
        ois = new ObjectInputStream(fis);
        Agenda agd = (Agenda) ois.readObject();
        ois.close();
        return agd;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //GestionnaireIHM M = new GestionnaireIHM();
        
        ArrayList <RdV> a = new <RdV> ArrayList();
        
        RdV r1 = new RdV(LocalDate.parse("2018-11-07"), LocalTime.parse("11:00"), LocalTime.parse("12:00"), "r1", false);
        //a.add(r1);
        
        RdV r2 = new RdV(LocalDate.parse("2018-11-06"), LocalTime.parse("11:00"), LocalTime.parse("12:00"), "r2", false);
        //a.add(r2);
        
        RdV r3 = new RdV(LocalDate.parse("2018-11-07"), LocalTime.parse("13:00"), LocalTime.parse("14:00"), "r3", false);
        //a.add(r3);
        
        RdV r4 = new RdV(LocalDate.parse("1996-07-25"), LocalTime.parse("22:00"), LocalTime.parse("23:00"), "r4", true);
        //a.add(r4);
        
        
        
        Agenda a1 = new Agenda(a,"a");
        a1.ajoutRdV(r1);
        a1.ajoutRdV(r4);
        
        ArrayList <RdV> a2_list = new <RdV> ArrayList();
        Agenda a2 = new Agenda(a2_list, "a");
        
        try {
            SaveAgd(a1, "saved_agendas\\"+a1.getNom()+".bin");
            a2 = LoadAgd("saved_agendas\\"+a2.getNom()+".bin");
            
            for(RdV el : a2.getListe_RdV()){
            System.out.println(el.toString());
            }
            
            if(a2.getListe_RdV().size() == 0){
            System.out.println("a2.getListe_RdV est vide");
            }
            LocalDate d1 = LocalDate.parse("0000-01-01");
            LocalDate d2 = LocalDate.parse("9999-12-30");
            
            ArrayList <RdV> a2_trie = new <RdV> ArrayList();
            a2_trie = a2.afficherRdV(d1,d2);
            System.out.println("\n on reaffiche les rdv de a2 tries \n");
            for(RdV el : a2_trie){
                System.out.println(el.toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    
    
}
