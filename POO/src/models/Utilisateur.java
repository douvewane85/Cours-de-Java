/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author user
 */
public class Utilisateur implements ISalutation{
    protected String pseudo;
    protected String mdp;
    protected String email;
    protected String avatar;
    private boolean etat;

    public Utilisateur() {
    }

    //Se connecter
    public Utilisateur(String pseudo, String mdp) {
        this.pseudo = pseudo;
        this.mdp = mdp;
    }

    //Creer Utlisateur
    public Utilisateur(String pseudo, String mdp, String email, String avatar) {
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.email = email;
        this.avatar = avatar;
        this.etat=true;
    }
    
    //Getters

    public String getPseudo() {
        return pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }

    public boolean isEtat() {
        return etat;
    }
    //Setters

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "pseudo=" + pseudo + ", mdp=" + mdp + ", email=" + email + ", avatar=" + avatar + ", etat=" + etat + '}';
    }
    
    public String typeofClasse(){
        return "Utilisateur";
    }

    @Override
    public void salutation() {
        System.out.println("Je dis Bonjour , car je suis un utilisateur"); 
    }
    
    
    
    
    
    
    
    
    
}
