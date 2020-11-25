/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import models.Article;
import models.ISalutation;
import models.Lecteur;
import models.Redacteur;
import models.Utilisateur;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Utilisateur user =new Utilisateur();
        user.setPseudo("pseudo");
        user.setEmail("email");
        user.setMdp("mdp");
        user.setAvatar("Avatar");
        System.out.println(user);
        
        Utilisateur user1=new Utilisateur("pseudo","mdp");
        System.out.println(user1);
        
        Utilisateur user2=new Utilisateur("pseudo", "mdp", "email", "avatar");
        System.out.println(user2);
        
        //Polymorphisme=> Heritage
           //Objet
              Utilisateur user3=new Lecteur();
              Utilisateur user4=new Redacteur();
              
              
           //Methode => redefinition
              //System.out.println(user3.typeofClasse());
              //user3.salutation();//
              //Convertion => DownCasting
                //((Lecteur)user3).nomEnMajuscule()
              
              //System.out.println(user4.typeofClasse());
              
              Utilisateur tabUser[]={
                 new Lecteur(),
                 new Redacteur()
              };
              for(Utilisateur user5:tabUser){
                  user5.salutation();
              }
              //ManyToOne
              Article art=new Article();
              art.setRedacteur((Redacteur) user4);
              //OneToMany
              Redacteur redac=new Redacteur();
              Article tabArt[]={
                 new Article(),
                  new Article()
              };
              redac.setArticles(tabArt);
              
              
              ISalutation s=new Utilisateur();
              
    }
    
}
