/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author Victor Briere
 */
public class Personne {
    
    private String login;
    private String mdp;
    private String prenom;
    private String nom;
    private Agenda agd;

    //constructeur par defaut
    public Personne() {
        this.login = "";
        this.mdp = "";
        this.prenom = "";
        this.nom = "";
        this.agd = null;
    }

    //constructeur surchargé
    public Personne(String login, String mdp, String prenom, String nom, Agenda agd) {
        this.login = login;
        this.mdp = mdp;
        this.prenom = prenom;
        this.nom = nom;
        this.agd = agd;
    }

    //getters
    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public Agenda getAgd() {
        return agd;
    }

    
    //setters
    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAgd(Agenda agd) {
        this.agd = agd;
    }
    
}
