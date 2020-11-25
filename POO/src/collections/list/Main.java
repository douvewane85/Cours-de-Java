/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
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
        ArrayList liste=new ArrayList();
        liste.add(2);
        liste.add("Bonjour");  
        liste.add(0, "Au revoir");
        
        System.out.println("Taille "+ liste.size());
        System.out.println("Elt Position 1 "+ liste.get(0));
        System.out.println("Affichage 1");
        for(Object elt:liste){
            System.out.println(elt);
        }
        
        liste.set(1, 4);
        System.out.println("Affichage 2");
        for(int i=0;i<liste.size();i++){
            System.out.println(liste.get(i));
        }
        
        System.out.println("Affichage 3");
         ListIterator it=liste.listIterator();
         while(it.hasNext()){
             System.out.println(it.next());
         }
         
         LinkedList listeBi=new LinkedList(liste);
         listeBi.add("Salutation");
         listeBi.remove(1);
         System.out.println("Affichage T-Q LinkedList 1");
        for(Object elt:listeBi){
            System.out.println(elt);
        }
        
        System.out.println("Affichage Q-T LinkedList 2");
        
        it=listeBi.listIterator(listeBi.size());
         while(it.hasPrevious()){
             System.out.println(it.previous());
         }
         //Liste Typée
          ArrayList<String> listeString=new ArrayList<>();
          listeString.add("Bonjour");
          //listeString.add(1);Erreur car la liste ne peut contenir que des String
         // LinkedList<int> listeInt=new LinkedList<>();
         //int n'est pas une classe
           LinkedList<Integer> listeInt=new LinkedList<>();
           listeInt.add(1);
           LinkedList<Utilisateur> listeUser=new LinkedList<>();
           listeUser.add(new Utilisateur());
           listeUser.add(new Lecteur());
           listeUser.add(new Redacteur());
                   
            for(Utilisateur elt1 : listeUser){
                System.out.println(elt1.typeofClasse());
            }
         //Polymorphisme
        List<Utilisateur> liste1=new LinkedList<>();
        List<Utilisateur> liste2=new ArrayList<>();
    }   
    
}
