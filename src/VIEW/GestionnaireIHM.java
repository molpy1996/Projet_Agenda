/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.Agenda;
import MODEL.RdV;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class GestionnaireIHM {
    
    
    //Variables 
        int choix;
        int choix1;
        
        Scanner s = new Scanner(System.in);
        
    
        /**
         * Les premieres methodes ont ete faites afin d'aleger le GestionnaireIHM.
         * De plus c'est pour rendre le programme plus lisible et plus comprehensible
         */
        
    
        
    void aurevoir() /// Affichage fin du programme! 
        {
            
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("XXXXXXXXXXXXXXXXXXXX A BIENTOT ! XXXXXXXXXXXXXXXXXXXX");
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");               
            System.out.println();
            System.out.println();
        }
    
   
    
    
    final void message_erreur()  /// Message d'erreur !
    {
        System.out.println();
        System.out.println();
        System.out.println("################################################");
        System.out.println("##################### ERREUR ###################");
        System.out.println("################################################");
        System.out.println();
        System.out.println();
    }
   
    
    
    final void menu_principal ()
    {
        System.out.println();
        System.out.println("******************* MENU *******************");
        System.out.println("     (1) --> Creer un nouvel agenda  ");
        System.out.println("     (2) --> Ouvrir un agenda existant  ");
        System.out.println("     (3) --> Quitter        ");
        System.out.println("********************************************");
        System.out.println();
        System.out.println();
        System.out.println("#### VOTRE CHOIX #### ");
        choix=s.nextInt();
    }
    
    
    
    
    final void menu1()    /// Affichage du menu de la creation d'un nouvel agenda!
        {
            do {
                    System.out.println();
                    System.out.println("******************* CREATION D'UN NOUVEL AGENDA *******************");
                    System.out.println("     (1) --> Ajouter un Rdv        ");
                    System.out.println("     (2) --> Modifier un Rdv        ");
                    System.out.println("     (3) --> Sauvegarder & fermer l'agenda        ");
                    System.out.println("     (4) --> Retour au menu principal       ");
                    System.out.println("*******************************************************************");
                    System.out.println();
                    System.out.println();
                    System.out.println("#### VOTRE CHOIX #### ");
                    choix1=s.nextInt();                
             
                switch (choix1)

                    {
                        case 1 :
                        {
                            //Ajouter un Rdv
                            break;
                        }

                        case 2:
                        {
                            //Modifier un Rdv
                            break;
                        }

                        case 3:
                        {
                            //Sauvegarder et fermer avec retour au menu principal

                            GestionnaireIHM M = new GestionnaireIHM();
                            break;
                        }

                        case 4:
                        {
                            //retour au menu principal
                            GestionnaireIHM M = new GestionnaireIHM();
                            break;
                        }
                    
                
                
                        default:
                        {             
                           message_erreur();
                        }
                }

                } while (choix1!=1 && choix1!=2 && choix1!=3 && choix1!=4);
        }
    
    
   
    
    
     
     
    
    final void menu2()    /// Affichage du menu de l'agenda existant !
        {
            do {      /// Systeme de blindage ! 
                
                    System.out.println();
                    System.out.println("******************* AGENDA EXISTANT *******************");
                    System.out.println("     (1) --> Afficher tous les Rdv entre 2 dates  ");
                    System.out.println("     (2) --> Afficher les Rdv filtrés sur critere(s)  ");
                    System.out.println("     (3) --> Ajouter un Rdv        ");
                    System.out.println("     (4) --> Modifier un Rdv        ");
                    System.out.println("     (5) --> Supprimer un Rdv        ");
                    System.out.println("     (6) --> Supprimer tous les Rdv        ");
                    System.out.println("     (7) --> Sauvegarder & fermer l'agenda        ");
                    System.out.println("     (8) --> Retour au menu principal        ");
                    System.out.println("*******************************************************");
                    choix1=s.nextInt();
                    
                } while (choix1!=1 && choix1!=2 && choix1!=3 && choix1!=4 && choix1!=5 && choix1!=6 && choix1!=7 && choix1!=8);
            
            
            switch (choix1)
            {
                case 1 :
                {
                    //afficher tous les Rdv
                    break;
                }
                
                case 2:
                {
                    //Afficher les Rdv filtres sur criteres
                    break;
                }
                
                case 3 :
                {
                    //Ajouter un Rdv
                    break;
                }
                
                case 4:
                {
                    //Modifier un Rdv
                    break;
                }
                
                case 5 :
                {
                    //Supprimer un Rdv
                    break;
                }
                
                case 6:
                {
                    //Supprimer tous les Rdv
                    break;
                }
                
                case 7:
                {
                    //Sauvegarder et fermer un agenda
                    
                    //retour au menu
                    GestionnaireIHM M = new GestionnaireIHM();
                    break;
                }
                
                case 8 :
                {
                    GestionnaireIHM M = new GestionnaireIHM();
                            break;
                }
                
                default:
                {
                    message_erreur();
                }
            }
        }
    
    
    
    
    
    
    
    public GestionnaireIHM() /// Ceci
    {
   
        /**
         * Faire un systeme de connexion avec une lecture de fichier 
         * l'utilisateur doit se connecter ou creer un compte pour pouvoir utiliser l'agenda
         * Chaque utilisateur doit avoir son propre fichier txt
        */
     do
     {
            
        menu_principal();
        
        switch (choix)
        {
        
            case 1:
            {
                menu1();
                break;
             }
             
             
            
            case 2:
            {      
                menu2();
                break;            
            }
        
            case 3 :
            {
                /// Sauvegarder et fermer ! (Menu 1)
                break;
            }
            
            case 4 :
            {
                /// Retour au menu principal
                break;
            }
            
            default : 
            {
                message_erreur();
            }
        }
     } while(choix!=1 && choix!=2 && choix!=3);
     
     
     aurevoir();
     
    }  
       
    }


        

    

