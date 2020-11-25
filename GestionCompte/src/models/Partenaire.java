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
public class Partenaire extends User {
    
    private String nci;
    private String nomComplet;
    private String adresse;
    private String tel;

    public Partenaire() {
        type="Partenaire";
    }

    public Partenaire(String nci, String nomComplet, String adresse, String tel, String login, String pwd) {
        super(login, pwd);
        this.nci = nci;
        this.nomComplet = nomComplet;
        this.adresse = adresse;
        this.tel = tel;
        type="Partenaire";
    }

    public Partenaire(String nci, String nomComplet, String adresse, String tel, int id, String login, String pwd) {
        super(id, login, pwd);
        this.nci = nci;
        this.nomComplet = nomComplet;
        this.adresse = adresse;
        this.tel = tel;
        type="Partenaire";
    }

    public String getNci() {
        return nci;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setNci(String nci) {
        this.nci = nci;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Partenaire{" + "nci=" + nci + '}';
    }
    
    
    
    
    
    
    
}
