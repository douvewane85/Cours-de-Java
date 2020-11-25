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
public class Lecteur extends Utilisateur{
    private String nomComplet;
    private String experience;
    private String detail;

    public Lecteur() {
    }

    public Lecteur(String pseudo, String mdp) {
        super(pseudo, mdp);
    }

    public Lecteur(String nomComplet, String experience, String detail, String pseudo, String mdp, String email, String avatar) {
        super(pseudo, mdp, email, avatar);
        this.nomComplet = nomComplet;
        this.experience = experience;
        this.detail = detail;
    }
    //Getters

    public String getNomComplet() {
        return nomComplet;
    }

    public String getExperience() {
        return experience;
    }

    public String getDetail() {
        return detail;
    }
    //setters

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return super.toString()+" Lecteur{" + "nomComplet=" + nomComplet + ", experience=" + experience + ", detail=" + detail + '}';
    }

    @Override
    public String typeofClasse() {
        return "Lecteur"; //To change body of generated methods, choose Tools | Templates.
    }
    
    public String nomEnMajuscule(){
        return nomComplet.toUpperCase();
    }

    @Override
    public void salutation() {
        System.out.println("Je dis Bonjour , car je suis un Lecteur"); 
    }
    
    
    
    
    
    
    
    
    
}
