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
public class Redacteur extends Utilisateur {

    
    //Attribut de Navigation
    //OneToMany
     private Article articles[]=new Article[10] ;
    @Override
    public String typeofClasse() {
        return "Redacteur"; //To change body of generated methods, choose Tools | Templates.
    }

    public Article[] getArticles() {
        return articles;
    }

    public void setArticles(Article[] articles) {
        this.articles = articles;
    }
    
    
    
}
