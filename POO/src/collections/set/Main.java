/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashSet<Integer> hs=new HashSet();
        hs.add(1);
        hs.add(-1);
        hs.add(1);
        hs.add(0);
        hs.add(10);
        
        
        System.out.println("Affichage HashSet");
        for(Integer elt: hs){
            System.out.println(elt);
        }
        
        LinkedHashSet<Integer> lhs=new LinkedHashSet(hs);
       
        System.out.println("Affichage  LinkedHashSet");
        for(Integer elt: lhs){
            System.out.println(elt);
        }
        
        System.out.println("Affichage  TreeSet");
        TreeSet<Integer> ts=new TreeSet<>(hs);
          ts.add(50);
        
          for(Integer elt: ts){
            System.out.println(elt);
        }
        Set<Integer> set=new LinkedHashSet(hs);
                     set=new HashSet();
                     set=new TreeSet<>();
               
        
    }
    
}
